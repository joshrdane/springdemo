package us.jdane.springdemo.store.invoice;

import us.jdane.springdemo.store.customer.Customer;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = Invoice.SQL.table)
public class Invoice {
    public static final class SQL {
        public static final String table = "invoice";
        public static final String id = "id";
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = SQL.id)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = Customer.SQL.id)
    private Customer customer;

    @ManyToMany
    @JoinColumn(name = "product_id", referencedColumnName = "id")
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

    @OneToMany(mappedBy = "invoice")
    private Collection<InvoiceItem> invoiceItem;

    public Collection<InvoiceItem> getInvoiceItem() {
        return invoiceItem;
    }

    public void setInvoiceItem(Collection<InvoiceItem> invoiceItem) {
        this.invoiceItem = invoiceItem;
    }
}
