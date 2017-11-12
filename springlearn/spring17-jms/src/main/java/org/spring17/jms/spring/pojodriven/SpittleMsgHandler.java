package org.spring17.jms.spring.pojodriven;

import org.spring17.jms.model.Person;

public class SpittleMsgHandler {

	public void handleSpittleAlert(Person person) {
		System.out.println(System.currentTimeMillis() + "-SpittleMsgHandler-handleSpittleAlert:" + person);
	}
}
