package com.example.military.model;

import com.example.military.model.mapper.Convertable;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "temperature")
public class Temperature implements Convertable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Double value;

    @Column
    private LocalDate recordDate;

    @ManyToOne(targetEntity= User.class)
    @JoinColumn(name = "user_temperature_id")
    @JsonBackReference
    private User userTemperatureId;
}
