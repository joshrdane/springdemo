package us.jdane.springdemo.store.invoice;

import org.springframework.beans.factory.annotation.Autowired;
import us.jdane.springdemo.store.customer.Customer;
import us.jdane.springdemo.store.product.Product;

import javax.persistence.*;
import java.util.*;

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

    public Invoice(InvoiceItemRepository invoiceItemRepository, Customer customer, HashMap<Product, Integer> products) {
        this.customer = customer;
        items = new ArrayList<>();
        for (Product product : products.keySet()) {
            InvoiceItem invoiceItem = new InvoiceItem(product, products.get(product));
            items.add(invoiceItemRepository.save(invoiceItem));
        }
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
