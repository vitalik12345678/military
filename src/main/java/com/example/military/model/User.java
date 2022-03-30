package com.example.military.model;

import com.example.military.model.mapper.Convertable;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User implements UserDetails, Convertable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String email;

    @Column
    private String password;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column
    private Long height;

    @Column
    private String gender;

    @Column
    private String phoneNumber;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id")
    @JsonBackReference
    private Role roleId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rank_id")
    @JsonBackReference
    private Rank rankId;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "userAllergicId")
    @JsonManagedReference
    List<AllergicReaction> allergicReactions;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "userBloodId")
    @JsonManagedReference
    List<BloodPlessure> bloodPlessure;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "userHolesId")
    @JsonManagedReference
    List<Holes> holes;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "userImmunizationId")
    @JsonManagedReference
    List<Immunization> immunizations;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "userMassId")
    @JsonManagedReference
    List<Mass> mass;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "userPulseId")
    @JsonManagedReference
    List<Pulse> pulse;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "userSurgicalId")
    @JsonManagedReference
    List<SurgicalExerciser> surgicalExercisers;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "userTemperatureId")
    @JsonManagedReference
    List<Temperature> temperature;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "userHronicalId")
    @JsonManagedReference
    List<Hronical> hronical;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(roleId.getName());
        return Collections.singletonList(grantedAuthority);
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
