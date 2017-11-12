package org.spring17.jms.model;

import java.io.Serializable;
import java.util.Date;

public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private String name;
	private Date date;
	
	public Person() {}
	
	public Person(int id, String name, Date date) {
		this.id = id;
		this.name = name;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", date=" + date + "]";
	}

	
}
