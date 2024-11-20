package io.jkratz.springmediatr.demo;

import io.github.jkratz55.mediator.core.Event;

import java.util.UUID;

public class UserCreatedEvent implements Event {

	private final UUID id;

	public UserCreatedEvent(UUID id) {
		this.id = id;
	}

	public UUID getId() {
		return id;
	}
}
