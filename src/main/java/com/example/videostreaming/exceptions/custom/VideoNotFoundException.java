package com.example.videostreaming.exceptions.custom;

public class VideoNotFoundException extends RuntimeException{
    public VideoNotFoundException(String message){
        super(message);
    }
}
