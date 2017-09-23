package org.springbeanlearn02.runtimeinject;

public class InjectPerson {

	private Integer id;
	private String name;

	public InjectPerson(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public String toString() {
		return id + "-" + name;
	}
}
