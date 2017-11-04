package org.spring15.rmi.javarmi.server;

import java.io.IOException;

import org.spring15.rmi.javarmi.server.configuration.SpringRMIConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.remoting.rmi.RmiServiceExporter;

/**
 * 启动服务
 * @author kwz
 *
 */
public class SpringRmiMain {

	public static void main(String[] args) throws IOException {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringRMIConfiguration.class);
		RmiServiceExporter exporter = context.getBean(RmiServiceExporter.class);
		System.out.println(exporter);
		System.in.read();
	}
}
