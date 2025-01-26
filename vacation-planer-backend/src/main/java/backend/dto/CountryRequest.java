package backend.dto;

import backend.entities.City;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;
import java.util.Set;

public class CountryRequest {
    private String name;
    private Set<City> cities;
    private LocalDateTime arrivalTime;
    private LocalDateTime departureTime;


    public CountryRequest() {

    }

    public CountryRequest(String name, Set<City> cities, LocalDateTime arrivalTime, LocalDateTime departureTime) {
        this.name = name;
        this.cities = cities;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String countryName) {
        this.name = countryName;
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
        return Objects.equals(name, that.name) && Objects.equals(cities, that.cities) && Objects.equals(arrivalTime, that.arrivalTime) && Objects.equals(departureTime, that.departureTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cities, arrivalTime, departureTime);
    }

    @Override
    public String toString() {
        return "CountryRequest{" +
                "name='" + name + '\'' +
                ", cities=" + cities +
                ", arrivalTime=" + arrivalTime +
                ", departureTime=" + departureTime +
                '}';
    }
}
