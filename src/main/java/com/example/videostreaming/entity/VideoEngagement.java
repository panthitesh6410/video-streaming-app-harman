package com.example.videostreaming.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class VideoEngagement {
    @Id
    private Long videoId;
    private int impressions;
    private int views;
}
