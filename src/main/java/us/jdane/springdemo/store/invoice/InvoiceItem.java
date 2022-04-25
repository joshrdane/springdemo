package us.jdane.springdemo.store.invoice;

import us.jdane.springdemo.store.product.Product;

import javax.persistence.*;

@Entity

@Table(name = "invoice_item")
public class InvoiceItem {
    @Id
    @ManyToOne
    @JoinColumn(name = "iid", referencedColumnName = "id")
    private Invoice invoice;

    @Id
    @ManyToOne
    @JoinColumn(name = "pid", referencedColumnName = "id")
    private Product product;

    private int quantity;

    protected InvoiceItem() {
    }

    InvoiceItem(Invoice invoice, Product product, Integer quantity) {
        this.invoice = invoice;
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
