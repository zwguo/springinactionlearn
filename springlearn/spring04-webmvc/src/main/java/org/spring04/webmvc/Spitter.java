package org.spring04.webmvc;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Spitter {
	private Long id;
	
	@NotNull
	@Size(min=2, max=30)
	private String firstName;
	
	@NotNull
	@Size(min=2, max=30)
	private String lastName;
	
	@NotNull
	@Size(min=5, max=16)
	private String username;
	
	@NotNull
	@Size(min=5, max=25)
	private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Spitter() {}
	
	public Spitter(long id, String username, String password, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
	}
	
	public Spitter(String username, String password, String firstName, String lastName) {
		this(0, username, password, firstName, lastName);
	}
	
	public String toString() {
		return this.firstName + " " + this.lastName + ",username:" + this.username;
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, "id", "username", "firstname", "lastname", "password");
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj, "id", "username", "firstname", "lastname", "password");
	}
}
