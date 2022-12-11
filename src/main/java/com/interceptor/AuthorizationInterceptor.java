package com.interceptor;

import com.Utils.JwtUtil;
import com.Utils.Permissions;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * 登陆权限拦截器
 */
public class AuthorizationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HandlerMethod handlerMethod=(HandlerMethod)handler;
        Method method = handlerMethod.getMethod();

        String token = request.getHeader("token");
        //签名校验

        Map<String, Object> info = JwtUtil.getInfo(token);
        String userType = (String) info.get("userType");
        System.out.println("登陆权限为："+userType);
        //验证登陆角色是否匹配
        Permissions permissionsAnnotation=method.getAnnotation(Permissions.class);
        if (!permissionsAnnotation.role().equals(userType)){
            response.getWriter().println("无权限操作");
            return false;
        }
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
