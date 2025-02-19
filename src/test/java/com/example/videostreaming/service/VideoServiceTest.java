package com.example.videostreaming.service;


import com.example.videostreaming.entity.Video;
import com.example.videostreaming.entity.VideoEngagement;
import com.example.videostreaming.repository.VideoEngagementRepository;
import com.example.videostreaming.repository.VideoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class VideoServiceTest {

    @Mock
    private VideoRepository videoRepository;

    @Mock
    private VideoEngagementRepository engagementRepository;

    @InjectMocks
    private VideoService videoService;

    private Video video;
    private VideoEngagement videoEngagement;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Initializes mocks and injects into the service
        video = new Video();
        video.setId(1L);
        video.setTitle("Inception");
        video.setSynopsis("A mind-bending thriller");
        video.setDirector("Christopher Nolan");
        video.setCast("Leonardo DiCaprio");
        video.setYearOfRelease(2010);
        video.setGenre("Sci-Fi");
        video.setRunningTime(148);
        video.setIsDeleted(false);
        videoEngagement = new VideoEngagement();
        videoEngagement.setVideoId(1L);
        videoEngagement.setImpressions(0);
        videoEngagement.setViews(0);
    }

    @Test
    public void testSaveVideo() {
        when(videoRepository.save(any(Video.class))).thenReturn(video);
        when(engagementRepository.save(any(VideoEngagement.class))).thenReturn(videoEngagement);
        Video savedVideo = videoService.saveVideo(video);
        assertNotNull(savedVideo);
        assertEquals("Inception", savedVideo.getTitle());
        verify(videoRepository, times(1)).save(any(Video.class));
        verify(engagementRepository, times(1)).save(any(VideoEngagement.class));
    }

    @Test
    public void testUpdateVideo() {
        when(videoRepository.findById(1L)).thenReturn(Optional.of(video));
        when(videoRepository.save(any(Video.class))).thenReturn(video);
        Video updatedVideo = new Video();
        updatedVideo.setTitle("Inception 2");
        updatedVideo.setSynopsis("A new mind-bending thriller");
        updatedVideo.setDirector("Christopher Nolan");
        updatedVideo.setCast("Leonardo DiCaprio");
        updatedVideo.setYearOfRelease(2022);
        updatedVideo.setGenre("Sci-Fi");
        updatedVideo.setRunningTime(150);
        Video result = videoService.updateVideo(1L, updatedVideo);
        assertNotNull(result);
        assertEquals("Inception 2", result.getTitle());
        verify(videoRepository, times(1)).save(any(Video.class));
    }

    @Test
    public void testDeleteVideo() {
        when(videoRepository.findById(1L)).thenReturn(Optional.of(video));
        when(videoRepository.save(any(Video.class))).thenReturn(video);
        videoService.deleteVideo(1L);
        assertTrue(video.getIsDeleted());
        verify(videoRepository, times(1)).save(any(Video.class));
    }

    @Test
    public void testFindVideo() {
        when(videoRepository.findById(1L)).thenReturn(Optional.of(video));
        Video result = videoService.findVideo(1L);
        assertNotNull(result);
        assertEquals("Inception", result.getTitle());
    }

    @Test
    public void testFindAllVideos() {
        when(videoRepository.findByIsDeletedFalse()).thenReturn(List.of(video));
        List<Video> videos = videoService.findAllVideos();
        assertNotNull(videos);
        assertFalse(videos.isEmpty());
        assertEquals("Inception", videos.get(0).getTitle());
    }

    @Test
    public void testFindVideosByDirector() {
        when(videoRepository.findByDirectorContainingAndIsDeletedFalse("Christopher Nolan")).thenReturn(List.of(video));
        List<Video> videos = videoService.findVideosByDirector("Christopher Nolan");
        assertNotNull(videos);
        assertFalse(videos.isEmpty());
        assertEquals("Inception", videos.get(0).getTitle());
    }

    @Test
    public void testFindVideoEngagementDetails() {
        when(engagementRepository.findById(1L)).thenReturn(Optional.of(videoEngagement));
        VideoEngagement engagement = videoService.findVideoEngagementDetails(1L);
        assertNotNull(engagement);
        assertEquals(0, engagement.getImpressions());
        assertEquals(0, engagement.getViews());
    }

    @Test
    public void testPlayVideo() {
        when(engagementRepository.findById(1L)).thenReturn(Optional.of(videoEngagement));
        when(engagementRepository.save(any(VideoEngagement.class))).thenReturn(videoEngagement);
        videoService.playVideo(1L);
        assertEquals(1, videoEngagement.getImpressions());
        assertEquals(1, videoEngagement.getViews());
        verify(engagementRepository, times(1)).save(any(VideoEngagement.class));
    }

}

