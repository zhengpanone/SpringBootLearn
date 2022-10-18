package com.zp.log;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * MyLogInterceptor
 * 自定义日志拦截器
 *
 * @author zhengpanone
 * @since 2022-10-18
 */
public class MyLogInterceptor implements HandlerInterceptor {
    private static final ThreadLocal<Long> startTimeThreadLocal = new ThreadLocal<>();

    // 在controller方法执行之前执行此方法
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(handler instanceof HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();// 获取被拦截的方法对象
            MyLog annotation = method.getAnnotation(MyLog.class);// 获得方法上的注解
            if (annotation != null) {
                // 当前方法加入了MyLog注解
                long startTime = System.currentTimeMillis();
                startTimeThreadLocal.set(startTime);
            }
        }else if(handler instanceof ResourceHttpRequestHandler){
            System.out.println(handler);
        }

        return true;
    }

    // 在controller方法执行之后执行此方法
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if(handler instanceof HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();// 获取被拦截的方法对象
            MyLog annotation = method.getAnnotation(MyLog.class);// 获得方法上的注解
            if (annotation != null) {
                long startTime = startTimeThreadLocal.get();
                long endTime = System.currentTimeMillis();
                long optTime = endTime - startTime;
                String uri = request.getRequestURI();
                String methodName = method.getDeclaringClass().getName() + "." + method.getName();
                String methodDesc = annotation.desc();
                System.out.println("请求uri" + uri);
                System.out.println("请求方法名" + methodName);
                System.out.println("方法描述" + methodDesc);
                System.out.println("方法执行时间" + optTime);
            }
        }else if(handler instanceof ResourceHttpRequestHandler){
            System.out.println(handler);
        }

    }
}
