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
@Table(name = "blood_plessure")
public class BloodPlessure implements Convertable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long downPlessure;

    @Column
    private Long upperPlessure;

    @Column
    private LocalDate recordDate;

    @ManyToOne
    @JoinColumn(name = "user_blood_id")
    @JsonBackReference
    private User userBloodId;

}
