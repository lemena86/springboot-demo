package cl.home.store.demo.service;

import cl.home.store.demo.domain.Category;
import cl.home.store.demo.web.rest.vm.CategoryVm;

public interface CategoryService {

    Category createCategoryIfNotExists(CategoryVm categoryVm);
}
