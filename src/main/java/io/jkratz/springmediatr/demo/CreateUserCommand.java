package io.jkratz.springmediatr.demo;

import io.jkratz.mediator.core.Command;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CreateUserCommand implements Command {

	@NotBlank
	private final String userName;

	@NotBlank
	private final String email;

	@NotBlank
	private final String password;

	public CreateUserCommand(String userName, String email, String password) {
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
