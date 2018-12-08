package cl.home.store.demo.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "_attribute")
public class Attribute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String value;

    @ManyToOne
    private Product product;

    public Attribute() {
    }

    public Attribute(Long id, String name, String value, Product product) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attribute attribute = (Attribute) o;
        return Objects.equals(id, attribute.id) &&
                Objects.equals(name, attribute.name) &&
                Objects.equals(value, attribute.value) &&
                Objects.equals(product, attribute.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
