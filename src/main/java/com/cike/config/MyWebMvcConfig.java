package com.cike.config;

import com.cike.intercepter.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author CIKE
 * @desc ${DESCRIPTION}
 * @create 2017-09-15 8:55
 **/
@Configuration
public class MyWebMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/wechat/**")
                .excludePathPatterns("/login/**");
        super.addInterceptors(registry);
    }
}
