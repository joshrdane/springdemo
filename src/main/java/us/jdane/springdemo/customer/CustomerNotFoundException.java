package us.jdane.springdemo.customer;

public class CustomerNotFoundException extends RuntimeException {

    CustomerNotFoundException(Long id) {
        super(String.format("Employee with id '%d' not found.", id));
    }
}
