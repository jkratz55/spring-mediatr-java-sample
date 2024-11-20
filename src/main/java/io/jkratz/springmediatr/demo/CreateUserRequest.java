package io.jkratz.springmediatr.demo;

import io.github.jkratz55.mediator.core.Request;

import jakarta.validation.constraints.NotBlank;
import java.util.UUID;

public class CreateUserRequest implements Request<UUID> {

	@NotBlank
	private final String userName;

	@NotBlank
	private final String email;

	@NotBlank
	private final String password;

	public CreateUserRequest(String userName, String email, String password) {
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
