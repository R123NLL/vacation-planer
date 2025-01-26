package backend.services.impl;

import backend.entities.City;
import backend.entities.Hotel;
import backend.entities.UserType;
import backend.repositories.CityRepository;
import backend.repositories.CountryRepository;
import backend.repositories.HotelRepository;
import backend.services.AuthServiceBase;
import backend.services.CityService;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class CityServiceImpl extends AuthServiceBase implements CityService {
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private LoginServiceImpl loginService;
    private static final Logger logger = LoggerFactory.getLogger(HotelServiceImpl.class);

    public boolean login(String username, String password, UserType userType) {
        boolean isLoggedIn = loginService.login(username, password, userType);
        if (isLoggedIn) {
            setLoggedInUserId(loginService.getLoggedInUserId());
        }
        return isLoggedIn;
    }
    @Override
    public List<City> getAllCities() {
        ensureLoggedIn(getLoggedInUserId());
        return cityRepository.findAll();
    }
    @Override
    public List<Hotel> getAllHotels(Long cityId) {
        ensureLoggedIn(getLoggedInUserId());
        return hotelRepository.findByCityId(cityId);
    }
    public City addCity(City newCity){
        ensureLoggedIn(getLoggedInUserId());
       return cityRepository.save(newCity);
    }
    public void deleteCity(Long cityId){
        ensureLoggedIn(getLoggedInUserId());
        cityRepository.deleteById(cityId);
    }
    public City updateCity(City updatedCity){
        ensureLoggedIn(getLoggedInUserId());
        //todo Logic for updating City details
        return cityRepository.save(updatedCity);
    }
    @Override
    public City getCityDetails(Long cityId) {
        ensureLoggedIn(getLoggedInUserId());
        return cityRepository.findById(cityId)
                .orElseThrow(() -> new EntityNotFoundException("City with id: "+cityId+" not found"));
    }
}
