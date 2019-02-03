package io.jkratz.springmediatr.demo;

import io.jkratz.mediator.core.Request;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class SlowCreateUserRequest implements Request<UUID> {

	@NotBlank
	private final String userName;

	@NotBlank
	private final String email;

	@NotBlank
	private final String password;

	public SlowCreateUserRequest(String userName, String email, String password) {
		this.userName = userName;
		this.email = email;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}
}
