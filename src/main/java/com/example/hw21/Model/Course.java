package com.example.hw21.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.awt.geom.PathIterator;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "should be not empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;
    @ManyToOne
    @JoinColumn(name = "teacher_id",referencedColumnName = "id")
    @JsonIgnore
    private Teacher teacher;
}
