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
    private Long id;
    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;
    @Column(name = "city_name", nullable = false)
    private String name;
    @Column(name = "city's_arrival_time", nullable = false)
    private LocalDateTime arrivalTime;
    @Column(name = "city's_departure_time", nullable = false)
    private LocalDateTime departureTime;
    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Hotel> hotels;

    public City() {

    }

    public City(String cityName, LocalDateTime arrivalTime, LocalDateTime departureTime, Set<Hotel> hotels) {
        this.name = cityName;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.hotels = hotels;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCityName() {
        return name;
    }

    public void setCityName(String cityName) {
        this.name = cityName;
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
        return Objects.equals(id, city.id) && Objects.equals(country, city.country) && Objects.equals(name, city.name) && Objects.equals(arrivalTime, city.arrivalTime) && Objects.equals(departureTime, city.departureTime) && Objects.equals(hotels, city.hotels);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, country, name, arrivalTime, departureTime, hotels);
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", country=" + country +
                ", cityName='" + name + '\'' +
                ", arrivalTime=" + arrivalTime +
                ", departureTime=" + departureTime +
                ", hotels=" + hotels +
                '}';
    }
}
