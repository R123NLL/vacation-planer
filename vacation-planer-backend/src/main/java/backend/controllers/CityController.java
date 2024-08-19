package backend.controllers;

import backend.entities.City;
import backend.entities.Hotel;
import backend.services.CityService;
import backend.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {
    @Autowired
    private CityService cityService;
    @Autowired
    private HotelService hotelService;

    @GetMapping
    public List<City> getAllCities(){
        return cityService.getAllCities();
    }

    @GetMapping("/{cityId}/hotels")
    public List<Hotel> getAllHotels(Long cityId){
         return cityService.getAllHotels(cityId);
    }
}
