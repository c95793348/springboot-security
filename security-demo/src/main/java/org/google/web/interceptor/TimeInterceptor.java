package org.google.web.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Created by wbcaoa on 2018/3/27.
 */
@Component
public class TimeInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("time interceptor preHandle!");

        System.out.println(((HandlerMethod)o).getBean().getClass());
        System.out.println(((HandlerMethod)o).getMethod().getName());

        httpServletRequest.setAttribute("startTime",new Date().getTime());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("time interceptor postHandle!");
        Long startTime = (Long) httpServletRequest.getAttribute("startTime");
        System.out.println("time interceptor 耗时: " + (new Date().getTime() - startTime));
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("time interceptor afterCompletion!");
        Long startTime = (Long) httpServletRequest.getAttribute("startTime");
        System.out.println("异常信息 : " + e);
        System.out.println("time interceptor 耗时: " + (new Date().getTime() - startTime));
    }
}
