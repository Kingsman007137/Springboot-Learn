package com.example.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import org.springframework.stereotype.Component;

import java.io.IOException;

//@Component
////@WebFilter(urlPatterns = "/*") //指定所有路径都要拦截过滤
//public class DemoFilter implements Filter {
//    @Override// 初始化程序，执行一次
//    public void init(FilterConfig filterConfig) throws ServletException {
//        //System.out.println("初始化程序执行了");
//    }
//
//    @Override// 拦截程序，拦截到请求就会执行
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        //System.out.println("拦截了请求");
//        // 放行请求，只有这样才能访问到资源
//        //filterChain.doFilter(servletRequest, servletResponse);
//    }
//
//    @Override// 销毁程序，执行一次
//    public void destroy() {
//        //System.out.println("销毁程序执行了");
//        //Filter.super.destroy();
//    }
//}
