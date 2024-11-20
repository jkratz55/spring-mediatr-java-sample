package io.jkratz.springmediatr.demo;

import io.github.jkratz55.mediator.core.Mediator;
import io.github.jkratz55.mediator.core.Registry;
import io.github.jkratz55.mediator.spring.SpringMediator;
import io.github.jkratz55.mediator.spring.SpringRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringMediatrJavaSampleApplication {

	private final ApplicationContext applicationContext;

	@Autowired
	public SpringMediatrJavaSampleApplication(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	@Bean
	public Registry registry() {
		return new SpringRegistry(applicationContext);
	}

	@Bean
	public Mediator mediator(Registry registry) {
		return new SpringMediator(registry);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringMediatrJavaSampleApplication.class, args);
	}
}

