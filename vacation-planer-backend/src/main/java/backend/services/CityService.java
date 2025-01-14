package backend.services;

import backend.entities.City;
import backend.entities.Hotel;

import java.util.List;
import java.util.Optional;

public interface CityService {
    List<City> getAllCities();
    List<Hotel> getAllHotels(Long cityId);
    City getCityDetails(Long cityId);
}
