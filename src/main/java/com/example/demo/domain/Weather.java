package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;


import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "weather")
@AllArgsConstructor
public class Weather {
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "weather_id_seq")
//    @SequenceGenerator(name = "weather_id_seq", sequenceName = "weather_id_seq", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String city;
    @Column
    private LocalDate weatherDate;
    @Column
    private double degree;

    public Weather(String city, LocalDate weatherDate, double degree) {
        this.city = city;
        this.weatherDate = weatherDate;
        this.degree = degree;
    }

    public Weather() {}
}