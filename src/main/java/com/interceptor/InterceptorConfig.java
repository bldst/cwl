package com.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * 拦截器配置
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {

    @Override public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogCostInterceptor()).addPathPatterns("/index/**")
                .excludePathPatterns("/index/register/**")
                .excludePathPatterns("/index/login/**")
                .excludePathPatterns("/index/getMatch/**");


        super.addInterceptors(registry);
        System.out.println("拦截");

    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}

