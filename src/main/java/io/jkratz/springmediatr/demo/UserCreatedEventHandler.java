package io.jkratz.springmediatr.demo;

import io.github.jkratz55.mediator.core.EventHandler;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class UserCreatedEventHandler implements EventHandler<UserCreatedEvent> {

	private final static Logger logger = LoggerFactory.getLogger(UserCreatedEventHandler.class);

	@Override
	public void handle(@NotNull UserCreatedEvent userCreatedEvent) {

		// TODO: Ideally this would do something more interesting or useful but this at least demonstrates the event handler being invoked
		logger.info("A user was created with the ID " + userCreatedEvent.getId().toString());
	}
}
