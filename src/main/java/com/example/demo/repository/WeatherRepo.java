//package com.example.demo.repository;
//
//import com.example.demo.domain.WeatherJson;
//import com.example.demo.domain.Weather;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//import java.time.Instant;
//import java.time.LocalDate;
//import java.time.ZoneId;
//import java.util.List;
//
//@Repository
//public class WeatherRepo {
//
//    @Autowired
//    private final JdbcTemplate jdbcTemplate;
//    private static final double ABS_ZERO = 273.15;
//
//
//    public WeatherRepo(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    public void saveData(WeatherJson weather) {
//        String date = LocalDate.ofInstant(Instant.ofEpochMilli(weather.getDt()), ZoneId.systemDefault()).toString();
//        LocalDate localDate = jdbcTemplate.quer ("SElect weather_date from weather");
//
//        jdbcTemplate.update("INSERT INTO WEATHER (city, date_, degree) VALUES (?, ?, ?)",
//                weather.getName(),
//                date,
//                weather.main.getTemp() - ABS_ZERO
//        );
//
//    }
//
//    public List<Weather> getWeather(LocalDate date) {
//        List<Weather> wetherList = jdbcTemplate.query("SELECT city, date_, degree FROM TESTDB.PUBLIC.WEATHER WHERE date_ = " + date.toString(),
//                (rs, i) -> new Weather(
//                        rs.getString("name"),
//                        rs.getDate("date_").toLocalDate(),
//                        rs.getDouble("degree")
//                ));
//        return wetherList;
//    }
//}