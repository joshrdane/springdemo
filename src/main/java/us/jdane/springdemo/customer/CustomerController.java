package us.jdane.springdemo.customer;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    private final CustomerRepository repository;

    CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/customer")
    List<Customer> all() {
        return (List<Customer>) repository.findAll();
    }

    @PostMapping("/customer")
    Customer newCustomer(@RequestBody Customer customer) {
        return repository.save(customer);
    }

    @GetMapping("/customer/id/{id}")
    Customer getCustomerById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
    }

    @PutMapping("customer/update/{id}")
    Customer updateCustomer(
            @PathVariable Long id,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName
    ) {
        return repository.findById(id).map(customer -> {
            if (firstName != null) {
                customer.setFirstName(firstName);
            }
            if (lastName != null) {
                customer.setLastName(lastName);
            }
            return repository.save(customer);
        }).orElseThrow(() -> new CustomerNotFoundException(id));
    }
}
