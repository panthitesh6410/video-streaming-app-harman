package com.example.videostreaming.exceptions.handler;

import lombok.Data;

@Data
public class ErrorResponseDto {
    private int errorCode;
    private String errorMessage;
}
