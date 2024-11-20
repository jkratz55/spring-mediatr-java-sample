package io.jkratz.springmediatr.demo;

import io.github.jkratz55.mediator.core.CommandHandler;
import io.github.jkratz55.mediator.core.Mediator;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Component
public class CreateUserCommandHandler implements CommandHandler<CreateUserCommand> {

	private final UserRepository userRepository;
	private final Mediator mediator;

	public CreateUserCommandHandler(UserRepository userRepository, Mediator mediator) {
		this.userRepository = userRepository;
		this.mediator = mediator;
	}

	@Override
	public void handle(@NotNull CreateUserCommand createUserCommand) {
		User user = new User(createUserCommand.getUserName(),
				createUserCommand.getEmail(),
				createUserCommand.getPassword());
		this.userRepository.save(user);
		this.mediator.emit(new UserCreatedEvent(user.getId()));
	}
}
