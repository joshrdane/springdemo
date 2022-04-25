package us.jdane.springdemo.store.product;

import javax.persistence.*;

@Entity
@Table(name = Product.SQL.table)
public class Product {
    public static class SQL {
        public static final String table = "product";
        public static final String id = "id";
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    protected Product() {
    }

    public Product(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Product[id = %d, name = %s]", id, name);
    }

    public String getName() {
        return name;
    }
}