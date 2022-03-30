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
@Table(name = "holes")
public class Holes implements Convertable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String place;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private HolesStatus statusId;

    @ManyToOne
    @JoinColumn(name = "user_holes_id")
    @JsonBackReference
    private User userHolesId;

    @Column
    private LocalDate recordDate;
}
