package com.raulavila.spring.mvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.raulavila.spring.mvc")
public class WebAppConfig extends WebMvcConfigurerAdapter {
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("js/**").addResourceLocations("js/");
    }
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
	    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	    viewResolver.setViewClass(JstlView.class);
	    viewResolver.setPrefix("/jsp/");
	    viewResolver.setContentType("text/html; charset=UTF-8");
	    viewResolver.setSuffix(".jsp");
	    return viewResolver;
	}
	
}
