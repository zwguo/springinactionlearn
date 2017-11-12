package org.spring20.jmx.spring.jmx;

import java.util.HashMap;
import java.util.Map;

import org.spring20.jmx.spring.bean.SpittleService;
import org.springframework.context.annotation.Bean;
import org.springframework.jmx.export.MBeanExporter;
import org.springframework.stereotype.Component;

@Component
public class JMXBean {

	@Bean
	public MBeanExporter mbeanExporter(SpittleService service) {
		MBeanExporter exporter = new MBeanExporter();
		Map<String, Object> beans = new HashMap<String, Object>();
		beans.put("spittle:name=spittleservice", service);
		exporter.setBeans(beans);
		return exporter;
	}
}
