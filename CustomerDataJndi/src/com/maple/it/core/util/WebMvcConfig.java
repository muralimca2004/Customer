package com.maple.it.core.util;

import org.apache.log4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
//import org.springframework.web.servlet.view.ResourceBundleViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.maple.it.core")
public class WebMvcConfig extends WebMvcConfigurerAdapter{
	
	private Logger log = Logger.getLogger(WebMvcConfig.class);
			
	@Bean
    public ViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/");        
        viewResolver.setSuffix(".jsp");
        //viewResolver.setViewNames(new String[]{"*.jsp"});
        viewResolver.setOrder(1); // must be lowest priority(largest order number), so that other resolvers will  have chance to resolve views  
        
        return viewResolver;
    }
    
	// Thymeleaf template resolver serving HTML 5
	@Bean
	@Description("Thymeleaf Template Resolver")
	public SpringResourceTemplateResolver templateResolver() {
		SpringResourceTemplateResolver springTemplateResolver = new SpringResourceTemplateResolver();
		springTemplateResolver.setPrefix("/views/");
		springTemplateResolver.setSuffix(".html");
		springTemplateResolver.setTemplateMode("HTML5");
		springTemplateResolver.setCacheTTLMs(3600000L);
		return springTemplateResolver;
	}
	
	@Bean
	@Description("Thymeleaf Template Engine")
	public SpringTemplateEngine templateEngine() {
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(templateResolver());
		templateEngine.setTemplateEngineMessageSource(messageSource());
		return templateEngine;
	}
	
	@Bean
	@Description("Thymeleaf View Resolver")
	public ThymeleafViewResolver viewResolver() {
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(templateEngine());
		viewResolver.setViewNames(new String[]{"th_*"});
		//viewResolver.setExcludedViewNames(excludedViewNames);
		viewResolver.setOrder(0);
		return viewResolver;
	}
	
	/*@Bean
    public ViewResolver resourceBundleViewResolver() {
		ResourceBundleViewResolver viewResolver = new ResourceBundleViewResolver();
        viewResolver.setBasename("spring-mvc-views_en");
        viewResolver.setOrder(0);
        
        return viewResolver;        
    }*/
	
    @Bean
    @Description("Spring Message Resolver")
    public MessageSource messageSource() {
    	
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        
        return messageSource;
    }
    
    // Static Resource Config
    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
    	
    	// CSS and JS resource
    	registry.addResourceHandler("/resources/**").addResourceLocations("/resources/").setCachePeriod(31556926);
    
    }
    
    /**
     * To redirect to static home page
     *    without a controller
     */    
	/*public void addViewControllers(ViewControllerRegistry registry) {
		
		log.info("Inside.." + new Object() {}.getClass().getEnclosingMethod().getName());
		//this will map uri to jsp view directly without a controller
		registry.addViewController("/").setViewName("forward:/index.html");
	}*/
	
}