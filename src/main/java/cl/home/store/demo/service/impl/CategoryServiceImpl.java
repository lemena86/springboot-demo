package cl.home.store.demo.service.impl;

import cl.home.store.demo.domain.Category;
import cl.home.store.demo.repository.CategoryRepository;
import cl.home.store.demo.service.CategoryService;
import cl.home.store.demo.web.rest.vm.CategoryVm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    @Transactional
    public Category createCategoryIfNotExists(CategoryVm categoryVm) {
        return categoryRepository.findByName(categoryVm.getName())
                .orElseGet(() -> categoryRepository.save(new Category(categoryVm.getName())));
    }
}
