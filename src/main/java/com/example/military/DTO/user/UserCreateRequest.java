package com.example.military.DTO.user;

import com.example.military.DTO.allergic.AllergicReactionCreateRequest;
import com.example.military.DTO.holes.HolesCreateRequest;
import com.example.military.DTO.hronical.HronicalCreateRequest;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.List;

@Data
public class UserCreateRequest {

    @NotBlank
    @Pattern(regexp = "^[A-Za-zА-Яа-яіїєщІЇЄЩ]{3,20}+$",message = "Incorrect first name")
    private String firstName;

    @NotBlank
    @Pattern(regexp = "^[A-Za-zА-Яа-яіїєщІЇЄЩ]{3,20}+$",message = "Incorrect last name")
    private String lastName;

    @NotBlank
    @Length(min = 5,max = 50)
    @Email
    private String email;

    @NotBlank
    @Length(min = 7,max = 17)
    private String password;

    @NotBlank
    @Pattern(regexp = "^[0-9]+$.(10)")
    private String phoneNumber;

    @NotBlank
    private String rank;

    @NotBlank
    @Length(min = 3, max = 7)
    private String gender;

    @NotBlank
    private LocalDate dateOfBirth;

    @NotBlank
    private Long height;

    @NotBlank
    private String weight;

    @NotEmpty
    private List<AllergicReactionCreateRequest> allergicReactionCreateRequests;

    @NotEmpty
    private List<HronicalCreateRequest> hronicalCreateRequests;

    @NotEmpty
    private List<HolesCreateRequest> holesCreateRequests;

}
