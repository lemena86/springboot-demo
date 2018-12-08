package cl.home.store.demo.web.rest;

import cl.home.store.demo.DemoApplication;
import cl.home.store.demo.domain.Category;
import cl.home.store.demo.domain.Product;
import cl.home.store.demo.domain.Seller;
import cl.home.store.demo.service.CategoryService;
import cl.home.store.demo.service.ProductService;
import cl.home.store.demo.service.SellerService;
import cl.home.store.demo.web.rest.vm.CategoryVm;
import cl.home.store.demo.web.rest.vm.ProductVm;
import cl.home.store.demo.web.rest.vm.SellerVm;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class ProductResourceIntTest {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SellerService sellerService;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    private Category category;

    private Seller seller;

    private Product product;

    private MockMvc restProductMockMvc;


    @Before
    public void init() {
        category = categoryService.createCategoryIfNotExists(getCategoryVm());
        seller = sellerService.createSellerIfNotExists(getSellerVm());
        product = createProduct(getProductVm(category, seller, "title", "description"));

        ProductResource productResource = new ProductResource(productService);
        this.restProductMockMvc = MockMvcBuilders.standaloneSetup(productResource)
                .setCustomArgumentResolvers(pageableArgumentResolver)
                .build();
    }

    @Test
    public void getProduct() throws Exception {
        restProductMockMvc.perform(get("/api/products/{id}", product.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.title").value(product.getTitle()))
                .andExpect(jsonPath("$.description").value(product.getDescription()))
                .andExpect(jsonPath("$.category").value(category.getName()))
                .andExpect(jsonPath("$.seller.name").value(seller.getName()))
                .andExpect(jsonPath("$.seller.address").value(seller.getAddress()));
    }

    @Test
    public void getNotExistingProduct() throws Exception {
        restProductMockMvc.perform(get("/api/products/123"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void getAllProductsContainingTitle() throws Exception {
        createProduct(getProductVm(category, seller, "iphone 5", "desc"));
        createProduct(getProductVm(category, seller, "iphone 6", "desc"));
        createProduct(getProductVm(category, seller, "galaxy s5", "desc"));
        createProduct(getProductVm(category, seller, "motorola", "desc"));

        restProductMockMvc.perform(get("/api/products?title=iph&sort=id")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.[*]").value(hasSize(2)))
                .andExpect(jsonPath("$.[*].title").value(hasItems("iphone 5", "iphone 6")))
                .andExpect(header().string("X-Total-Count", "2"));
    }


    public Product createProduct(ProductVm productVm) {
        Product product = null;
        try {
            product = productService.createProduct(productVm);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }

    private static ProductVm getProductVm(Category category, Seller seller, String title, String description) {
        ProductVm productVM = new ProductVm();
        productVM.setTitle(title);
        productVM.setDescription(description);
        productVM.setCategoryId(category.getId());
        productVM.setSellerId(seller.getId());
        return productVM;
    }

    private static CategoryVm getCategoryVm() {
        CategoryVm categoryVm = new CategoryVm();
        categoryVm.setName("category_name");
        return categoryVm;
    }

    private static SellerVm getSellerVm() {
        SellerVm sellerVm = new SellerVm();
        sellerVm.setAddress("address");
        sellerVm.setName("name");
        sellerVm.setZipCode("zipCode");
        return sellerVm;
    }
}
