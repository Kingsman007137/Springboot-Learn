package com.example.filter;

import com.alibaba.fastjson.JSONObject;
import com.example.pojo.Result;
import com.example.utils.JwtUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.IOException;

//@Slf4j
//@WebFilter(urlPatterns = "/*") //指定所有路径都要拦截过滤
//public class LoginCheckerFilter implements Filter {
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest req = (HttpServletRequest) servletRequest;
//        HttpServletResponse resp = (HttpServletResponse) servletResponse;
//
//        //获取请求url
//        String url = req.getRequestURI();
//        log.info("获取请求url: {}", url);
//
//        //判断请求url中是否包含login，如果包含，说明是登录请求，放行
//        if (url.contains("login")) {
//            log.info("登录请求，放行...");
//            filterChain.doFilter(servletRequest, servletResponse);
//            return;
//        }
//
//        //获取请求头中的令牌(token)
//        String jwt = req.getHeader("token");
//
//        //判断令牌是否存在，如果不存在，返回错误信息(未登录)
//        if (!StringUtils.hasLength(jwt)) {
//            log.info("请求头token为空，返回未登录的信息");
//            Result error = Result.error("NOT_LOGIN");
//            //没有@RequestController注解，手动转换 对象---->JSON， 用到阿里巴巴fastJSON
//            String notLogin = JSONObject.toJSONString(error);
//            //没有返回对象，但可以直接在响应里面写入信息
//            resp.getWriter().write(notLogin);
//            return;
//        }
//
//        //解析token，如果解析失败，则返回错误信息(未登录)
//        try {
//            JwtUtils.parseJWT(jwt);
//        } catch (Exception e) {//解析失败
//            e.printStackTrace();
//            log.info("令牌解析失败，返回错误信息");
//            Result error = Result.error("NOT_LOGIN");
//            String notLogin = JSONObject.toJSONString(error);
//            resp.getWriter().write(notLogin);
//            return;
//        }
//
//        //放行
//        log.info("令牌合法，放行");
//        filterChain.doFilter(servletRequest, servletResponse);
//    }
//}
