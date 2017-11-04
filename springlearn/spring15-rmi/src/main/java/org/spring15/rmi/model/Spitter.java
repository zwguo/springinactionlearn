package org.spring15.rmi.model;

import java.io.Serializable;
import java.util.List;

/**
 * just 一个model
 * @author kwz
 *
 */
public class Spitter implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private List<String> messages;
	private String[] repalys;

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

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

	public String[] getRepalys() {
		return repalys;
	}

	public void setRepalys(String[] repalys) {
		this.repalys = repalys;
	}
}
