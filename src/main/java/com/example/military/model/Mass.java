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
@Table(name = "mass")
public class Mass implements Convertable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long weight;

    @ManyToOne
    @JoinColumn(name = "user_mass_id")
    @JsonBackReference
    private User userMassId;

    @Column
    private LocalDate recordDate;
}
