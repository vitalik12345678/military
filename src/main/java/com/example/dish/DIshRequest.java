package com.example.dish;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
public class DIshRequest {

    private List<String> products;
    private List<String> count;
}
