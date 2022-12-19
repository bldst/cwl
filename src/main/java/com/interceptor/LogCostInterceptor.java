package com.interceptor;

import com.Service.TokenMangerService;
import com.config.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 拦截器
 */
@Slf4j
@Component
public class LogCostInterceptor implements HandlerInterceptor {
    @Autowired
    private TokenMangerService tokenMangerService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        //放行options请求： OPTIONS的预请求(Preflighted Request), 用于试探服务端是否能接受真正的请求
        String methodRequest = request.getMethod();
        if (methodRequest.equalsIgnoreCase("OPTIONS"))
            return true;
        //校验token,判断合法

        System.out.println("拦截器--token校验");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Headers", "*");
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        try {
            String token = request.getHeader("token");
            //签名校验

            JwtUtil.checkSign(token);
            log.info("=======>签名校验通过");
            //redis token存在性校验
            if(!tokenMangerService.CheckToken(token)){
                 response.getWriter().println("token 验证不通过!");
                 return false;
            }
            log.info("=======>token存在性校验通过");
        } catch (Exception e) {
            //设置response状态
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            response.getWriter().println("token 验证不通过!");

            System.out.println(e);
            return false;
        }


        System.out.println("验证通过");


        return true;

    }


}

