package backend.services.impl;

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
public class HotelServiceImpl extends AuthServiceBase implements HotelService {
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
    public List<Hotel> getAllHotels() {
        ensureLoggedIn(getLoggedInUserId());
        return hotelRepository.findAll();
    }
    @Override
    public Hotel addHotel(Hotel hotel) {
        ensureLoggedIn(getLoggedInUserId());
        return hotelRepository.save(hotel);
    }
    @Override
    public void deleteHotel(Long hotelId) {
        ensureLoggedIn(getLoggedInUserId());
        hotelRepository.deleteById(hotelId);
    }
    @Override
    public Hotel updateHotel(Hotel hotel) {
        ensureLoggedIn(getLoggedInUserId());
        //todo Logic for updating hotel details
        return hotelRepository.save(hotel);
    }
    @Override
    public Hotel getHotelDetail(Long hotelId) {
        ensureLoggedIn(getLoggedInUserId());
        return hotelRepository.findById(hotelId)
                .orElseThrow(() -> new IllegalArgumentException("Hotel with id: "+hotelId+" not found"));
    }
}
