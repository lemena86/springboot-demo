package cl.home.store.demo.service;


import cl.home.store.demo.domain.Product;
import cl.home.store.demo.exceptions.CategoryNotFoundException;
import cl.home.store.demo.exceptions.RequiredFieldException;
import cl.home.store.demo.exceptions.SellerNotFoundException;
import cl.home.store.demo.service.dto.ProductDto;
import cl.home.store.demo.web.rest.vm.ProductVm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ProductService {

    Product createProduct(ProductVm productVm) throws RequiredFieldException, SellerNotFoundException, CategoryNotFoundException;

    Optional<ProductDto> findById(Long id);

    Optional<ProductDto> findByTittleAndUppercase(String title);

    Page<ProductDto> findByTitleContaining(String title, Pageable pageable);

}
