package com.config;


import com.interceptor.LogCostInterceptor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器配置
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
  @Autowired
  LogCostInterceptor logCostInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(logCostInterceptor).addPathPatterns("/index/**")
                .addPathPatterns("/admin/change/**")
                .addPathPatterns("/admin/device/**")

                .excludePathPatterns("/admin/device/login/**")
                .excludePathPatterns("/index/register/**")
                .excludePathPatterns("/index/login/**")
                .excludePathPatterns("/index/getMatch/**");





        System.out.println("=======拦截器启动成功====");

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}

