package com.example.endofgame.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Builder
@Table(name = "expense")
public class Income {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "amount")
    private double amount;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private  User user;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Category category;

    @Column(name = "income_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate incomeDate;

    private LocalDateTime updateTimestamp;

    @PrePersist
    public void beforeSave (){
        updateTimestamp = LocalDateTime.now();
    }

    @PreUpdate
    public void beforeUpdate(){
        updateTimestamp = LocalDateTime.now();
    }




}
