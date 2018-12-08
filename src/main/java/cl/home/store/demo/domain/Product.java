package cl.home.store.demo.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    private String title;

    @Column
    @NotNull
    private String description;

    @Column
    private Double price;

    @Column
    private String thumbnail;

    @Column
    private Boolean shiping;

    @Column
    private Boolean condition;


    @ManyToOne
    @NotNull
    private Seller seller;

    @ManyToOne
    @NotNull
    private Category category;

    @OneToOne(cascade = CascadeType.ALL)
    @NotNull
    @JoinColumn(unique = true)
    private Review review;

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    private Set<Attribute> attributes = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }


    public Boolean getShiping() {
        return shiping;
    }

    public void setShiping(Boolean shiping) {
        this.shiping = shiping;
    }

    public Boolean getCondition() {
        return condition;
    }

    public void setCondition(Boolean condition) {
        this.condition = condition;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    public Set<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(Set<Attribute> attributes) {
        this.attributes = attributes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) &&
                Objects.equals(title, product.title) &&
                Objects.equals(price, product.price) &&
                Objects.equals(thumbnail, product.thumbnail) &&
                Objects.equals(shiping, product.shiping) &&
                Objects.equals(condition, product.condition) &&
                Objects.equals(description, product.description) &&
                Objects.equals(seller, product.seller) &&
                Objects.equals(category, product.category) &&
                Objects.equals(review, product.review) &&
                Objects.equals(attributes, product.attributes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", thumbnail='" + thumbnail + '\'' +
                ", shiping=" + shiping +
                ", condition=" + condition +
                ", description='" + description + '\'' +
                ", seller=" + seller +
                ", category=" + category +
                ", review=" + review +
                ", attributes=" + attributes +
                '}';
    }
}
