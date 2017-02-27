import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 20.02.17.
 */
public class Hotels {
    List<Hotel> hotels = new ArrayList<>();

    public Hotels() {
        super();
    }

    public void addHotel(Hotel hotel){
        this.hotels.add(hotel);
    }

    public void removeHotel(Hotel hotel){
        this.hotels.remove(hotel);
    }

}
