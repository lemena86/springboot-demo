package cl.home.store.demo.exceptions;

public class SellerNotFoundException extends Exception {
    private Long sellerId;

    public SellerNotFoundException(Long sellerId) {
        super();
        this.sellerId = sellerId;

    }
}
