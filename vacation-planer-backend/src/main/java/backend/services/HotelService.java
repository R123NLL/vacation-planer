package backend.services;


import backend.entities.Hotel;

import java.util.List;

public interface HotelService {
    List<Hotel> getAllHotels();
    Hotel addHotel(Hotel hotel);
    Hotel updateHotel(Hotel updatedHotel);
    void deleteHotel(Long hotelId);
    Hotel getHotelDetails(Long hotelId);
}
