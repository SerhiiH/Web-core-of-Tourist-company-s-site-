/**
 * Created by Сергей on 25.02.2017.
 */
public class Trip {
    private Country country = Country.NONE;
    private TripCategory tripCategory = TripCategory.NONE;
    private int price = 0;
    private Hotel hotel;

    public Country getCountry() { return country; }
    public TripCategory getTripCategory() { return tripCategory; }
    public int getPrice() { return price; }
    public Hotel getHotel() { return hotel; }
}
