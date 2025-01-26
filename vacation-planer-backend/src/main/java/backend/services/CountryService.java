package backend.services;


import backend.entities.Country;
import java.util.List;

public interface CountryService {
    List<Country> getAllCountries();
    Country addCountry(Country country);
    Country updateCountry(Country updatedCountry);
    void deleteCountry(Long countryId);
    Country getCountryDetails(Long countryId);
}
