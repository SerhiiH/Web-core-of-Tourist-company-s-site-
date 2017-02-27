/**
 * Created by User on 20.02.17.
 */
public class Trip {
    private TripCategory tripCategory = TripCategory.NONE;
    private Country country = Country.NONE;
    private TripDate date;
    private Hotel hotel;
    private int price = 0;
    private Transport transport;

    public Trip() {
    }

    public Trip(TripCategory tripCategory, Country country, TripDate date, Hotel hotel, int price, Transport transport) {
        this.tripCategory = tripCategory;
        this.country = country;
        this.date = date;
        this.hotel = hotel;
        this.price = price;
        this.transport = transport;
    }

    public Trip(TripCategory tripCategory, Country country) {
        this.tripCategory = tripCategory;
        this.country = country;
    }

    public TripCategory getTripCategory() { return tripCategory; }

    public void setTripCategory(TripCategory tripCategory) {
        this.tripCategory = tripCategory;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public TripDate getDate() {
        return date;
    }

    public void setDate(TripDate date) {
        this.date = date;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }
}
