package com.example.demo.domain;

import lombok.Data;

@Data
public class WeatherJson {
    private String name;
    private Long dt;
    public Info main;

    @Data
    public class Info {
        private Double temp;
    }

}
