package exercise.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import exercise.model.City;
import exercise.repository.CityRepository;
import exercise.service.WeatherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


@RestController
public class CityController {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private WeatherService weatherService;

    // BEGIN
    @GetMapping(path = "/cities/{id}")
    public Map getCityWeather(@PathVariable long id) throws JsonProcessingException {
        return weatherService.getWeather(id);
    }

    @GetMapping(path = "/search")
    public List<Map<String, String>> getCities(@RequestParam(value = "name", required = false) String name) {
        List<City> cities;
        if (name == null) {
            cities = cityRepository.findAllByOrderByNameAsc();
        } else {
            cities = cityRepository.findByNameStartingWithIgnoreCase(name);
        }

        return cities.stream().map(city -> {
            try {
                Map<String, String> cityWeatherFull = weatherService.getWeather(city.getId());
                return Map.of("temperature", cityWeatherFull.get("temperature"),
                        "name", cityWeatherFull.get("name"));
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }

        }).sorted(Comparator.comparing(x -> x.get("name"))).toList();


    }
    // END
}

