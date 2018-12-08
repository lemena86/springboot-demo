package cl.home.store.demo.web.rest.vm;

import java.util.HashSet;
import java.util.Set;

public class ProductVm {

    private Long id;

    private String title;

    private Double price;

    private String thumbnail;

    private Boolean shiping;

    private Boolean condition;

    private String description;

    private Long sellerId;

    private Long categoryId;


    private Set<AttributeVm> attributes = new HashSet<>();

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

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Set<AttributeVm> getAttributes() {
        return attributes;
    }

    public void setAttributes(Set<AttributeVm> attributes) {
        this.attributes = attributes;
    }
}
