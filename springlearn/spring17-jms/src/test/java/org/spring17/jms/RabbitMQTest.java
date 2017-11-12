package org.spring17.jms;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import junit.framework.TestCase;

/**
 * test RabbitMQ
 */
public class RabbitMQTest extends TestCase {
	private final static String QUEUE_NAME = "hello";

	/**
	 * send
	 * 
	 * @throws TimeoutException
	 * @throws IOException
	 */
	public void testSend() throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
//		factory.setVirtualHost("/");
		factory.setHost("localhost");
//		factory.setPort(5672);
//		factory.setUsername("guest");
//		factory.setPassword("guest");
		Connection conn = factory.newConnection();
		Channel channel = conn.createChannel();

		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		String message = "Hello World";
		channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));
		System.out.println("[x] Send '" + message + "'");
		channel.close();
		conn.close();
	}

	/**
	 * receive
	 * 
	 * @throws TimeoutException
	 * @throws IOException
	 */
	public void testReceive() throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection conn = factory.newConnection();
		Channel channel = conn.createChannel();

		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		System.out.println("wait for message...");
		Consumer consumer = new DefaultConsumer(channel) {

			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties, byte[] body)
					throws IOException {
				String message = new String(body, "UTF-8");
				System.out.println("[x] received '" + message + "'");
			}

		};

		channel.basicConsume(QUEUE_NAME, consumer);
	}
}
