package backend.repositories;

import backend.entities.City;
import backend.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City,Long> {
    boolean existsById(Long id);
    List<Hotel> findByCityId(Long id);
    List<Hotel> findByCityIdAndPriceLessThenEqual(Long id, double maxPrice);
}
