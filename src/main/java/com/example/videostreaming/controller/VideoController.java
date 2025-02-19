package com.example.videostreaming.controller;

import com.example.videostreaming.entity.Video;
import com.example.videostreaming.entity.VideoEngagement;
import com.example.videostreaming.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/videos")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @PostMapping
    public Video publishVideo(@RequestBody Video video) {
        return videoService.saveVideo(video);
    }

    @PutMapping("/{id}")
    public Video editVideo(@PathVariable Long id, @RequestBody Video video) {
        return videoService.updateVideo(id, video);
    }

    @DeleteMapping("/{id}")
    public void deleteVideo(@PathVariable Long id) {
        videoService.deleteVideo(id);
    }

    @GetMapping("/{id}")
    public Video getVideo(@PathVariable Long id) {
        return videoService.findVideo(id);
    }

    @GetMapping("/play-video/{id}")
    public String playVideo(@PathVariable Long id) {
        videoService.playVideo(id);
        return "Playing video with ID: " + id;
    }

    @GetMapping
    public List<Video> findAllVideos() {
        return videoService.findAllVideos();
    }

    @GetMapping("/search")
    public List<Video> searchVideos(@RequestParam String director) {
        return videoService.findVideosByDirector(director);
    }

    @GetMapping("/engagement-data/{id}")
    public VideoEngagement getEngagement(@PathVariable Long id) {
        return videoService.findVideoEngagementDetails(id);
    }
}