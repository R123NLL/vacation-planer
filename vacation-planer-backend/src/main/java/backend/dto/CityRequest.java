package backend.dto;

import backend.entities.Country;
import backend.entities.Hotel;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;
import java.util.Set;

public class CityRequest {
    private Long countryId;
    private String name;
    private LocalDateTime arrivalTime;
    private LocalDateTime departureTime;
    private Set<Hotel> hotels;

    public CityRequest() {

    }

    public CityRequest(Long countryId, String name, LocalDateTime arrivalTime, LocalDateTime departureTime, Set<Hotel> hotels) {
        this.countryId = countryId;
        this.name = name;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.hotels = hotels;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String cityName) {
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
        CityRequest that = (CityRequest) o;
        return Objects.equals(countryId, that.countryId) && Objects.equals(name, that.name) && Objects.equals(arrivalTime, that.arrivalTime) && Objects.equals(departureTime, that.departureTime) && Objects.equals(hotels, that.hotels);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryId, name, arrivalTime, departureTime, hotels);
    }

    @Override
    public String toString() {
        return "CityRequest{" +
                "countryId=" + countryId +
                ", name='" + name + '\'' +
                ", arrivalTime=" + arrivalTime +
                ", departureTime=" + departureTime +
                ", hotels=" + hotels +
                '}';
    }
}
