package org.spring15.rmi.java;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloImpl extends UnicastRemoteObject implements IHello {

	public HelloImpl() throws RemoteException {
		super();
	}

	public String sayHello() throws RemoteException {
		System.out.println("HelloImpl-sayHello");
		return "hello";
	}

	public String saySomething(String sth) throws RemoteException {
		System.out.println("HelloImpl-saySomething-" + sth);
		return sth;
	}

}
