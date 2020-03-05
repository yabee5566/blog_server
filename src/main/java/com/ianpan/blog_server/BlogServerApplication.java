package com.ianpan.blog_server;

import com.ianpan.blog_server.model.User;
import com.ianpan.blog_server.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BlogServerApplication {

	private static final Logger log = LoggerFactory.getLogger(BlogServerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BlogServerApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(UserRepository repository){
		//The demo() method returns a CommandLineRunner bean that automatically
		// runs the code when the application launches\
		return (args) -> {
			// save a few customers
			repository.save(new User("Jack", "Bauer","a@yahoo.com", "111", "m"));
			repository.save(new User("Chloe", "O'Brian","b@yahoo.com", "222", "f"));
			repository.save(new User("Kim", "Bauer","c@yahoo.com", "333", "f"));
			repository.save(new User("David", "Palmer","e@yahoo.com", "444", "m"));
			repository.save(new User("Michelle", "Dessler"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (User user : repository.findAll()) {
				log.info(user.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			User user = repository.findById(1L);
			log.info("Customer found with findById(1L):");
			log.info("--------------------------------");
			log.info(user.toString());
			log.info("");

			// fetch customers by last name
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			repository.findByLastName("Bauer").forEach(bauer -> {
				log.info(bauer.toString());
			});

			//check findbyEmail
			log.info(repository.findByEmail("a@yahoo.com").toString());


			// for (Customer bauer : repository.findByLastName("Bauer")) {
			//  log.info(bauer.toString());
			// }
			log.info("");
		};
	}

}
