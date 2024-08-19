package backend.controllers;


import backend.dto.CountryRequest;
import backend.entities.Country;
import backend.services.CityService;
import backend.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;
    @Autowired
    private CityService cityService;
    @GetMapping
    public List<Country> getAllCountries(){
        return countryService.getAllCountries();
    }

    @PostMapping
    public Country addCountry(@RequestBody CountryRequest countryRequest){
        Country country = new Country(countryRequest.getCountryName(),
                countryRequest.getCities(),countryRequest.getArrivalTime(),countryRequest.getDepartureTime());
        return countryService.addCountry(country);
    }
}
