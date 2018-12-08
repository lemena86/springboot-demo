package cl.home.store.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "_seller")
@RestResource(path = "sellers", rel = "sellers")
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotNull
    private String name;

    @Column
    private String address;

    @Column
    private String zipCode;

    public Seller() {
    }

    public Seller(@NotNull String name, String address, String zipCode) {
        this.name = name;
        this.address = address;
        this.zipCode = zipCode;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "seller")
    @JsonIgnore
    private Set<Product> products = new HashSet<>();

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seller seller = (Seller) o;
        return Objects.equals(id, seller.id) &&
                Objects.equals(name, seller.name) &&
                Objects.equals(address, seller.address) &&
                Objects.equals(zipCode, seller.zipCode) &&
                Objects.equals(products, seller.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
