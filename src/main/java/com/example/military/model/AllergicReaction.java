
package com.example.military.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.example.military.model.mapper.Convertable;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "allergic_reaction")
public class AllergicReaction implements Convertable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "type")
    private AllergicType type;


    @Column
    private LocalDate recordData;

    @ManyToOne
    @JoinColumn(name = "user_allergic_id")
    @JsonBackReference
    private User userAllergicId;
}

