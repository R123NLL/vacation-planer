package backend.vacation_planer.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "countries")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name_of_country")
    private String countryName;
    @OneToMany
    @JoinColumn(name = "country's_cities")
    private City[] cities;
    @Column(name = "country's_arrival_time")
    private LocalDateTime arrivalTime;
    @Column(name = "country's_departure_time")
    private LocalDateTime departureTime;

    public Country() {

    }

    public Country(String countryName, City[] cities) {
        this.countryName = countryName;
        this.cities = cities;
    }

    public Long getId() {
        return id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public City[] getCities() {
        return cities;
    }

    public void setCities(City[] cities) {
        this.cities = cities;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(id, country.id) && Objects.equals(countryName, country.countryName) && Arrays.equals(cities, country.cities);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, countryName);
        result = 31 * result + Arrays.hashCode(cities);
        return result;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", countryName='" + countryName + '\'' +
                ", cities=" + Arrays.toString(cities) +
                '}';
    }
}
