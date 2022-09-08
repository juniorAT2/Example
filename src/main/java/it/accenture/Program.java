package it.accenture;

import it.accenture.controllers.PersonController;
import it.accenture.repositories.implementations.jdbc.JdbcPersonRepository;
import it.accenture.services.implementations.PersonCrudService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class Program {
	public static void main(String[] args) {
		SpringApplication.run(Program.class, args);
	}

}
