package com.example.videostreaming.service;

import com.example.videostreaming.entity.Video;
import com.example.videostreaming.entity.VideoEngagement;

import java.util.List;

public interface VideoService {
    Video saveVideo(Video video);
    Video updateVideo(Long id, Video updatedVideo);
    Video deleteVideo(Long id);
    Video findVideo(Long id);
    List<Video> findAllVideos();
    List<Video> findVideosByDirector(String director);
    VideoEngagement findVideoEngagementDetails(Long id);
    String playVideo(Long id);
}
