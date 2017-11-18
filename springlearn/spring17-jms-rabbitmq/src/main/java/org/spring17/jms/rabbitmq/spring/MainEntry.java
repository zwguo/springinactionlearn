package org.spring17.jms.rabbitmq.spring;

import java.nio.charset.Charset;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 主入口
 * 
 * @author kwz
 *
 */
public class MainEntry {
	public static void main(String[] args) {
		final String queueName = "spittle.alerts";
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("springapplication.xml");
		RabbitTemplate template = (RabbitTemplate) context.getBean("rabbitTemplate");
		// Message sendMsg = new Message("hello
		// world".getBytes(Charset.forName("utf-8")), new MessageProperties());
		// template.send(queueName, sendMsg);
		// System.out.println("send ok");

		// 接收一个
		Message receiveMsg = template.receive(queueName);
		System.out.println("receiveMsg:" + receiveMsg);
		System.out.println("received:" + new String(receiveMsg.getBody(), Charset.forName("utf-8")));
	}
}
