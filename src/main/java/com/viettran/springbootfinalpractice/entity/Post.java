package com.viettran.springbootfinalpractice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Post implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Size(min = 2)
    private String type;

    @ManyToOne
    @JoinColumn(name = "content_id")
    @JsonManagedReference
    private Content content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private User user;

    //    @Temporal(TemporalType.TIMESTAMP)
    //    @CreatedDate
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Override
    public String toString() {
        return "Post [id=" + id + ", description=" + type + "]";
    }
}
