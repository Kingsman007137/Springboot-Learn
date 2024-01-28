package com.example.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Component
//@Aspect //AOP类
public class TimeAspect {

    @Around("execution(* com.example.service.*.*(..))") //切入点表达式
    //ProceedingJoinPoint API 封装原始方法的信息
    public Object recordTime(ProceedingJoinPoint joinPoint) throws Throwable {
        //获取开始时间
        long begin = System.currentTimeMillis();

        //调用原始方法并执行
        Object result = joinPoint.proceed(); //原始方法返回的东西也要返回去

        //获取结束时间，并计算耗时
        long end = System.currentTimeMillis();
        //获取原始方法名
        log.info(joinPoint.getSignature() + "耗时：{}ms", end-begin);

        return result;
    }
}
