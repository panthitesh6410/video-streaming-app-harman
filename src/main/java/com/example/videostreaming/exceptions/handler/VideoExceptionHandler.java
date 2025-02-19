package com.example.videostreaming.exceptions.handler;

import com.example.videostreaming.exceptions.custom.VideoEngagementNotFoundException;
import com.example.videostreaming.exceptions.custom.VideoNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class VideoExceptionHandler {
    @ExceptionHandler(VideoNotFoundException.class)
    public final ResponseEntity<Object> handleVideoNotFoundException(
            VideoNotFoundException ex) {
        ErrorResponseDto error = new ErrorResponseDto();
        error.setErrorCode(HttpStatus.NOT_FOUND.value());
        error.setErrorMessage(ex.getLocalizedMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(VideoEngagementNotFoundException.class)
    public final ResponseEntity<Object> handleVideoEngagementNotFoundException(
            VideoEngagementNotFoundException ex) {
        ErrorResponseDto error = new ErrorResponseDto();
        error.setErrorCode(HttpStatus.NOT_FOUND.value());
        error.setErrorMessage(ex.getLocalizedMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
