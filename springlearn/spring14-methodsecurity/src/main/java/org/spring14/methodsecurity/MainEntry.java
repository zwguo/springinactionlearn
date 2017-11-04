package org.spring14.methodsecurity;

import java.security.AccessControlContext;

import javax.security.auth.Subject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring14.methodsecurity.configuration.MethodSecurityCofiguration;
import org.spring14.methodsecurity.service.ProductService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithSecurityContextTestExecutionListener;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.context.web.ServletTestExecutionListener;

/**
 * 主入口
 * @author kwz
 * 参考：http://blog.csdn.net/xiejx618/article/details/48792543
 * 
 * 剩余问题：直接运行main方法：org.springframework.security.authentication.AuthenticationCredentialsNotFoundException
 * 不知道怎么虚拟一个用户，应该只用于web应用。
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(classes = {MethodSecurityCofiguration.class})  
@TestExecutionListeners(listeners = {  
        ServletTestExecutionListener.class,  
        DependencyInjectionTestExecutionListener.class,  
        DirtiesContextTestExecutionListener.class,  
        TransactionalTestExecutionListener.class,  
        WithSecurityContextTestExecutionListener.class})  
public class MainEntry {
	
	@Test
	@WithMockUser(username="user1", password="password1", roles="USER")
	public void test1() {
		main(null);
	}

	public static void main(String[] args) {
		System.out.println("SecurityManager: " + System.getSecurityManager());
		SecurityManager securityManager = new SecurityManager();
		System.out.println("SecurityContext:" + securityManager.getSecurityContext());
		
		AnnotationConfigApplicationContext config = new AnnotationConfigApplicationContext(
				MethodSecurityCofiguration.class);
		ProductService productService = config.getBean(ProductService.class);
		String result = productService.someSecurityMethod("A", "B", "C");
		System.out.println("result:" + result);
		
		AccessControlContext acc = (AccessControlContext)(securityManager.getSecurityContext());
		
	}
}
