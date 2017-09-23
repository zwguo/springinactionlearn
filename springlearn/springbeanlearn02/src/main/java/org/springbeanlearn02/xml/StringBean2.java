package org.springbeanlearn02.xml;

public class StringBean2 implements InterfaceStringBean{

	private String name;
	
	public StringBean2(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
}
