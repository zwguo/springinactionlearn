package org.spring06.webmvc.senior.webmvc;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.DispatcherServlet;

//public class WebApplicationInitializerTest implements WebApplicationInitializer{
//
//	@Override
//	public void onStartup(ServletContext servletContext) throws ServletException {
//		ServletRegistration.Dynamic registration = 
//				servletContext.addServlet("appServlet", DispatcherServlet.class);
//		registration.addMapping("/");
//		registration.setMultipartConfig(new MultipartConfigElement("/tmp/uploadtest"));
//	}
//
//}
