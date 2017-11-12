package org.spring17.jms.spring;

import java.io.IOException;
import java.util.Date;

import org.spring17.jms.model.Person;
import org.spring17.jms.spring.service.AlertService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainEntry {
	public static void main(String[] args) throws IOException {
		//同步等待
		ApplicationContext context = new ClassPathXmlApplicationContext("springapplication.xml");
		AlertService service = context.getBean(AlertService.class);
		System.out.println(service.sendMessage(new Person(1, "somemessage-" + System.currentTimeMillis(), new Date())));
		//System.out.println(System.currentTimeMillis() + "-receive:[" + service.receiveMessage() + "]");
	}
}
