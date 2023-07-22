package com.viettran.springbootfinalpractice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "article")
@Getter
@Setter
public class Article extends Content {
    private String text;
    private String author;
}
