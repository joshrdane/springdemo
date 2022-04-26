package us.jdane.springdemo.store.product;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private Long id;

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
