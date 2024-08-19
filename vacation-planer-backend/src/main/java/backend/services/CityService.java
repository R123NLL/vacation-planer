package backend.services;

import backend.entities.City;
import backend.entities.Hotel;

import java.util.List;

public interface CityService {
    List<City> getAllCities();
    List<Hotel> getAllHotels(Long cityId);
    City getCityById(Long cityId);
}
