package com.example.demo.service;

import com.example.demo.domain.Weather;
import com.example.demo.domain.WeatherJson;
import com.example.demo.repository.IWeatherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@Service
public class WeatherService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private IWeatherRepo iWeatherRepo;

    private final String appid = "&appid=f6b4e8fd48e99d149ddb8971680c771a";
    private final String urlWeather = "http://api.openweathermap.org/data/2.5/weather?q=";
    private final String cities[] = new String[] {"Krasnodar", "Sochi"};
    private static final double ABS_ZERO = 273.15;

    public List<Weather> getWeather(LocalDate date) {
        return iWeatherRepo.findAllByWeatherDate(date);
    }

    @Scheduled(cron = "0/5 * * * * *")
    public void saveWeather() {
        for (String city: cities) {

            WeatherJson weather = restTemplate.getForEntity(urlWeather + city + appid, WeatherJson.class).getBody();
            LocalDate date = LocalDate.ofInstant(Instant.ofEpochMilli(weather.getDt()), ZoneId.systemDefault());
            Weather weatherFront = iWeatherRepo.findByWeatherDateAndCity(date, weather.getName());

            if (weatherFront != null) {
                weatherFront.setDegree(weather.getMain().getTemp() - ABS_ZERO);
            } else {
                weatherFront = new Weather(weather.getName(), date, weather.getMain().getTemp() - ABS_ZERO);
            }

            iWeatherRepo.save(weatherFront);
        }


    }
}
