package org.spring20.jmx.spittr.demo;

import java.lang.management.ManagementFactory;

import javax.management.InstanceAlreadyExistsException;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.NotificationBroadcasterSupport;
import javax.management.ObjectInstance;
import javax.management.ObjectName;
import javax.management.ReflectionException;

import org.spring20.jmx.oracledemo.basic.SimpleStandardMBean;

public class Echo implements EchoMBean {

	public static void main(String[] args) throws MalformedObjectNameException, InstanceAlreadyExistsException, NotCompliantMBeanException, InstanceNotFoundException, ReflectionException, MBeanException, InterruptedException {
		// 创建MBeanServer  
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();  
          
        // 新建MBean ObjectName, 在MBeanServer里标识注册的MBean  
        ObjectName name = new ObjectName("org.spring20.jmx.spittr.demo:type=Echo");  
          
        // 创建MBean  
        //Echo mbean = new Echo();  
        
        ObjectInstance bean = mbs.createMBean("org.spring20.jmx.spittr.demo.Echo", name);
          
        // 在MBeanServer里注册MBean, 标识为ObjectName(com.tenpay.jmx:type=Echo)  
        //mbs.registerMBean(mbean, name);  
  
          
        // 在MBeanServer里调用已注册的EchoMBean的print方法  
        mbs.invoke(name, "say", new Object[] { "haitao.tu"}, new String[] {"java.lang.String"});  
          
        Thread.sleep(Long.MAX_VALUE);  
	}

	public void say(String str) {
		System.out.println(str);
	}

}
/**
 * 必须实现接口名是**MBean，而实现类是**，否则报错：
 * Exception in thread "main" javax.management.NotCompliantMBeanException: MBean class org.spring20.jmx.spittr.demo.EchoImpl does not implement DynamicMBean, and neither follows the Standard MBean conventions (javax.management.NotCompliantMBeanException: Class org.spring20.jmx.spittr.demo.EchoImpl is not a JMX compliant Standard MBean) nor the MXBean conventions (javax.management.NotCompliantMBeanException: org.spring20.jmx.spittr.demo.EchoImpl: Class org.spring20.jmx.spittr.demo.EchoImpl is not a JMX compliant MXBean)
	at com.sun.jmx.mbeanserver.Introspector.checkCompliance(Introspector.java:176)
	at com.sun.jmx.interceptor.DefaultMBeanServerInterceptor.registerMBean(DefaultMBeanServerInterceptor.java:317)
	at com.sun.jmx.mbeanserver.JmxMBeanServer.registerMBean(JmxMBeanServer.java:522)
	at org.spring20.jmx.spittr.demo.EchoImpl.main(EchoImpl.java:27)

 * */
