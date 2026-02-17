package com.sb.quizapp.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Response {
    public Long getId() {
        return id;
    }

    public String getResponse() {
        return response;
    }

    private Long id;
    private String response;
}
