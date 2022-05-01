package com.zooplus.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PriceData {
    private int id;
    private String name;
    private String symbol;
    private String slug;
    private Map<String, PriceInfo> quote;
}
