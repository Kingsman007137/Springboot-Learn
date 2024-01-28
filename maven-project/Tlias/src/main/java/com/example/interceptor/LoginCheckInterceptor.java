package com.example.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.example.pojo.Result;
import com.example.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    //目标资源方法执行前执行。 返回true：放行    返回false：不放行
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
        //获取请求url
        String url = req.getRequestURI();
        log.info("获取请求url: {}", url);

        //判断请求url中是否包含login，如果包含，说明是登录请求，放行
        if (url.contains("login")) {
            log.info("登录请求，放行...");
            return true;
        }

        //获取请求头中的令牌(token)
        String jwt = req.getHeader("token");

        //判断令牌是否存在，如果不存在，返回错误信息(未登录)
        if (!StringUtils.hasLength(jwt)) {
            log.info("请求头token为空，返回未登录的信息");
            Result error = Result.error("NOT_LOGIN");
            //没有@RequestController注解，手动转换 对象---->JSON， 用到阿里巴巴fastJSON
            String notLogin = JSONObject.toJSONString(error);
            //没有返回对象，但可以直接在响应里面写入信息
            resp.getWriter().write(notLogin);
            return false;
        }

        //解析token，如果解析失败，则返回错误信息(未登录)
        try {
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) {//解析失败
            e.printStackTrace();
            log.info("令牌解析失败，返回错误信息");
            Result error = Result.error("NOT_LOGIN");
            String notLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return false;
        }

        //放行
        log.info("令牌合法，放行");
        return true;
    }

    //目标资源方法执行后执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle...");
    }

    //视图渲染完毕后执行，最后执行
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        System.out.println("afterCompletion...");
    }
}
