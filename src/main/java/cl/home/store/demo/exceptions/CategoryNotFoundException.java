package cl.home.store.demo.exceptions;

public class CategoryNotFoundException extends Exception {
    private Long categoryId;

    public CategoryNotFoundException(Long categoryId) {
        super();
        this.categoryId = categoryId;

    }
}
