package org.spring04.webmvc;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 相当于在web.xml中配置DispatcherServlet
 * @author kwz
 *
 */
public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	/**
	 * 用于其他的bean
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {RootConfig.class};
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		System.out.println("----SpittrWebAppInitializer----");
		super.onStartup(servletContext);
	}

	/**
	 * DispatcherServlet加载包含Web组件的bean，如控制器、视图解析器以及映射器映射
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {WebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

}
