package com.example.hw21.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Should not empty")
    @Size(min = 3,message = "name is too short")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;
    @NotNull(message = "Should not empty")
    @Min(23)
    @Column(columnDefinition = "int default 23 ")
    private Integer age;
    @NotEmpty(message = "Should not empty")
    @Email(message = "invalid email")
    @Column(columnDefinition = "varchar(30) not null unique")
    private String email;
    @NotNull(message = "Should not empty")
    @Positive(message = "enter positive number")
    @Column(columnDefinition = "double default 10000.0")
    private Double salary;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private Address address;


}
