package us.jdane.springdemo.store.customer;

import javax.persistence.*;

@Entity
@Table(name = Customer.SQL.table)
public class Customer {
    public static final class SQL {
        public static final String table = "customer";
        public static final String id = "id";
        public static final String firstName = "first_name";
        public static final String lastName = "last_name";
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = SQL.id)
    private Long id;

    @Column(name = SQL.firstName)
    private String firstName;

    @Column(name = SQL.lastName)
    private String lastName;

    protected Customer() {
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("Customer[id = %s, firstName = '%s', lastName = '%s']", id, firstName, lastName);
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
