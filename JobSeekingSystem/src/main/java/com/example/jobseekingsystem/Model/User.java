package com.example.jobseekingsystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "name is empty")
    @Size(min = 4, message = "name must be more 4 characters")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Name must contain only letters.")
    @Column(columnDefinition = "varchar(15) not null")
    private String name;

    @Email
    @Column(unique = true, nullable = false)
    private String email;

    @NotEmpty(message = "password is empty")
    @Pattern(regexp = "^[A-Za-z\\d]{7,}$")
    @Column(columnDefinition = "varchar(10) not null")
    private String password;

    @NotNull(message = "age is null")
    @Positive(message = "must be a positive number")
    @Min(value = 21, message = "age must be more than 21")
    @Column(columnDefinition = "int not null")
    private Integer age;

    @NotEmpty(message = "role is empty")
    @Pattern(regexp = "^(JOB_SEEKER|EMPLOYER)$")
    @Column(columnDefinition = "varchar(10) not null")
    private String role;



}
