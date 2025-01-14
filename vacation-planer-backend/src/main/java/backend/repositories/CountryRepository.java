package backend.repositories;

import backend.entities.City;
import backend.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    boolean existsByName(String countryName);
    List<City> findByCountryId(Long id);

}
