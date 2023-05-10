package com.i2f.springboot.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Author：jinwwenm
 * @Description:
 * @Date: Created in 19:51 2023/3/22
 */
@Aspect
@Component
public class LogAspect {
    @Pointcut("execution(* com.i2f.springboot.service.impl.PdfServiceImpl.*(..))")
    public void logPointcut(){
    }
    @Around("logPointcut()")
    public void process(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //前置增强
        System.out.println("前置增强");
        Object proceed = proceedingJoinPoint.proceed();
        //后置增强
        System.out.println("后置增强"+proceed);
    }
}
