package com.interceptor;

import com.Mapper.UserMapper;
import com.Utils.JwtUtil;
import com.Utils.Permissions;
import com.Utils.ResultMsg;
import com.Utils.ResultStatusEnum;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Map;


/**
 * 拦截器
 */
public class LogCostInterceptor implements HandlerInterceptor {
    @Autowired
    UserMapper userMapper ;

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

            System.out.println("token校验通过");


        } catch (Exception e) {
            //设置response状态
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            response.getWriter().println("token 验证不通过!");

            System.out.println(e);
            return false;
        }
        //数据库token存在性校验


        System.out.println("验证通过");


        return true;

    }


}

