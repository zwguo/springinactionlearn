package org.spring15.rmi.javarmi.client;

import java.rmi.RemoteException;

import org.spring15.rmi.javarmi.client.configuration.SpringRMIClientConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringRMIClientMain {
	public static void main(String[] args) throws RemoteException {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				SpringRMIClientConfiguration.class);
		SpitterServiceUse use = context.getBean(SpitterServiceUse.class);
		String name = use.getName();
		System.out.println("getname:" + name);
	}
}
