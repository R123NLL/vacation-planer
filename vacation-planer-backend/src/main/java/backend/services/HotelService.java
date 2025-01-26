package backend.services;

import backend.entities.Category;
import backend.entities.Hotel;
import org.springframework.stereotype.Service;

import java.util.List;

public interface HotelService {
    List<Hotel> getAllHotels();
    Hotel addHotel(Hotel hotel);
    Hotel updateHotel(Hotel hotel);
    Hotel getHotelDetail(Long hotelId);
    void deleteHotel(Long hotelId);


}
