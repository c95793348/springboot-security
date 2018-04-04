package org.google.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by wbcaoa on 2018/3/27.
 * AOP 切片
 * 切片类
 * 切入点
 * 增强
 */
@Aspect
@Component
public class TimeAspect {

    /**
     * Aroud是切入的时间点
     * 注解的表达式是切入在哪些方法上
     */
    @Around("execution(* org.google.web.controller.UserController.*(..))")
    public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {

        System.out.println("time aspect start!");

        Object[] args = pjp.getArgs();
        for (Object arg : args) {
            System.out.println(arg);
        }

        long startTime = new Date().getTime();

        Object obj = pjp.proceed();

        System.out.println("time aspect 耗时: " + (new Date().getTime() - startTime));

        System.out.println("time aspect end!");

        return obj;
    }

}
