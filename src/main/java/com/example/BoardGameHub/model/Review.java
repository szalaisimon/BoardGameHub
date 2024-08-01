package com.example.BoardGameHub.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Data
@Table
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "ID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "boardGameId", referencedColumnName = "ID")
    private BoardGame boardGame;

    @Column(name = "content")
    private String content;

    @Column(name = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date date;

    @Column(name = "rating")
    private int rating;
}
