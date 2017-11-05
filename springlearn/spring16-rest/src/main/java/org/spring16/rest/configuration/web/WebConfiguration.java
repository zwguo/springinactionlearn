package org.spring16.rest.configuration.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Configuration
@ComponentScan("org.spring16.rest.web")
@EnableWebMvc
public class WebConfiguration extends WebMvcConfigurerAdapter {

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
		super.configureDefaultServletHandling(configurer);
	}
	
	@Bean
	public ViewResolver cnViewResolver(ContentNegotiationManager cnm) {
		ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
		resolver.setContentNegotiationManager(cnm);
		return resolver;
	}

	/**
	 * 获取ContentNegotiationManager
	 */
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.defaultContentType(MediaType.TEXT_HTML);
	}
	
	@Bean
	public ViewResolver beanNameViewResolver() {
		return new BeanNameViewResolver();
	}
	
	/**
	 * 打开后，报错：严重: Allocate exception for servlet dispatcher
java.lang.ClassNotFoundException: com.fasterxml.jackson.databind.Module
	没找到原因
	
	一直找了半小时，找到：http://www.cnblogs.com/mingbai/p/6886052.html，才发现需要添加：2.6.2的版本，2.0.2和2.9.2都不行。
	 */
	/**
	 * 通过beanNameViewResolver()和spittles方法，把逻辑视图名为spittles的视图转成json格式。
	 * @return
	 */
	@Bean
	public View spittles() {
		return new MappingJackson2JsonView();
	}

}
