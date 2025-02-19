package com.example.videostreaming.service;

import com.example.videostreaming.entity.Video;
import com.example.videostreaming.entity.VideoEngagement;
import com.example.videostreaming.repository.VideoEngagementRepository;
import com.example.videostreaming.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class VideoService {

    @Autowired
    private VideoRepository videoRepository;

    @Autowired
    private VideoEngagementRepository engagementRepository;

    @Transactional
    public Video saveVideo(Video video) {
        Video saved = videoRepository.save(video);
        VideoEngagement videoEngagement = new VideoEngagement();
        videoEngagement.setVideoId(saved.getId());
        engagementRepository.save(videoEngagement);
        return saved;
    }

    public Video updateVideo(Long id, Video updatedVideo) {
        Optional<Video> videoFromDB = videoRepository.findById(id);
        if(videoFromDB.isEmpty()) throw new RuntimeException("Video Not Found for "+id);
        Video video = videoFromDB.get();
        video.setTitle(updatedVideo.getTitle());
        video.setSynopsis(updatedVideo.getSynopsis());
        video.setDirector(updatedVideo.getDirector());
        video.setCast(updatedVideo.getCast());
        video.setYearOfRelease(updatedVideo.getYearOfRelease());
        video.setGenre(updatedVideo.getGenre());
        video.setRunningTime(updatedVideo.getRunningTime());
        return videoRepository.save(video);
    }

    public void deleteVideo(Long id) {
        Optional<Video> videoFromDB = videoRepository.findById(id);
        if(videoFromDB.isEmpty()) throw new RuntimeException("Video Not Found for "+id);
        Video video = videoFromDB.get();
        video.setIsDeleted(true);
        videoRepository.save(video);
    }

    public Video findVideo(Long id) {
        Optional<Video> videoFromDB = videoRepository.findById(id);
        if(videoFromDB.isEmpty()) throw new RuntimeException("Video Not Found for "+id);
        return videoFromDB.get();
    }

    public List<Video> findAllVideos() {
        return videoRepository.findByIsDeletedFalse();
    }

    public List<Video> findVideosByDirector(String director) {
        return videoRepository.findByDirectorContainingAndIsDeletedFalse(director);
    }

    public VideoEngagement findVideoEngagementDetails(Long id) {
        Optional<VideoEngagement> videoEngagement = engagementRepository.findById(id);
        if(videoEngagement.isEmpty())   throw new RuntimeException("No Engagement Data Found for "+id);
        return videoEngagement.get();
    }

    public void playVideo(Long id) {
        Optional<VideoEngagement> videoEngagementFromDB = engagementRepository.findById(id);
        if(videoEngagementFromDB.isPresent()){
            VideoEngagement videoEngagement = videoEngagementFromDB.get();
            videoEngagement.setImpressions(videoEngagement.getImpressions()+1);
            videoEngagement.setViews(videoEngagement.getViews()+1);
            engagementRepository.save(videoEngagement);
        }
    }
}
