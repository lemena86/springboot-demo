package cl.home.store.demo.service;

import cl.home.store.demo.DemoApplication;
import cl.home.store.demo.domain.Category;
import cl.home.store.demo.domain.Product;
import cl.home.store.demo.domain.Review;
import cl.home.store.demo.domain.Seller;
import cl.home.store.demo.repository.CategoryRepository;
import cl.home.store.demo.repository.ProductRepository;
import cl.home.store.demo.repository.ReviewRepository;
import cl.home.store.demo.repository.SellerRepository;
import cl.home.store.demo.service.dto.ProductDto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
@Transactional
public class ProductServiceIntTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ProductService productService;

    private Product product;

    private Seller seller;

    private Category category;

    private Review review;

    @Before
    public void init() {
        seller = new Seller();
        seller.setName("seller");

        category = new Category();
        category.setName("category");

        review = new Review();

        product = new Product();
        product.setTitle("title");
        product.setDescription("description");
    }

    @Test
    @Transactional
    public void assertThatTitleMustBeUpperCase() {
        sellerRepository.saveAndFlush(seller);
        categoryRepository.saveAndFlush(category);
        reviewRepository.saveAndFlush(review);

        product.setSeller(seller);
        product.setCategory(category);
        product.setReview(review);

        productRepository.deleteAll();
        productRepository.saveAndFlush(product);

        Optional<ProductDto> maybeProduct = productService.findByTittleAndUppercase("title");
        Assert.assertEquals(maybeProduct.get().getTitle(), "TITLE");
    }

    //TODO: if a have time assert test createProdcut metthod


}
