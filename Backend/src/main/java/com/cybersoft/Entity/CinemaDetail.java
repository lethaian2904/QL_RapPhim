package com.cybersoft.Entity;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "cinema_details")
public class CinemaDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cinema_id", nullable = false)
    private Cinema cinema;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "image_path")
    private String imagePath;

    @Column(name = "support_info", columnDefinition = "TEXT")
    private String supportInfo;

    @Column(name = "user_rating")
    private Double userRating;
}

