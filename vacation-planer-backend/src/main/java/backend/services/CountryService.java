package backend.services;

import backend.entities.Country;
import java.util.List;

public interface CountryService {
    List<Country> getAllCountries();
    Country addCountry(Country country);
    void deleteCountry(Long countryId);
}
