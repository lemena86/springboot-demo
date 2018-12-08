package cl.home.store.demo.service.dto;

import cl.home.store.demo.domain.Attribute;
import cl.home.store.demo.domain.Product;

import java.util.Set;
import java.util.stream.Collectors;

public class ProductDto {

    private Long id;

    private String title;

    private Double price;

    private String thumbnail;

    private Boolean shiping;

    private Boolean condition;

    private String description;

    private String category;

    private SellerDto seller;

    private ReviewDto review;

    private Set<AttributeDto> attributes;

    public ProductDto() {
    }

    public ProductDto(Product product) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.price = product.getPrice();
        this.thumbnail = product.getThumbnail();
        this.shiping = product.getShiping();
        this.condition = product.getCondition();
        this.description = product.getDescription();
        this.category = product.getCategory().getName();
        this.seller = new SellerDto(product.getSeller());
        this.review = new ReviewDto(product.getReview());
        this.attributes = product.getAttributes().stream()
                .map(AttributeDto::new)
                .collect(Collectors.toSet());
    }

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public SellerDto getSeller() {
        return seller;
    }

    public void setSeller(SellerDto seller) {
        this.seller = seller;
    }

    public ReviewDto getReview() {
        return review;
    }

    public void setReview(ReviewDto review) {
        this.review = review;
    }

    public Set<AttributeDto> getAttributes() {
        return attributes;
    }

    public void setAttributes(Set<AttributeDto> attributes) {
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", thumbnail='" + thumbnail + '\'' +
                ", shiping=" + shiping +
                ", condition=" + condition +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", seller=" + seller +
                ", review=" + review +
                ", attributes=" + attributes +
                '}';
    }
}
