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
    private String cityName;
    private LocalDateTime arrivalTime;
    private LocalDateTime departureTime;
    private Set<Hotel> hotels;

    public CityRequest() {

    }

    public CityRequest(Long countryId, String cityName, LocalDateTime arrivalTime, LocalDateTime departureTime, Set<Hotel> hotels) {
        this.countryId = countryId;
        this.cityName = cityName;
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
        CityRequest that = (CityRequest) o;
        return Objects.equals(countryId, that.countryId) && Objects.equals(cityName, that.cityName) && Objects.equals(arrivalTime, that.arrivalTime) && Objects.equals(departureTime, that.departureTime) && Objects.equals(hotels, that.hotels);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryId, cityName, arrivalTime, departureTime, hotels);
    }

    @Override
    public String toString() {
        return "CityRequest{" +
                "countryId=" + countryId +
                ", cityName='" + cityName + '\'' +
                ", arrivalTime=" + arrivalTime +
                ", departureTime=" + departureTime +
                ", hotels=" + hotels +
                '}';
    }
}
