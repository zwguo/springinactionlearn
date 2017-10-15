package org.spring04.webmvc;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;

/**
 * 测试是否调用此方法
 * @author kwz
 *
 */
public class WebApplicationInitializerTest implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		System.out.println("----WebApplicationInitializerTest----");
	}

}
