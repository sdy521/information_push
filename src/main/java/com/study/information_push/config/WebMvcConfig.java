package com.study.information_push.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.MultipartConfigElement;
import java.io.File;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    @Value("${notice.location}")
    private String location;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/imgPath/**").addResourceLocations("file:"+location+ File.separator);
        super.addResourceHandlers(registry);
    }

}
