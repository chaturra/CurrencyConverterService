package com.zooplus.model;

import lombok.Data;

@Data
public class ErrorResponse {
    private String code;
    private String errorDetails;
}
