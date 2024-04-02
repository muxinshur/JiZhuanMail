package com.mail.interfaces.config;

import com.mail.interfaces.filter.CorsFilter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import jakarta.servlet.*;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<Filter> CorsFilterRegistration() {
        FilterRegistrationBean<Filter> registration = new FilterRegistrationBean<Filter>();
        String urlPatterns = "/";
        registration.addUrlPatterns(StringUtils.split(urlPatterns, ","));
        registration.setName("myCorsFilter");
        registration.setDispatcherTypes(DispatcherType.REQUEST);
        registration.setFilter(new CorsFilter());
        registration.setOrder(1);
        registration.setEnabled(true);
        return registration;
    }

}
