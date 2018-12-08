package cl.home.store.demo.service;

import cl.home.store.demo.domain.Seller;
import cl.home.store.demo.web.rest.vm.SellerVm;

public interface SellerService {

    Seller createSellerIfNotExists(SellerVm sellerVm);
}
