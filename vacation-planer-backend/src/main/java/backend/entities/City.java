package backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "cities")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;
    @Column(name = "city_name", nullable = false)
    private String cityName;
    @Column(name = "city's_arrival_time", nullable = false)
    private LocalDateTime arrivalTime;
    @Column(name = "city's_departure_time", nullable = false)
    private LocalDateTime departureTime;
    @OneToMany(mappedBy = "cities", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Hotel> hotels;

    public City() {

    }

    public City(String cityName, LocalDateTime arrivalTime, LocalDateTime departureTime, Set<Hotel> hotels) {
        this.cityName = cityName;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.hotels = hotels;
    }

    public Long getId() {
        return Id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
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

    public Set<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(Set<Hotel> hotels) {
        this.hotels = hotels;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(Id, city.Id) && Objects.equals(country, city.country) && Objects.equals(cityName, city.cityName) && Objects.equals(arrivalTime, city.arrivalTime) && Objects.equals(departureTime, city.departureTime) && Objects.equals(hotels, city.hotels);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, country, cityName, arrivalTime, departureTime, hotels);
    }

    @Override
    public String toString() {
        return "City{" +
                "Id=" + Id +
                ", country=" + country +
                ", cityName='" + cityName + '\'' +
                ", arrivalTime=" + arrivalTime +
                ", departureTime=" + departureTime +
                ", hotels=" + hotels +
                '}';
    }
}
