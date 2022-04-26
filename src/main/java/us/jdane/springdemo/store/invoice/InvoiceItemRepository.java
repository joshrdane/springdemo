package us.jdane.springdemo.store.invoice;

import org.springframework.data.repository.CrudRepository;

public interface InvoiceItemRepository extends CrudRepository<InvoiceItem, Long> {
    InvoiceItem findById(long id);
}
