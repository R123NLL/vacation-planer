package backend.controllers;

import backend.dto.HotelRequest;
import backend.entities.Hotel;
import backend.services.CityService;
import backend.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    private HotelService hotelService;
    @Autowired
    private CityService cityService;
    @GetMapping
    public List<Hotel> getAllHotels(){
         return hotelService.getAllHotels();
    }
    @PostMapping
    public Hotel addHotel(@RequestBody HotelRequest hotelRequest){
        Hotel hotel = new Hotel();

        hotel.setHotelName(hotelRequest.getHotelName());
        hotel.setCity(cityService.getCityById(hotelRequest.getCityId()));
        hotel.setArrivalTime(hotelRequest.getArrivalTime());
        hotel.setDepartureTime(hotelRequest.getDepartureTime());
        hotel.setPrice(hotelRequest.getPrice());
        hotel.setLinkToSite(hotelRequest.getLinkToSite());
        hotel.setNumOfGuests(hotelRequest.getNumOfGuests());

        return hotelService.addHotel(hotel);
    }

    @DeleteMapping
    public void deleteHotel(Long hotelId){
        hotelService.deleteHotel(hotelId);
    }
}
