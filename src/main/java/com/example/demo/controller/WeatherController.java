package com.example.demo.controller;

import com.example.demo.domain.Weather;
import com.example.demo.service.WeatherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/weather")
@Api(description="Работает с данными из сервиса погоды")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }


    @PostMapping("/getInfo")
    @ApiOperation(value = "Возвращает информацию о погоде в Краснодаре и Сочи за конкретную дату")
    public List<Weather> getWeather(@RequestBody LocalDate date) {
        return weatherService.getWeather(date);
    }
}