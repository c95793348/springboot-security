package org.google.web.config;

import org.google.web.filter.TimeFilter;
import org.google.web.interceptor.TimeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wbcaoa on 2018/3/27.
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter{

    @Autowired private TimeInterceptor timeInterceptor;

    /**
     * 替代spring异步线程池 线程可重用 默认不重用线程。
     * @param configurer
     */
//    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
//        configurer.
//    }

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(timeInterceptor);
    }

    /**
     * 配置第三方过滤器方法
     * @return
     */
    @Bean
    public FilterRegistrationBean timeFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        TimeFilter timeFilter = new TimeFilter();

        filterRegistrationBean.setFilter(timeFilter);

        List<String> urls = new ArrayList<>();
        urls.add("/*");
        filterRegistrationBean.setUrlPatterns(urls);

        return filterRegistrationBean;
    }

}
