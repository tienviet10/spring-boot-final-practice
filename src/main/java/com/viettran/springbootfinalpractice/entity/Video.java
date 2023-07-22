package com.viettran.springbootfinalpractice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "video")
@Getter
@Setter
public class Video extends Content {
    private String url;
    private Integer duration;
}
