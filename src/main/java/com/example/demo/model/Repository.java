package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@Setter
@Entity
@Table(name = "repositories")
public class Repository {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "is_template", nullable = false)
    private Boolean isTemplate;

    @Column(name = "is_private", nullable = false)
    private Boolean isPrivate;

    @Column (name = "created_at", nullable = false)
    private Timestamp createdAt;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "repository_id", nullable = false)
    private List<Repository> repository;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn( name = "commits", nullable = false)
    private List<Commit> commits;

   

    @JsonIgnore
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assignment_id", nullable = false)
    private List<Assignment> assignments;



}
