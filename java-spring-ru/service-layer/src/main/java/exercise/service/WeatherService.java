package exercise.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import exercise.HttpClient;

import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import exercise.CityNotFoundException;
import exercise.repository.CityRepository;
import exercise.model.City;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class WeatherService {

    @Autowired
    CityRepository cityRepository;

    // Клиент
    HttpClient client;

    // При создании класса сервиса клиент передаётся снаружи
    // В теории это позволит заменить клиент без изменения самого сервиса
    WeatherService(HttpClient client) {
        this.client = client;
    }

    // BEGIN
    public Map getWeather(long id) throws JsonProcessingException {
        City city = cityRepository.findById(id)
                .orElseThrow(() -> new CityNotFoundException(String.format("City with id %s is not found",id)));
        String weatherUrl = String.format("http://weather/api/v2/cities/%s", city.getName());
        return new ObjectMapper().readValue(client.get(weatherUrl), Map.class);
    }
    // END
}
