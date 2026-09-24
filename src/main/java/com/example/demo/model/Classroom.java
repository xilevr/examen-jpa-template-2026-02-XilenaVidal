package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "classrooms")
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "course_code", nullable = false)
    private String courseCode;

    @Column(name = "semester", nullable = false)
    private String semester;



    @JsonIgnore
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "classroom", cascade = CascadeType.ALL)
    private List<Assignment> assignments;

}
