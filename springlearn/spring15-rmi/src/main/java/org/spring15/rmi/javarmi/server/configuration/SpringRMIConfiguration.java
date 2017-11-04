package org.spring15.rmi.javarmi.server.configuration;

import org.spring15.rmi.impl.SpitterServiceRawImpl;
import org.spring15.rmi.interfaces.SpitterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;

@Configuration
@ComponentScan("org.spring15.rmi.javarmi.server")
public class SpringRMIConfiguration {
	@Bean
	public SpitterService getServiceImpl() {
		return new SpitterServiceRawImpl();
	}

	/**
	 * 将POJO转成RMI服务
	 * 
	 * @param service
	 * @return
	 */
	@Bean
	public RmiServiceExporter rmiExporter(SpitterService service) {
		RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
		rmiServiceExporter.setService(service);
		rmiServiceExporter.setServiceName("SpitterService");
		rmiServiceExporter.setServiceInterface(SpitterService.class);
		// rmiServiceExporter.setRegistryHost("localhost");
		// rmiServiceExporter.setRegistryPort(1199);
		return rmiServiceExporter;
	}
}
