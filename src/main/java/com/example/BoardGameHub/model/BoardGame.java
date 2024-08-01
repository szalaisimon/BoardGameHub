package com.example.BoardGameHub.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table
public class BoardGame {
    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "numberOfVotes")
    private int numberOfVotes;

    @Column(name = "minPlayer")
    private int minPlayer;

    @Column(name = "maxPlayer")
    private int maxPlayer;

    @Column(name = "minAge")
    private int minAge;

    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private BoardGameCategoryEnum category;

    @Column(name = "picture")
    private String picture;
}
