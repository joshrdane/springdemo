package us.jdane.springdemo.store.invoice;

import us.jdane.springdemo.store.customer.Customer;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "invoice")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cid", referencedColumnName = "id")
    private Customer customer;

    @ManyToMany
    @JoinColumn(name = "pid", referencedColumnName = "id")
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
