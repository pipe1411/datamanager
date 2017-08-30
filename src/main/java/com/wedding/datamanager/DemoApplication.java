package com.wedding.datamanager;

import com.wedding.datamanager.domain.Owner;
import com.wedding.datamanager.domain.Wedding;
import com.wedding.datamanager.repositories.WeddingRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

/*	@Bean
	public CommandLineRunner lineRunner(WeddingRepository repository) {
		return (args) -> {
			Wedding wedding = new Wedding();
			wedding.setOwner(new Owner());
			wedding.getOwner().setName("Andres Arango");

			repository.save(wedding);

			Iterable<Wedding> weddings = repository.findAll();
			for (Wedding wed : weddings) {
				System.out.println(wed.getOwner().getName());
			}

		};
	}*/
}
