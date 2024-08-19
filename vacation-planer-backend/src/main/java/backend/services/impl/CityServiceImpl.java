package backend.services.impl;

import backend.entities.City;
import backend.entities.Hotel;
import backend.repositories.CityRepository;
import backend.repositories.CountryRepository;
import backend.repositories.HotelRepository;
import backend.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public City getCityById(Long cityId) {
        return cityRepository.getReferenceById(cityId);
    }
}
