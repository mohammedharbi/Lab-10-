package com.example.jobseekingsystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class JobPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "title is empty")
    @Size(min = 5,message = "title must be more than 4")
    @Column(columnDefinition = "varchar(20) not null")
    private String title;

    @NotEmpty(message = "description is empty")
    @Column(columnDefinition = "varchar(100) not null")
    private String description;

    @NotEmpty(message = "location is empty")
    @Column(columnDefinition = "varchar(30) not null")
    private String location;

    @NotNull(message = "salary is null")
    @Positive(message = "must be a positive number")
    @Column(columnDefinition = "int not null")
    private Integer salary;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime postingDate;
}
