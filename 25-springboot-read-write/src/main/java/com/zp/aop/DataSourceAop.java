package com.zp.aop;

import com.zp.bean.DBContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * DataSourceAop
 * 设置路由key
 *
 * @author zhengpanone
 * @since 2021-09-22
 */
@Aspect
@Component
@Slf4j
public class DataSourceAop {
    @Pointcut("!@annotation(com.zp.annotation.Master)" +
            "&&execution(* com.zp.service..*.select*(..))" +
            "|| execution(* com.zp.service..*.get*(..))")
    public void readPointcut() {

    }

    @Pointcut("@annotation(com.zp.annotation.Master)" +
            "||execution(* com.zp.service..*insert*(..))" +
            "||execution(* com.zp.service..*add*(..))" +
            "||execution(* com.zp.service..*update*(..))" +
            "||execution(* com.zp.service..*edit*(..))" +
            "||execution(* com.zp.service..*delete*(..))" +
            "||execution(* com.zp.service..*remove*(..))")
    public void writePointcut() {

    }

    @Before("readPointcut()")
    public void read() {
        DBContextHolder.slave();
        log.info("readPointcut");
    }

    @Before("writePointcut()")
    public void write() {
        DBContextHolder.master();
        log.info("writePointcut");
    }

    /*//第二种写法
    @Before("execution(* com.zp.service.impl.*.*(..))")
    public void before(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        if (StringUtils.startsWithAny(methodName, "get", "select", "find")) {
            DBContextHolder.slave();
        } else {
            DBContextHolder.master();
        }

    }*/
}
