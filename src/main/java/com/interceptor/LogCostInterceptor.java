package com.interceptor;

import com.Utils.JwtUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;


/**
 * 拦截器
 */
public class LogCostInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //校验token,判断合法

        System.out.println("拦截器--token校验");

        try {
            String token = request.getHeader("token");
            JwtUtil.checkSign(token);
        } catch (Exception e) {
            //设置response状态
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            response.getWriter().println("token 验证不通过!");

            System.out.println("token不存在或者已过期");

            return false;
        }


        System.out.println("验证通过");


        return true;

    }



}

