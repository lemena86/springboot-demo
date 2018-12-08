package cl.home.store.demo.service.impl;

import cl.home.store.demo.domain.*;
import cl.home.store.demo.exceptions.CategoryNotFoundException;
import cl.home.store.demo.exceptions.RequiredFieldException;
import cl.home.store.demo.exceptions.SellerNotFoundException;
import cl.home.store.demo.repository.CategoryRepository;
import cl.home.store.demo.repository.ProductRepository;
import cl.home.store.demo.repository.SellerRepository;
import cl.home.store.demo.service.ProductService;
import cl.home.store.demo.service.dto.ProductDto;
import cl.home.store.demo.web.rest.vm.ProductVm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Product createProduct(ProductVm productVm) throws RequiredFieldException,
            SellerNotFoundException, CategoryNotFoundException {
        if (productVm.getSellerId() == null) throw new RequiredFieldException("sellerId");
        if (productVm.getCategoryId() == null) throw new RequiredFieldException("categoryId");

        Product product = new Product();
        product.setTitle(productVm.getTitle());
        product.setPrice(productVm.getPrice());
        product.setThumbnail(productVm.getThumbnail());
        product.setShiping(productVm.getShiping());
        product.setCondition(productVm.getCondition());
        product.setDescription(productVm.getDescription());

        Seller seller = sellerRepository.findById(productVm.getSellerId()).orElseThrow(
                () -> new SellerNotFoundException(productVm.getSellerId()));
        product.setSeller(seller);

        Category category = categoryRepository.findById(productVm.getCategoryId()).orElseThrow(
                () -> new CategoryNotFoundException(productVm.getCategoryId()));
        product.setCategory(category);

        product.setReview(new Review());

        Set<Attribute> attributes = productVm.getAttributes().stream()
                .map(attr -> {
                    Attribute attribute = new Attribute();
                    attribute.setName(attr.getName());
                    attribute.setValue(attr.getValue());
                    return attribute;
                }).collect(Collectors.toSet());
        product.setAttributes(attributes);

        return productRepository.save(product);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ProductDto> findById(Long id) {
        return productRepository.findById(id).map(ProductDto::new);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ProductDto> findByTittleAndUppercase(String title) {
        return productRepository
                .findByTitle(title)
                .map(product -> {
                    product.setTitle(product.getTitle().toUpperCase());
                    return product;
                })
                .map(ProductDto::new);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ProductDto> findByTitleContaining(String title, Pageable pageable) {
        return productRepository.findByTitleContaining(title, pageable)
                .map(ProductDto::new);
    }


}
