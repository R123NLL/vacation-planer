package backend.services;

import backend.entities.Category;
import backend.entities.Hotel;
import org.springframework.stereotype.Service;

import java.util.List;

public interface HotelService {
    List<Hotel> getAllHotels();
    Hotel addHotel(Hotel hotel);
    Hotel updateHotel(Hotel hotel);
    List<Hotel> getHotels(Long cityId, Category category);
    List<Hotel> getHotels(Long cityId, double maxPrice);

    Hotel getHotelDetail(Long hotelId);
    void deleteHotel(Long hotelId);
    Long getIdByNameAndCityName(String hotelName, String cityName);

}
