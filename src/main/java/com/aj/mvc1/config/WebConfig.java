package com.aj.mvc1.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Controller

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/course").setViewName("courses.html");
        registry.addViewController("/about").setViewName("about.html");
       // registry.addViewController("/contact").setViewName("contact.html");
    }
}
