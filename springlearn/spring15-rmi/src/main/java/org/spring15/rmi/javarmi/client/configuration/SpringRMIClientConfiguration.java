package org.spring15.rmi.javarmi.client.configuration;

import org.spring15.rmi.interfaces.SpitterService;
import org.spring15.rmi.java.IHello;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

@Configuration
@ComponentScan("org.spring15.rmi.javarmi.client")
public class SpringRMIClientConfiguration {

	@Bean
	public RmiProxyFactoryBean spitterServiceBean() {
		RmiProxyFactoryBean rmiProxy = new RmiProxyFactoryBean();
		rmiProxy.setServiceUrl("rmi://localhost:1099/SpitterService");
		rmiProxy.setServiceInterface(SpitterService.class);
//		rmiProxy.setServiceUrl("rmi://localhost:1099/RHello");
//		rmiProxy.setServiceInterface(IHello.class);
		return rmiProxy;
	}
}
