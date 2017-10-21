package org.spring09.security;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.spring09.security.configuration.StartConfiguration;
import org.spring09.security.configuration.web.StartWebConfiguration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 配置spring，不用在xml中配置了
 *
 */
public class StartInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		super.onStartup(servletContext);
		System.out.println("StartInitializer-startup...");
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[]{StartConfiguration.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {StartWebConfiguration.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
}
