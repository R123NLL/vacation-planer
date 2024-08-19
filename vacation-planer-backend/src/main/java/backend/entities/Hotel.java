package backend.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

@Entity
@Table(name = "hotels")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
    @Column(name = "hotel_name")
    private String hotelName;
    @Column(name = "hotel_price")
    private int price;
    @Column(name = "num_of_guests")
    private int numOfGuests;
    @Column(name = "hotel's_arrival_time")
    private LocalDateTime arrivalTime;
    @Column(name = "hotel's_departure_time")
    private LocalDateTime departureTime;
    @Column(name = "num_of_nights")
    private int numOfNights;
    @Column(name = "link_to_site")
    private String linkToSite;

    public Hotel() {

    }

    public Hotel(City city, String hotelName, int price, int numOfGuests, LocalDateTime arrivalTime, LocalDateTime departureTime, String linkToSite) {
        this.city = city;
        this.hotelName = hotelName;
        this.price = price;
        this.numOfGuests = numOfGuests;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.numOfNights = (int) ChronoUnit.DAYS.between(arrivalTime, departureTime);
        this.linkToSite = linkToSite;
    }


    public Long getId() {
        return id;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumOfGuests() {
        return numOfGuests;
    }

    public void setNumOfGuests(int numOfGuests) {
        this.numOfGuests = numOfGuests;
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

    public int getNumOfNights() {
        return numOfNights;
    }

    public void setNumOfNights(int numOfNights) {
        this.numOfNights = numOfNights;
    }

    public String getLinkToSite() {
        return linkToSite;
    }

    public void setLinkToSite(String linkToSite) {
        this.linkToSite = linkToSite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return price == hotel.price && numOfGuests == hotel.numOfGuests && numOfNights == hotel.numOfNights && Objects.equals(id, hotel.id) && Objects.equals(hotelName, hotel.hotelName) && Objects.equals(arrivalTime, hotel.arrivalTime) && Objects.equals(departureTime, hotel.departureTime) && Objects.equals(linkToSite, hotel.linkToSite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, hotelName, price, numOfGuests, arrivalTime, departureTime, numOfNights, linkToSite);
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", hotelName='" + hotelName + '\'' +
                ", price=" + price +
                ", numOfGuests=" + numOfGuests +
                ", arrivalTime=" + arrivalTime +
                ", departureTime=" + departureTime +
                ", numOfNights=" + numOfNights +
                ", linkToSite='" + linkToSite + '\'' +
                '}';
    }
}
