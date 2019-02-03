package io.jkratz.springmediatr.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "USER")
public class User {

	@Id
	private UUID id;
	private String userName;
	private String email;
	private String password;

	protected User() {

	}

	public User(String userName, String email, String password) {
		this.id = UUID.randomUUID();
		this.userName = userName;
		this.email = email;
		this.password = password;
	}

	public UUID getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
