package com.viettran.springbootfinalpractice.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToMany
    @JoinTable(
            name = "book_user",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> authors;
}
