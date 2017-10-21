package org.spring09.security;

import javax.servlet.ServletContext;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * 配置security，会自动查找springSecurityFilterChain的bean作为filter
 * 可以用xml配置，则需要DispatcherServlet和Filter：filtername如上，class是：org.springframework.web.filter.DelegatingFilterProxy
 * @author kwz
 *
 */
public class SecurityWebInitializer extends AbstractSecurityWebApplicationInitializer{

	@Override
	protected void afterSpringSecurityFilterChain(ServletContext servletContext) {
		super.afterSpringSecurityFilterChain(servletContext);
		System.out.println("SecurityWebInitializer-afterSpringSecurityFilterChain");
	}

	@Override
	protected void beforeSpringSecurityFilterChain(ServletContext servletContext) {
		super.beforeSpringSecurityFilterChain(servletContext);
		System.out.println("SecurityWebInitializer-beforeSpringSecurityFilterChain");
	}
	
}
/**
 * 单独只这一个security的类，则启动报错，且mvc也无法访问：
 * 严重: Exception starting filter springSecurityFilterChain
org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named 'springSecurityFilterChain' available
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.getBeanDefinition(DefaultListableBeanFactory.java:687)
	at org.springframework.beans.factory.support.AbstractBeanFactory.getMergedLocalBeanDefinition(AbstractBeanFactory.java:1207)
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:284)
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:202)
	at org.springframework.context.support.AbstractApplicationContext.getBean(AbstractApplicationContext.java:1084)
	at org.springframework.web.filter.DelegatingFilterProxy.initDelegate(DelegatingFilterProxy.java:326)
	at org.springframework.web.filter.DelegatingFilterProxy.initFilterBean(DelegatingFilterProxy.java:235)
	at org.springframework.web.filter.GenericFilterBean.init(GenericFilterBean.java:236)
	at org.apache.catalina.core.ApplicationFilterConfig.initFilter(ApplicationFilterConfig.java:279)
	at org.apache.catalina.core.ApplicationFilterConfig.<init>(ApplicationFilterConfig.java:109)
	at org.apache.catalina.core.StandardContext.filterStart(StandardContext.java:4572)
	at org.apache.catalina.core.StandardContext.startInternal(StandardContext.java:5215)
	at org.apache.catalina.util.LifecycleBase.start(LifecycleBase.java:150)
	at org.apache.catalina.core.ContainerBase$StartChild.call(ContainerBase.java:1404)
	at org.apache.catalina.core.ContainerBase$StartChild.call(ContainerBase.java:1394)
	at java.util.concurrent.FutureTask.run(FutureTask.java:266)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

十月 21, 2017 11:34:35 上午 org.apache.catalina.core.StandardContext startInternal



当有这个SecurityConfiguration类时，其上标识了@EnableWebSecurity，则会自动创建上述bean，则不再报错。
 * */
