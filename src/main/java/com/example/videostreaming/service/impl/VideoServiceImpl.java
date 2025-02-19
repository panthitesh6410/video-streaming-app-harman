package com.example.videostreaming.service.impl;

import com.example.videostreaming.constants.StringConstants;
import com.example.videostreaming.entity.Video;
import com.example.videostreaming.entity.VideoEngagement;
import com.example.videostreaming.exceptions.custom.VideoEngagementNotFoundException;
import com.example.videostreaming.exceptions.custom.VideoNotFoundException;
import com.example.videostreaming.repository.VideoEngagementRepository;
import com.example.videostreaming.repository.VideoRepository;
import com.example.videostreaming.service.VideoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoRepository videoRepository;

    @Autowired
    private VideoEngagementRepository engagementRepository;

    @Override
    @Transactional
    public Video saveVideo(Video video) {
        log.info("Inside VideoServiceImpl :: saveVideo()");
        Video saved = videoRepository.save(video);
        VideoEngagement videoEngagement = new VideoEngagement();
        videoEngagement.setVideoId(saved.getId());
        engagementRepository.save(videoEngagement);
        log.info("saveVideo() :: video saved successfully for - {}", video.getTitle());
        return saved;
    }

    @Override
    public Video updateVideo(Long id, Video updatedVideo) {
        log.info("Inside VideoServiceImpl :: updateVideo()");
        Optional<Video> videoFromDB = videoRepository.findById(id);
        if(videoFromDB.isEmpty()) throw new VideoNotFoundException("Video Not Found for "+id);
        Video video = videoFromDB.get();
        video.setTitle(updatedVideo.getTitle());
        video.setSynopsis(updatedVideo.getSynopsis());
        video.setDirector(updatedVideo.getDirector());
        video.setCast(updatedVideo.getCast());
        video.setYearOfRelease(updatedVideo.getYearOfRelease());
        video.setGenre(updatedVideo.getGenre());
        video.setRunningTime(updatedVideo.getRunningTime());
        log.info("updateVideo() :: video updated successfully for - {}", video.getTitle());
        return videoRepository.save(video);
    }

    @Override
    public Video deleteVideo(Long id) {
        log.info("Inside VideoServiceImpl :: deleteVideo()");
        Optional<Video> videoFromDB = videoRepository.findById(id);
        if(videoFromDB.isEmpty()) throw new VideoNotFoundException("Video Not Found for "+id);
        Video video = videoFromDB.get();
        video.setIsDeleted(true);
        log.info("deleteVideo() :: video deleted successfully for - {}", video.getTitle());
        return videoRepository.save(video);
    }

    @Override
    public Video findVideo(Long id) {
        log.info("Inside VideoServiceImpl :: findVideo()");
        Optional<Video> videoFromDB = videoRepository.findById(id);
        if(videoFromDB.isEmpty()) throw new VideoNotFoundException("Video Not Found for "+id);
        log.info("findVideo() :: video found successfully for Id - {}", id);
        return videoFromDB.get();
    }

    @Override
    public List<Video> findAllVideos() {
        log.info("Inside VideoServiceImpl :: findAllVideos()");
        List<Video> allVideos = videoRepository.findByIsDeletedFalse();
        log.info("findAllVideos() :: Total Videos Found - {}", allVideos.size());
        if(allVideos.isEmpty())     throw new VideoNotFoundException("No Videos Found");
        return allVideos;
    }

    @Override
    public List<Video> findVideosByDirector(String director) {
        log.info("Inside VideoServiceImpl :: findVideosByDirector()");
        List<Video> videos = videoRepository.findByDirectorContainingAndIsDeletedFalse(director);
        log.info("Videos by {} are - {}", director, videos.size());
        if(videos.isEmpty())    throw new VideoNotFoundException("No Videos Found for director - "+ director);
        return videos;
    }

    @Override
    public VideoEngagement findVideoEngagementDetails(Long id) {
        log.info("Inside VideoServiceImpl :: findVideoEngagementDetails()");
        Optional<VideoEngagement> videoEngagement = engagementRepository.findById(id);
        if(videoEngagement.isEmpty())   throw new VideoEngagementNotFoundException("No Engagement Data Found for "+id);
        return videoEngagement.get();
    }

    @Override
    public String playVideo(Long id) {
        log.info("Inside VideoServiceImpl :: playVideo()");
        Optional<VideoEngagement> videoEngagementFromDB = engagementRepository.findById(id);
        if(videoEngagementFromDB.isPresent()){
            VideoEngagement videoEngagement = videoEngagementFromDB.get();
            videoEngagement.setImpressions(videoEngagement.getImpressions()+1);
            videoEngagement.setViews(videoEngagement.getViews()+1);
            engagementRepository.save(videoEngagement);
        }else{
            log.info("playVideo() :: No Video Found for ID - {}", id);
            throw new VideoNotFoundException("No Video Found for ID - "+ id);
        }
        log.info("playVideo() :: Playing Video for - {}", id);
        return StringConstants.PLAY_API_RESPONSE_STRING + id;
    }
}
