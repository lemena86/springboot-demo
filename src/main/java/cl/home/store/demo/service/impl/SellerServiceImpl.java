package cl.home.store.demo.service.impl;

import cl.home.store.demo.domain.Seller;
import cl.home.store.demo.repository.SellerRepository;
import cl.home.store.demo.service.SellerService;
import cl.home.store.demo.web.rest.vm.SellerVm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    @Override
    @Transactional
    public Seller createSellerIfNotExists(SellerVm sellerVm) {
        return sellerRepository.findByName(sellerVm.getName())
                .orElseGet(() -> sellerRepository.save(
                        new Seller(sellerVm.getName(),
                                sellerVm.getAddress(),
                                sellerVm.getZipCode())
                ));
    }
}