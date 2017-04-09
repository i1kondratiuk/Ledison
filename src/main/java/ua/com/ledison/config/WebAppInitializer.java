package ua.com.ledison.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebAppInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {

		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(WebConfig.class);

		DispatcherServlet dispatcherServlet = new DispatcherServlet(context);

		DelegatingFilterProxy delegatingFilterProxy = new DelegatingFilterProxy();
		servletContext.addFilter("springSecurityFilterChain", delegatingFilterProxy).addMappingForUrlPatterns(null, false,"/*");

		ServletRegistration.Dynamic register = servletContext.addServlet("dispatcherServlet", dispatcherServlet);
		register.setMultipartConfig(new MultipartConfigElement("", 100000000, 100000000, 100000000));
		register.setLoadOnStartup(1);
		register.addMapping("/");
	}
}