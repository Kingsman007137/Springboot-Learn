package com.example.aop;

import com.alibaba.fastjson.JSONObject;
import com.example.mapper.OperateLogMapper;
import com.example.pojo.OperateLog;
import com.example.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Component
@Slf4j
@Aspect //切面类
public class LogAspect {
    @Autowired
    private HttpServletRequest request; //怎么就注入了呢。。
    @Autowired
    private OperateLogMapper operateLogMapper;

    @Around("@annotation(com.example.anno.Log)")
    public Object recordLog(ProceedingJoinPoint joinPoint) throws Throwable {
        // 操作人ID - 当前登录员工id - 解析jwt令牌得id
        String jwt = request.getHeader("token");
        Claims claims = JwtUtils.parseJWT(jwt);
        Integer operateUser = (Integer) claims.get("id");
        // 操作时间
        LocalDateTime operateTime = LocalDateTime.now();
        // 操作类名
        String className = joinPoint.getTarget().getClass().getName();
        // 操作方法名
        String methodName = joinPoint.getSignature().getName();
        // 操作方法参数
        Object[] args = joinPoint.getArgs();
        String methodParam = Arrays.toString(args);

        long begin = System.currentTimeMillis();
        // 调用原始目标方法
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        // 操作方法返回值
        String returnValue = JSONObject.toJSONString(result);
        // 操作耗时
        long costTime = end - begin;
        //记录操作日志
        OperateLog operateLog = new OperateLog(null, operateUser, operateTime, className, methodName,
                                    methodParam, returnValue, costTime);
        operateLogMapper.insert(operateLog);
        log.info("AOP记录操作日志：{}", operateLog);
        return result;
    }
}
