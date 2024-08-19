package backend.vacation_planer.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "cities")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "city_name")
    private String cityName;
    @Column(name = "city's_arrival_time")
    private LocalDateTime arrivalTime;
    @Column(name = "city's_departure_time")
    private LocalDateTime departureTime;
    @ManyToOne
    @JoinColumn(name = "city's_hotels")
    private Hotel[] hotels;

    public City() {

    }

    public City(String cityName, LocalDateTime arrivalTime, LocalDateTime departureTime, Hotel[] hotels) {
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

    public Hotel[] getHotels() {
        return hotels;
    }

    public void setHotels(Hotel[] hotels) {
        this.hotels = hotels;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(Id, city.Id) && Objects.equals(cityName, city.cityName) && Objects.equals(arrivalTime, city.arrivalTime) && Objects.equals(departureTime, city.departureTime) && Arrays.equals(hotels, city.hotels);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(Id, cityName, arrivalTime, departureTime);
        result = 31 * result + Arrays.hashCode(hotels);
        return result;
    }

    @Override
    public String toString() {
        return "City{" +
                "Id=" + Id +
                ", cityName='" + cityName + '\'' +
                ", arrivalTime=" + arrivalTime +
                ", departureTime=" + departureTime +
                ", hotels=" + Arrays.toString(hotels) +
                '}';
    }
}
