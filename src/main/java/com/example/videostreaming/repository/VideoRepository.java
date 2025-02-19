package com.example.videostreaming.repository;

import com.example.videostreaming.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {
    List<Video> findByIsDeletedFalse();
    List<Video> findByDirectorContainingAndIsDeletedFalse(String director);

    Optional<Video> findByIdAndIsDeleted(Long id, boolean b);
}
