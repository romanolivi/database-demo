package com.in28minutes.database.databasedemo;

import com.in28minutes.database.databasedemo.entity.Person;
import com.in28minutes.database.databasedemo.jpa.PersonJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import java.util.Date;

//@SpringBootApplication
public class DatabaseDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJpaRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(DatabaseDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		logger.info("User if 10001 -> {}", repository.findById(10001));
		logger.info("Inserting 10004 -> {}",
				repository.insert(new Person(10004, "Tara", "Berlin", new Date())));
		logger.info("Updating 10003 -> {}",
				repository.update(new Person(10003, "Pieter", "Utrecht", new Date())));

		repository.deleteById(10002);
//		logger.info("All users -> {}", dao.findAll());
//		logger.info("User if 10001 -> {}", dao.findById(10001));
//		logger.info("Deleting 10002 -> Number of rows deleted - {}", dao.deleteById(10002));
//		logger.info("Adding 10004 -> {}", dao.insert(new Person(10004, "Romano", "NY", new Date())));
//		logger.info("Updating 10003 -> {}", dao.update(new Person(10003, "Tommy", "Birmingham", new Date())));
	}
}











