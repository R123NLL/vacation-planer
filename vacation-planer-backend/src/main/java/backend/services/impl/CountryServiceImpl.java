package backend.services.impl;

import backend.entities.Country;
import backend.entities.UserType;
import backend.repositories.CityRepository;
import backend.repositories.CountryRepository;
import backend.repositories.HotelRepository;
import backend.services.AuthServiceBase;
import backend.services.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CountryServiceImpl extends AuthServiceBase implements CountryService {
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
    public List<Country> getAllCountries() {
        ensureLoggedIn(getLoggedInUserId());
        return countryRepository.findAll();
    }
    @Override
    public Country addCountry(Country country) {
        ensureLoggedIn(getLoggedInUserId());
        return countryRepository.save(country);
    }
    @Override
    public void deleteCountry(Long countryId) {
        ensureLoggedIn(getLoggedInUserId());
        countryRepository.deleteById(countryId);
    }
    public Country updateCountry(Country updatedCountry){
        ensureLoggedIn(getLoggedInUserId());
        //todo Logic for updating country details
        return countryRepository.save(updatedCountry);
    }
    public Country getCountryDetails(Long countryId){
        ensureLoggedIn(getLoggedInUserId());
        return countryRepository.findById(countryId)
                .orElseThrow(() -> new IllegalArgumentException("Country with id: "+countryId+" not found"));
    }
}
