import java.util.Date;

/**
 * Created by User on 20.02.17.
 */
public class Hotel {
    private String name;
    private String city;
    private int rating;

    public Hotel(String name, String city, int rating) {
        super();
        this.name = name;
        this.city = city;
        this.rating = rating;
    }

    public Hotel() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", rating=" + rating +
                '}';
    }
}


