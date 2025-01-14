package backend.repositories;

import backend.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel,Long> {
    boolean existsByCityId(Long id);
    List<Hotel> findByCityId(Long id);
    List<Hotel> findByCityIdAndPriceLessThanEqual(Long id, double maxPrice);

}
