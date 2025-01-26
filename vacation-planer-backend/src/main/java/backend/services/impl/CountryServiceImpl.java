package backend.services.impl;

import backend.entities.Country;
import backend.repositories.CountryRepository;
import backend.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryRepository countryRepository;

    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Override
    public Country addCountry(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public Country updateCountry(Country updatedCountry) {
        return null;
    }

    @Override
    public void deleteCountry(Long countryId) {
        countryRepository.deleteById(countryId);
    }

    @Override
    public Country getCountryDetails(Long countryId) {
        return null;
    }
}
