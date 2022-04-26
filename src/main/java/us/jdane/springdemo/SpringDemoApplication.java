package us.jdane.springdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import us.jdane.springdemo.store.customer.Customer;
import us.jdane.springdemo.store.customer.CustomerRepository;
import us.jdane.springdemo.store.invoice.Invoice;
import us.jdane.springdemo.store.invoice.InvoiceItem;
import us.jdane.springdemo.store.invoice.InvoiceItemRepository;
import us.jdane.springdemo.store.invoice.InvoiceRepository;
import us.jdane.springdemo.store.product.Product;
import us.jdane.springdemo.store.product.ProductRepository;

import java.util.HashMap;
import java.util.List;

@SpringBootApplication
public class SpringDemoApplication {

    private static final Logger log = LoggerFactory.getLogger(SpringDemoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner springOrderDemo(
            InvoiceRepository invoiceRepository,
            InvoiceItemRepository invoiceItemRepository,
            CustomerRepository customerRepository,
            ProductRepository productRepository
    ) {
        return (args -> {
            // Pre-populate the database
            customerRepository.save(new Customer("Johnathan", "Wick"));
            customerRepository.save(new Customer("Charlie", "Manson"));
            customerRepository.save(new Customer("Jimothy", "Hendricks"));
            productRepository.save(new Product("Drill"));
            productRepository.save(new Product("Hammer"));
            HashMap<Product, Integer> products = new HashMap<>();
            products.put(productRepository.findById(1), 12);
            invoiceRepository.save(new Invoice(invoiceItemRepository, customerRepository.findById(1), products));
        });
    }

}
