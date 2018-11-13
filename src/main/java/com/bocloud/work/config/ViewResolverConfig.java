package com.bocloud.work.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * 
 * 定义页面前后缀的Bean
 * 
 * @author DZG
 * @since V1.0 2017年7月11日
 */
@Configuration
public class ViewResolverConfig {

	@Bean
	@ConditionalOnMissingBean(InternalResourceViewResolver.class)
	public InternalResourceViewResolver defaultViewResolver() {
		InternalResourceViewResolver view = new InternalResourceViewResolver("", ".html");
		return view;
	}
}
