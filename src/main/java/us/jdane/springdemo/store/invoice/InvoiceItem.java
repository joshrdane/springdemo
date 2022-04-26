package us.jdane.springdemo.store.invoice;

import us.jdane.springdemo.store.product.Product;

import javax.persistence.*;

@Entity

@Table(name = InvoiceItem.SQL.table)
public class InvoiceItem {
    public static final class SQL {
        public static final String table = "invoice_item";
        public static final String id = "id";
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = Product.SQL.id)
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
