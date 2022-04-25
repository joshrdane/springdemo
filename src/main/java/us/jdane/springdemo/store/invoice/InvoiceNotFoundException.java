package us.jdane.springdemo.store.invoice;

public class InvoiceNotFoundException extends RuntimeException {

    InvoiceNotFoundException(Long id) {
        super(String.format("Invoice with id '%d' not found.", id));
    }
}
