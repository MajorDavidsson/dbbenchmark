package cz.davidsochor.mrmibenchdb;

import cz.davidsochor.mrmibenchdb.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class MrmibenchdbApplication {

	private static final Logger log = LoggerFactory.getLogger(MrmibenchdbApplication.class);

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(MrmibenchdbApplication.class, args);;
	}

	@Bean
	public CommandLineRunner bench(UserService userService) {
		return (args -> {
//			userService.createNewUsers();

			userService.createUsersAsBatch();

			log.info("Number of records: " + Integer.valueOf(userService.getAll().size()));
		});
	}
}
