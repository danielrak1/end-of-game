package com.example.endofgame.entity;

import javax.persistence.*;

@Entity
public class UserExpense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Expense expense;
}
