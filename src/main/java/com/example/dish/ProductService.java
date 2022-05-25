package com.example.dish;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {

    ResponseEntity<?> calculateProductCall(List<String> products);

}
