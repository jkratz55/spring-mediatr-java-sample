package io.jkratz.springmediatr.demo;

import io.jkratz.mediator.core.Mediator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
public class SampleController {

	private final Mediator mediator;

	@Autowired
	public SampleController(Mediator mediator) {
		this.mediator = mediator;
	}

	@PostMapping("/command")
	public ResponseEntity<?> runCommand(@RequestBody CreateUserCommand command) {
		this.mediator.dispatch(command);
		return ResponseEntity.ok().build();
	}

	@PostMapping("/request")
	public ResponseEntity<?> runRequest(@RequestBody CreateUserRequest request) {
		UUID id = this.mediator.dispatch(request);
		UriComponents uri = UriComponentsBuilder.fromPath("/user/{id}").buildAndExpand(id);
		return ResponseEntity.created(uri.toUri()).build();
	}

	@PostMapping("/requestAsync")
	public CompletableFuture<ResponseEntity> runRequestAsync(@RequestBody SlowCreateUserRequest request) {
		return this.mediator.dispatchAsync(request)
				.thenApply(id -> {
					UriComponents uri = UriComponentsBuilder.fromPath("/user/{id}").buildAndExpand(id);
					return ResponseEntity.created(uri.toUri()).build();
				});
	}
}
