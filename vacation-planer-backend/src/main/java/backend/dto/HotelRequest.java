package backend.dto;


import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class HotelRequest {
    private Long cityId;
    private String hotelName;
    private int price;
    private int numOfGuests;
    private LocalDateTime arrivalTime;
    private LocalDateTime departureTime;
    private int numOfNights = (int) ChronoUnit.DAYS.between(arrivalTime, departureTime);
    private String linkToSite;

    public HotelRequest() {

    }

    public HotelRequest(Long cityId, String hotelName, int price, int numOfGuests, LocalDateTime arrivalTime, LocalDateTime departureTime, String linkToSite) {
        this.cityId = cityId;
        this.hotelName = hotelName;
        this.price = price;
        this.numOfGuests = numOfGuests;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.linkToSite = linkToSite;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
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
        HotelRequest that = (HotelRequest) o;
        return price == that.price && numOfGuests == that.numOfGuests && numOfNights == that.numOfNights && Objects.equals(cityId, that.cityId) && Objects.equals(hotelName, that.hotelName) && Objects.equals(arrivalTime, that.arrivalTime) && Objects.equals(departureTime, that.departureTime) && Objects.equals(linkToSite, that.linkToSite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityId, hotelName, price, numOfGuests, arrivalTime, departureTime, numOfNights, linkToSite);
    }

    @Override
    public String toString() {
        return "HotelRequest{" +
                "cityId=" + cityId +
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
