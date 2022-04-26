package us.jdane.springdemo.store.invoice;

import us.jdane.springdemo.store.customer.Customer;

import javax.persistence.*;
import java.util.List;

@Entity
public class Invoice {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Customer customer;

    @OneToMany
    private List<InvoiceItem> items;

    protected Invoice() {
    }

    public Invoice(Customer customer, List<InvoiceItem> items) {
        this.customer = customer;
        this.items = items;
    }

    @Override
    public String toString() {
        return String.format("Invoice[id = %d, name = %s, invoiceItems = %s]", id, customer, items);
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<InvoiceItem> getItems() {
        return items;
    }
}
