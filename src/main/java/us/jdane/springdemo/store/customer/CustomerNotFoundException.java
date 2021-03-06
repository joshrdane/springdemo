package us.jdane.springdemo.store.customer;

public class CustomerNotFoundException extends RuntimeException {

    CustomerNotFoundException(Long id) {
        super(String.format("Employee with id '%d' not found.", id));
    }
}
