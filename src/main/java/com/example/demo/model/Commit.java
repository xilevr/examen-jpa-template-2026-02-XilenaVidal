package com.example.demo.model;

import java.security.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "commits")
public class Commit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "commit_hash", nullable = false, unique = true)
    private String commitHash;

    @Column(name = "message", nullable = false)
    private String message;

    @Column(name = "lines_changed", nullable = false)
    private int linesChanged;

    @Column (name = "lines_deleted", nullable = false)
    private int linesDeleted;

    @Column (name = "commit_date", nullable = false)
    private Timestamp commitDate;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "repository_id", nullable = false)
    private Repository repository;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false)
    private List<User> collaborators;
}
