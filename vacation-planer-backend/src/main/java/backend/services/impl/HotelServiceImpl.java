package backend.services.impl;

import backend.entities.Category;
import backend.entities.Hotel;
import backend.entities.UserType;
import backend.repositories.CityRepository;
import backend.repositories.CountryRepository;
import backend.repositories.HotelRepository;
import backend.services.AuthServiceBase;
import backend.services.HotelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;



@Service
public class HotelServiceImpl extends AuthServiceBase implements HotelService{
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private CountryRepository countryRepository;

    private Long userId;
    private static final Logger logger = LoggerFactory.getLogger(HotelServiceImpl.class);

    public HotelServiceImpl(){

    }

    public boolean login(String username, String password, UserType userType){
        return new LoginServiceImpl().login(username,password,userType);
    }
    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel addHotel(Hotel hotel){
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel updateHotel(Hotel hotel) {
        return null;
    }

    @Override
    public List<Hotel> getHotels(Long cityId, Category category) {
        return null;
    }

    @Override
    public List<Hotel> getHotels(Long cityId, double maxPrice) {
        return null;
    }

    @Override
    public Hotel getHotelDetail(Long hotelId) {
        ensureLoggedIn(userId);
        return null;
    }

    @Override
    public void deleteHotel(Long hotelId) {
        hotelRepository.deleteById(hotelId);
    }

    @Override
    public Long getIdByNameAndCityName(String hotelName, String cityName) {
        return null;
    }

}
