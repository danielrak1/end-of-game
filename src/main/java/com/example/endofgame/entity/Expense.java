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
public class Expense {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "amount")
    private double amount;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "expense_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate expenseDate;

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
