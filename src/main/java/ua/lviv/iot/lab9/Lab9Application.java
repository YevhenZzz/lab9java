package ua.lviv.iot.lab9;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Lab9Application {
	public static void main(String[] args) {
		SpringApplication.run(Lab9Application.class, args);
	}

	@Bean
	public CommandLineRunner demo(ClotherRepositoriy clotherRepositoriy){
		return (args) -> {
			clotherRepositoriy.save(new Clothes("Gucci", "Yellow", 7000, TypesForWearing.EVERYDAY));
			clotherRepositoriy.save(new Clothes("Zara", "Black", 5000, TypesForWearing.FASTIVE));
			clotherRepositoriy.save(new Clothes("Bershka", "Green", 4000, TypesForWearing.HOME));
		};
	}
}
