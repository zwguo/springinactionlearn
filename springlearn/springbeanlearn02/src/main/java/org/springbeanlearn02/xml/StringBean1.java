package org.springbeanlearn02.xml;

public class StringBean1 implements InterfaceStringBean{

	private String name;
	
	public StringBean1(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
}
