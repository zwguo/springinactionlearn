package org.spring15.rmi.java;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IHello extends Remote{
	String sayHello() throws RemoteException;
	
	String saySomething(String sth) throws RemoteException;
}
