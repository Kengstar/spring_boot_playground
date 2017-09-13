package com.SpringTest;


import com.SpringTest.domain.LifterRepository;
import com.SpringTest.domain.Lifter;
import com.SpringTest.domain.LifterRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HibernateApplication {
    private static final Logger log =  LoggerFactory.getLogger(HibernateApplication.class);

    public static void main (String[]args)
    {
        SpringApplication.run(HibernateApplication.class);
    }

    @Bean
    public CommandLineRunner hibernateTest (LifterRepository repository)
    {
        return (args) -> {
            // save a couple of customers
            repository.save(new Lifter(77, "Sonic"));
            repository.save(new Lifter(85, "Mario"));

            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (Lifter lifter : repository.findAll()) {
                log.info(lifter.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            Lifter lifter = repository.findOne(1);
            log.info("Customer found with findOne(1):");
            log.info("--------------------------------");
            log.info(lifter.toString());
            log.info("");

            // fetch customers by last name
            log.info("Customer found with findByName('Mario'):");
            log.info("--------------------------------------------");
            for (Lifter mario : repository.findByName("Mario")) {
                log.info(mario.toString());
            }
            log.info("");
        };

    }

}
