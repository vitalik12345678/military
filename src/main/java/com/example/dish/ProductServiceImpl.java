package com.example.dish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.atomic.AtomicInteger;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {


    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<?> calculateProductCall(DIshRequest products) {

        AtomicInteger count = new AtomicInteger();
        AtomicInteger i = new AtomicInteger();

        products.getProducts().forEach( x -> {
            Product product = productRepository.findByName(x).get();

            count.set(product.getCall() *Integer.parseInt( products.getCount().get(i.get())) );
            i.getAndIncrement();
        });

        return ResponseEntity.ok(count);
    }
}
