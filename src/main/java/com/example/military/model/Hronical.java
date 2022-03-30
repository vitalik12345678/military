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
@Table(name = "hronical")
public class Hronical implements Convertable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String disease;

    @ManyToOne
    @JoinColumn(name = "user_hronical_id")
    @JsonBackReference
    private User userHronicalId;

    @Column
    private LocalDate recordDate;
}
