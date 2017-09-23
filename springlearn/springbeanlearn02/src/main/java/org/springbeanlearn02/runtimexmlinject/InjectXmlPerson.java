package org.springbeanlearn02.runtimexmlinject;

public class InjectXmlPerson {

	private Integer id;
	private String name;

	public InjectXmlPerson(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public String toString() {
		return id + "-" + name;
	}
}
