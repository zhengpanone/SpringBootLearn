package com.zp.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * DataSourceAop
 *
 * @author zhengpanone
 * @since 2021-09-22
 */
@Aspect
@Component
public class DataSourceAop {
@Pointcut("!@annotation(com.zp.annotation.Master)"+ "&&execution(* com.zp.service..*.select*(..))")
    public void readPointcut(){

    }
}
