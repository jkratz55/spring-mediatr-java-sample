package io.jkratz.springmediatr.demo;

import io.github.jkratz55.mediator.core.Mediator;
import io.github.jkratz55.mediator.core.RequestHandler;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreateUserRequestHandler implements RequestHandler<CreateUserRequest, UUID> {

	private final UserRepository userRepository;
	private final Mediator mediator;

	public CreateUserRequestHandler(UserRepository userRepository, Mediator mediator) {
		this.userRepository = userRepository;
		this.mediator = mediator;
	}

	@Override
	public UUID handle(@NotNull CreateUserRequest createUserRequest) {
		User user = new User(createUserRequest.getUserName(),
				createUserRequest.getEmail(),
				createUserRequest.getPassword());
		this.userRepository.save(user);
		this.mediator.emitAsync(new UserCreatedEvent(user.getId()));
		return user.getId();
	}
}
