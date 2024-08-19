package backend.dto;

import backend.entities.City;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;
import java.util.Set;

public class CountryRequest {
    private String countryName;
    private Set<City> cities;
    private LocalDateTime arrivalTime;
    private LocalDateTime departureTime;


    public CountryRequest() {

    }

    public CountryRequest(String countryName, Set<City> cities, LocalDateTime arrivalTime, LocalDateTime departureTime) {
        this.countryName = countryName;
        this.cities = cities;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Set<City> getCities() {
        return cities;
    }

    public void setCities(Set<City> cities) {
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
        CountryRequest that = (CountryRequest) o;
        return Objects.equals(countryName, that.countryName) && Objects.equals(cities, that.cities) && Objects.equals(arrivalTime, that.arrivalTime) && Objects.equals(departureTime, that.departureTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryName, cities, arrivalTime, departureTime);
    }

    @Override
    public String toString() {
        return "CountryRequest{" +
                "countryName='" + countryName + '\'' +
                ", cities=" + cities +
                ", arrivalTime=" + arrivalTime +
                ", departureTime=" + departureTime +
                '}';
    }
}
