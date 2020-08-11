package com.module.config;

import com.module.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class LoginConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration registration = registry.addInterceptor(new LoginInterceptor());
        registration.addPathPatterns("/**");
        registration.excludePathPatterns("/index", "/loginJump", "/login","/**/*.html",
                "/**/*.css","/**/*.js","/**/*.otf",
                "/**/*.eot","/**/*.svg","/**/*.ttf",
                "/**/*.woff","/**/*.woff2");
    }
}
