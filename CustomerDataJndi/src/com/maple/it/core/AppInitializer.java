package com.maple.it.core;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
 
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.maple.it.core.util.WebMvcConfig;
 
public class AppInitializer implements WebApplicationInitializer {
 
    public void onStartup(ServletContext container) throws ServletException {
    	
    	// Create the 'root' Spring application context
        AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
        dispatcherContext.register(WebMvcConfig.class);
        dispatcherContext.setServletContext(container);
        dispatcherContext.refresh();
        
        // Register and map the dispatcher servlet
        ServletRegistration.Dynamic dispatcher = container.addServlet(
                "dispatcher", new DispatcherServlet(dispatcherContext));
 
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
 
}