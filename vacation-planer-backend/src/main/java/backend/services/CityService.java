package backend.services;

import backend.entities.City;
import backend.entities.Country;
import backend.entities.Hotel;

import java.util.List;
import java.util.Optional;

public interface CityService {
    List<City> getAllCities();
    List<Hotel> getAllHotels(Long cityId);
    City addCity(City city);
    City updateCity(City updatedCity);
    void deleteCity(Long cityId);
    City getCityDetails(Long cityId);
}
