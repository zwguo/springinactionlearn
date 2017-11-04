package org.spring15.rmi.javarmi.client;

import java.rmi.RemoteException;

import org.spring15.rmi.interfaces.SpitterService;
import org.spring15.rmi.java.IHello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SpitterServiceUse {
	@Autowired
	public SpitterService service;

	public String getName() {
		return service.getName();
	}
	// @Autowired
	// public IHello helloService;
	//
	// public String getName() throws RemoteException {
	// return helloService.sayHello();
	// }
}
