package us.jdane.springdemo.store.invoice;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InvoiceController {
    private final InvoiceRepository repository;

    InvoiceController(InvoiceRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/invoice")
    List<Invoice> all() {
        return (List<Invoice>) repository.findAll();
    }

    @PostMapping("/invoice")
    Invoice newOrder(@RequestBody Invoice transaction) {
        return repository.save(transaction);
    }

    @GetMapping("/invoice/{id}")
    Invoice getOrderById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new InvoiceNotFoundException(id));
    }
}
