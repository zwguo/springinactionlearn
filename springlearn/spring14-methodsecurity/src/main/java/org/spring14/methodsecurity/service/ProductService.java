package org.spring14.methodsecurity.service;

import java.util.Arrays;

import javax.annotation.security.RolesAllowed;

import org.springframework.stereotype.Component;

@Component
public class ProductService {

	@RolesAllowed("ROLE_USER")
	public String someSecurityMethod(String... params) {
		System.out.println("ProductService-someSecurityMethod:" + Arrays.toString(params));
		return "OK";
	}
}
