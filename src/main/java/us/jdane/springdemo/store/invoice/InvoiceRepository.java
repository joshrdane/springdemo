package us.jdane.springdemo.store.invoice;

import org.springframework.data.repository.CrudRepository;

public interface InvoiceRepository extends CrudRepository<Invoice, Long> {

    Invoice findById(long id);
}
