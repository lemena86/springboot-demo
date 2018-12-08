package cl.home.store.demo.web.rest;

import cl.home.store.demo.service.ProductService;
import cl.home.store.demo.service.dto.ProductDto;
import cl.home.store.demo.web.rest.util.PaginationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductResource {

    @Autowired
    private ProductService productService;

    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> getProductsContainingTitle(
            @RequestParam(name = "title", required = false) String title,
            Pageable pageable) {
        Page<ProductDto> page = productService.findByTitleContaining(title, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/products");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable Long id) {
        Optional<ProductDto> maybeProduct = productService.findById(id);
        return (ResponseEntity) maybeProduct
                .map(product -> ResponseEntity.ok().body(product))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }


}
