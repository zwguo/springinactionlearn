package org.spring16.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class TestRestTemplate extends TestCase {

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		RestTemplate rest = new RestTemplate();
		ResponseEntity<List> res = rest.getForEntity("http://localhost:8080/spring16-rest/spittles3", List.class);
		System.out.println(res);
		assertTrue(true);
	}
}
