package us.jdane.springdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import us.jdane.springdemo.customer.Customer;
import us.jdane.springdemo.customer.CustomerRepository;

@SpringBootApplication
public class SpringDemoApplication {

    private static final Logger log = LoggerFactory.getLogger(SpringDemoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner springDemo(CustomerRepository repository) {
        return (args -> {
            // Pre-populate the database
            repository.save(new Customer("Johnathan", "Wick"));
            repository.save(new Customer("Charlie", "Manson"));
            repository.save(new Customer("Jimothy", "Hendricks"));

            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (Customer customer : repository.findAll()) {
                log.info(customer.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            Customer customer = repository.findById(1L);
            log.info("Customer found with findById(1L):");
            log.info("--------------------------------");
            log.info(customer.toString());
            log.info("");

            // fetch customers by last name
            log.info("Customer found with findByLastName('Bauer'):");
            log.info("--------------------------------------------");
            repository.findByLastName("Manson").forEach(bauer -> log.info(bauer.toString()));
            // for (Customer bauer : repository.findByLastName("Bauer")) {
            //  log.info(bauer.toString());
            // }
            log.info("");
        });
    }

}
