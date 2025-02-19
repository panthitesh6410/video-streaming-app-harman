package com.example.videostreaming.repository;

import com.example.videostreaming.entity.VideoEngagement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoEngagementRepository extends JpaRepository<VideoEngagement, Long> {
}
