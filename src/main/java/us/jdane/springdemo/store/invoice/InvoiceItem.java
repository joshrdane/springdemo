package us.jdane.springdemo.store.invoice;

import us.jdane.springdemo.store.product.Product;

import javax.persistence.*;

@Entity
public class InvoiceItem {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL) // This may require CascadeType.MERGE
    private Product product;

    private int quantity;

    protected InvoiceItem() {}

    public InvoiceItem(Product product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
