package io.jkratz.springmediatr.demo;

import io.jkratz.mediator.core.RequestHandler;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreateUserRequestHandler implements RequestHandler<CreateUserRequest, UUID> {

	private final UserRepository userRepository;

	public CreateUserRequestHandler(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UUID handle(@NotNull CreateUserRequest createUserRequest) {
		User user = new User(createUserRequest.getUserName(),
				createUserRequest.getEmail(),
				createUserRequest.getPassword());
		this.userRepository.save(user);
		return user.getId();
	}
}
