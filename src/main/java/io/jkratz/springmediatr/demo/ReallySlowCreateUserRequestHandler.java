package io.jkratz.springmediatr.demo;

import io.jkratz.mediator.core.RequestHandler;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ReallySlowCreateUserRequestHandler implements RequestHandler<SlowCreateUserRequest, UUID> {

	private final UserRepository userRepository;

	public ReallySlowCreateUserRequestHandler(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UUID handle(@NotNull SlowCreateUserRequest request) {

		// Simulate a slow operation or just waste time for fun
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {

		}

		User user = new User(request.getUserName(),
				request.getEmail(),
				request.getPassword());
		this.userRepository.save(user);
		return user.getId();
	}
}
