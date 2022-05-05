package com.packt.cardatabase;

import com.packt.cardatabase.domain.Owner;
import com.packt.cardatabase.domain.OwnerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner; //Execute additional code before the application fully starts; add demo data
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Autowired;

import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.domain.CarRepository;

@SpringBootApplication
public class CardatabaseApplication {
	private static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);
	@Autowired
	private CarRepository repository;
	@Autowired
	private OwnerRepository ownerRepository;

	public static void main(String[] args) {
		SpringApplication.run(CardatabaseApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(){
		return args -> {
			//Save demo data to the database
			Owner owner1 = new Owner("John", "Johnson");
			Owner owner2 = new Owner("Mary", "Robinson");
			ownerRepository.save(owner1);
			ownerRepository.save(owner2);

			repository.save(new Car("Ford", "Mustang", "Red", "ADF-1121", 2017, 59000, owner1));
			repository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2014, 29000, owner2));
			repository.save(new Car("Toyota", "Prius", "Silver", "KKO-0212", 2018, 39000, owner2));
		};
	}
}
