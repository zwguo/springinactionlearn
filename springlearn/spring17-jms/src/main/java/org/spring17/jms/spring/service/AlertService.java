package org.spring17.jms.spring.service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.apache.activemq.command.ActiveMQDestination;
import org.spring17.jms.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsOperations;
import org.springframework.jms.core.MessageCreator;
import org.springframework.jms.support.JmsUtils;
import org.springframework.stereotype.Component;

@Component
public class AlertService {
	private JmsOperations jmsOperation;

	@Autowired
	private ActiveMQDestination queueDestination;

	@Autowired
	public AlertService(JmsOperations jmsOperation) {
		this.jmsOperation = jmsOperation;
	}

	public String sendMessage(final Person content) {
		// 下面的代码可以简化为下面的一句，默认使用SimpleMessageConvert可以在JmsTemplate.setMessageConverter(messageConverter);中设置。
		// jmsOperation.convertAndSend(content);
		jmsOperation.send(queueDestination, new MessageCreator() {

			public Message createMessage(Session session) throws JMSException {
				System.out.println(System.currentTimeMillis() + ":send:[" + content + "]");
				return session.createObjectMessage(content);
			}
		});

		return "Ok";
	}

	public Person receiveMessage() {
		ObjectMessage receiveMsg = (ObjectMessage) jmsOperation.receive(queueDestination);
		Person content = null;
		try {
			content = (Person) receiveMsg.getObject();
		} catch (JMSException e) {
			e.printStackTrace();
			throw JmsUtils.convertJmsAccessException(e);
		}
		return content;
	}
}
