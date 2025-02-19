package com.example.videostreaming.controller;

import com.example.videostreaming.constants.EndpointConstants;
import com.example.videostreaming.entity.Video;
import com.example.videostreaming.entity.VideoEngagement;
import com.example.videostreaming.service.VideoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(EndpointConstants.VIDEO_ENTRY_ENDPOINT_V1 + EndpointConstants.VIDEO_ENTRY_ENDPOINT) // Add versioning to base path
public class VideoController {

    @Autowired
    private VideoService videoService;

    @PostMapping
    public ResponseEntity<Video> publishVideo(@RequestBody Video video) {
        log.info("Inside VideoController :: publishVideo()");
        return new ResponseEntity<>(videoService.saveVideo(video), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Video> editVideo(@PathVariable Long id, @RequestBody Video video) {
        log.info("Inside VideoController :: editVideo()");
        return new ResponseEntity<>(videoService.updateVideo(id, video), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Video> deleteVideo(@PathVariable Long id) {
        log.info("Inside VideoController :: deleteVideo()");
        return new ResponseEntity<>(videoService.deleteVideo(id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Video> getVideo(@PathVariable Long id) {
        log.info("Inside VideoController :: getVideo()");
        return new ResponseEntity<>(videoService.findVideo(id), HttpStatus.FOUND);
    }

    @GetMapping(EndpointConstants.PLAY_VIDEO_ENDPOINT + "/{id}")
    public ResponseEntity<String> playVideo(@PathVariable Long id) {
        log.info("Inside VideoController :: playVideo()");
        return new ResponseEntity<>(videoService.playVideo(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Video>> findAllVideos() {
        log.info("Inside VideoController :: findAllVideos()");
        return new ResponseEntity<>(videoService.findAllVideos(), HttpStatus.FOUND);
    }

    @GetMapping(EndpointConstants.SEARCH_VIDEO_ENDPOINT)
    public ResponseEntity<List<Video>> searchVideos(@RequestParam String director) {
        log.info("Inside VideoController :: searchVideos()");
        return new ResponseEntity<>(videoService.findVideosByDirector(director), HttpStatus.FOUND);
    }

    @GetMapping(EndpointConstants.VIDEO_ENGAGEMENT_DATA_ENDPOINT + "/{id}")
    public ResponseEntity<VideoEngagement> getEngagement(@PathVariable Long id) {
        log.info("Inside VideoController :: getEngagement()");
        return new ResponseEntity<>(videoService.findVideoEngagementDetails(id), HttpStatus.OK);
    }
}