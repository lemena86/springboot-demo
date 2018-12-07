package cl.home.store.demo.domain;

import javax.persistence.Entity;

@Entity
public class Product {

    private Long id;

    private String title;

    private Double price;

    private String thumbnail;

    private Boolean status;

    private Boolean shiping;

    private Boolean condition;

    private String description;

    private Seller seller;

    private Category category;

    private Location location;

    private Reviews reviews;


}
