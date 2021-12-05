package com.example.endofgame.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private User user;

    private LocalDateTime creationTimestamp;

    private LocalDateTime updateTimestamp;

    @PrePersist
    public void beforeSave (){
        creationTimestamp = LocalDateTime.now();
        updateTimestamp = LocalDateTime.now();
    }

    @PreUpdate
    public void beforeUpdate(){
        updateTimestamp = LocalDateTime.now();
    }
}
