package us.jdane.springdemo.store.product;

public class ProductNotFoundException extends RuntimeException {
    ProductNotFoundException(Long id) {
        super(String.format("Product with id '%d' not found.", id));
    }
}
