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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JoinColumn(name = "id")
    private long id;
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