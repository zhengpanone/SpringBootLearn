package com.zp.aspect;

import cn.hutool.extra.servlet.ServletUtil;
import com.zp.annotation.RateLimiter;
import com.zp.enums.LimitType;
import com.zp.exception.RateLimitException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Objects;

/**
 * Author : zhengpanone
 * Date : 2024/2/1 14:04
 * Version : v1.0.0
 * Description: TODO
 */
@Aspect
@Component
@Slf4j
public class RateLimitAspect {
    @Autowired
    RedisTemplate<String, Object> redisTemplate;
    @Autowired
    RedisScript<Long> redisScript; // 实现类为DefaultRedisScript<Long> limitScript()

    @Pointcut("@annotation(com.zp.annotation.RateLimiter)")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void beforeRateLimit(JoinPoint joinPoint) {
        // 获取注解上的值
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        RateLimiter rateLimiter = AnnotationUtils.findAnnotation(methodSignature.getMethod(), RateLimiter.class);
        int time = rateLimiter.time();
        int count = rateLimiter.count();
        // 构建redis中的key值
        String limitKey = getRateLimitKey(rateLimiter, methodSignature);
        System.out.println("redis中key值：" + limitKey);
        try {
            Long current = redisTemplate.execute(redisScript, Collections.singletonList(limitKey), time, count);
            if (current == null || current.intValue() > count) {
                log.info("当前接口达到最大限流次数");
                throw new RateLimitException(500, "当前接口达到最大限流次数");
            }
            log.info("一段时间内允许的请求次数:{},当前请求次数:{},缓存key为:{}", count, current, limitKey);
        } catch (Exception e) {
            throw e;
        }


    }

    private String getRateLimitKey(RateLimiter rateLimiter, MethodSignature methodSignature) {
        StringBuffer key = new StringBuffer(rateLimiter.key());
        if (rateLimiter.limitType() == LimitType.IP) { // 如果参数类型为IP
            // 获取客户端IP
            String clientIP = ServletUtil.getClientIP(((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest());
            key.append(clientIP).append("-");
        }
        Method method = methodSignature.getMethod();
        // 获取全类名
        String className = method.getDeclaringClass().getName();
        // 获取方法名
        String methodName = method.getName();
        key.append(className).append("-").append(methodName);
        System.out.println("全类名+方法名" + className + "-" + methodName);
        return key.toString();
    }

}
