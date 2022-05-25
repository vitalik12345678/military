package com.example.dish;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Override
    public ResponseEntity<?> calculateProductCall(List<String> products) {
        return ResponseEntity.ok("null");
    }
}
