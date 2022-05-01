package com.zooplus.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Status {
   private String timestamp;
   private int error_code;
   private String error_message;
   private int elapsed;
   private int credit_count;
   private String notice;
   private int total_count;
}
