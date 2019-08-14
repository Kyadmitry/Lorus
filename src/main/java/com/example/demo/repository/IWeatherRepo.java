package com.example.demo.repository;

import com.example.demo.domain.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IWeatherRepo extends JpaRepository<Weather, Long> {
    List<Weather> findAllByWeatherDate(LocalDate date);

    Weather findByWeatherDateAndCity(LocalDate date, String city);
}
