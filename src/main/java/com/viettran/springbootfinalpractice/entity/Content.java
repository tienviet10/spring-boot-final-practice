package com.viettran.springbootfinalpractice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "content")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public abstract class Content implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Size(min = 10)
    private String description;
}
