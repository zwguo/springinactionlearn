package org.spring15.rmi.java.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import org.spring15.rmi.java.IHello;

/**
 * 纯java rmi实验 http://lavasoft.blog.51cto.com/62575/91679/
 * 总是超时，不知道原因。后来经过spring运行了以下例子，端口号不变，结果好了：
 * 开始找
找到
hello
abcde

 * @author kwz
 *
 */
public class JavaRMIClientMain {
	public static void main(String[] args) {
		try {
			System.out.println("开始找");
			// 在RMI服务注册表中查找名称为RHello的对象，并调用其上的方法
			IHello rhello = (IHello) Naming.lookup("rmi://localhost:1099/RHello");
			System.out.println("找到");
			System.out.println(rhello.sayHello());
			System.out.println(rhello.saySomething("abcde"));
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
}

/**
开始找
找到
java.rmi.ConnectException: Connection refused to host: fe80:0:0:0:ea7:f6d4:93b2:5d46%10; nested exception is: 
	java.net.ConnectException: Operation timed out (Connection timed out)
	at sun.rmi.transport.tcp.TCPEndpoint.newSocket(TCPEndpoint.java:619)
	at sun.rmi.transport.tcp.TCPChannel.createConnection(TCPChannel.java:216)
	at sun.rmi.transport.tcp.TCPChannel.newConnection(TCPChannel.java:202)
	at sun.rmi.server.UnicastRef.invoke(UnicastRef.java:130)
	at java.rmi.server.RemoteObjectInvocationHandler.invokeRemoteMethod(RemoteObjectInvocationHandler.java:227)
	at java.rmi.server.RemoteObjectInvocationHandler.invoke(RemoteObjectInvocationHandler.java:179)
	at com.sun.proxy.$Proxy0.sayHello(Unknown Source)
	at org.spring15.rmi.java.client.JavaRMIClientMain.main(JavaRMIClientMain.java:23)
Caused by: java.net.ConnectException: Operation timed out (Connection timed out)
	at java.net.PlainSocketImpl.socketConnect(Native Method)
	at java.net.AbstractPlainSocketImpl.doConnect(AbstractPlainSocketImpl.java:350)
	at java.net.AbstractPlainSocketImpl.connectToAddress(AbstractPlainSocketImpl.java:206)
	at java.net.AbstractPlainSocketImpl.connect(AbstractPlainSocketImpl.java:188)
	at java.net.SocksSocketImpl.connect(SocksSocketImpl.java:392)
	at java.net.Socket.connect(Socket.java:589)
	at java.net.Socket.connect(Socket.java:538)
	at java.net.Socket.<init>(Socket.java:434)
	at java.net.Socket.<init>(Socket.java:211)
	at sun.rmi.transport.proxy.RMIDirectSocketFactory.createSocket(RMIDirectSocketFactory.java:40)
	at sun.rmi.transport.proxy.RMIMasterSocketFactory.createSocket(RMIMasterSocketFactory.java:148)
	at sun.rmi.transport.tcp.TCPEndpoint.newSocket(TCPEndpoint.java:613)
	... 7 more

*/