package org.spring17.jms.java;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

/**
 * 原生态 java
 * 
 * @author kwz
 *
 */
public class JMSUseJava {
	public static final String ACTIVEMQURL = "tcp://localhost:61616";
	public static final String DESTINATION = "spitter.queue";

	public static void main(String[] args) {
		String content = "Hello everyBody!" + System.currentTimeMillis();
		JMSUseJava jms = new JMSUseJava();
		jms.sendMessage(content);
		System.out.println("send:" + content);
		String receive = jms.receiveMessage();
		System.out.println("receive:" + receive);
	}

	public void sendMessage(String content) {
		ConnectionFactory cf = new ActiveMQConnectionFactory(ACTIVEMQURL);
		Connection conn = null;
		Session session = null;
		try {
			conn = cf.createConnection();
			session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Destination destination = new ActiveMQQueue(DESTINATION);
			MessageProducer producer = session.createProducer(destination);
			TextMessage message = session.createTextMessage();
			message.setText(content);
			producer.send(message);
		} catch (JMSException e) {
			e.printStackTrace();
		} finally {
			try {
				if (session != null) {
					session.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}

	public String receiveMessage() {
		ConnectionFactory cf = new ActiveMQConnectionFactory(ACTIVEMQURL);
		Connection conn = null;
		Session session = null;
		try {
			conn = cf.createConnection();
			conn.start();
			session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Destination destination = new ActiveMQQueue(DESTINATION);
			MessageConsumer consumer = session.createConsumer(destination);
			TextMessage message = (TextMessage) consumer.receive();
			return message.getText();
		} catch (JMSException e) {
			e.printStackTrace();
		} finally {
			try {
				if (session != null) {
					session.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
