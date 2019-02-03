package io.jkratz.springmediatr.demo;

import io.jkratz.mediator.core.CommandHandler;
import io.jkratz.mediator.core.Mediator;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateUserCommandHandler implements CommandHandler<CreateUserCommand> {

	private final UserRepository userRepository;

	@Autowired
	private Mediator mediator;

	public CreateUserCommandHandler(UserRepository userRepository) {
		this.userRepository = userRepository;
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
