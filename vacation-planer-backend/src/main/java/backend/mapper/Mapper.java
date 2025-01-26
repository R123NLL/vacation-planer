package backend.mapper;

import backend.dto.CityRequest;
import backend.dto.CountryRequest;
import backend.dto.HotelRequest;
import backend.entities.City;
import backend.entities.Country;
import backend.entities.Hotel;
import backend.services.CityService;
import backend.services.CountryService;
import backend.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    @Autowired
    private CountryService countryService;
    @Autowired
    private CityService cityService;
    @Autowired
    private HotelService hotelService;

    public Country mapToCountry(CountryRequest newCountryRequest){
        return  new Country(newCountryRequest.getName(),newCountryRequest.getCities(),
                newCountryRequest.getArrivalTime(),newCountryRequest.getDepartureTime());
    }

    public City mapToCity(CityRequest newCityRequest){
        return new City(newCityRequest.getName(),newCityRequest.getArrivalTime(),
                newCityRequest.getDepartureTime(),newCityRequest.getHotels());
    }

    public Hotel mapToHotel(HotelRequest newHotelRequest){
        return new Hotel(cityService.getCityDetails(newHotelRequest.getCityId()),newHotelRequest.getName(),newHotelRequest.getPrice(),
                newHotelRequest.getNumOfGuests(),newHotelRequest.getArrivalTime(),
                newHotelRequest.getDepartureTime(),newHotelRequest.getLinkToSite());
    }

}
