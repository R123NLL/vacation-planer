package backend.services.impl;

import backend.entities.City;
import backend.entities.Hotel;
import backend.repositories.CityRepository;
import backend.repositories.HotelRepository;
import backend.services.CityService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    @Override
    public List<Hotel> getAllHotels(Long cityId) {
        return hotelRepository.findByCityId(cityId);
    }

    @Override
    public City addCity(City newCity) {
        return cityRepository.save(newCity);
    }

    @Override
    public City updateCity(City updatedCity) {

        return cityRepository.save(updatedCity);
    }

    @Override
    public void deleteCity(Long cityId) {

    }

    @Override
    public City getCityDetails(Long cityId) {
        return cityRepository.findById(cityId)
                .orElseThrow(() -> new EntityNotFoundException("City not found"));
    }
}
