package com.example.military.DTO.holes;

import lombok.Data;

import java.time.LocalDate;

@Data
public class HolesCreateRequest {

    private String place;
    private String status;
    private LocalDate recordDate;

}
