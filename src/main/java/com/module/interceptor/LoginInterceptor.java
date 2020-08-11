package com.module.interceptor;

import com.module.entity.blogUser;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try{
            blogUser user = (blogUser) request.getSession().getAttribute("user");
            if (user != null) return true;
            response.sendRedirect(request.getContextPath()+"/loginJump");
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
