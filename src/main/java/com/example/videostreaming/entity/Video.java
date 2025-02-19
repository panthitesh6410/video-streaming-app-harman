package com.example.videostreaming.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigInteger;


@Entity
@Table(name = "video")  // Make sure the table name is correct
@Data
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "cast_type")  // Renamed 'cast' to 'cast_type' to match the updated column name
    private String cast;     // Changed the field name to 'castType'
    private String director;
    private String genre;
    private Boolean isDeleted;
    private Integer runningTime;
    private String synopsis;
    private String title;
    private Integer yearOfRelease;
}
