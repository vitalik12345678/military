package com.example.military.DTO.allergic;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AllergicReactionCreateRequest {

    private String name;
    private String type;
    private LocalDate recordDate;

}
