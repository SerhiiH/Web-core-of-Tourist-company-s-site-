import java.util.*;

/**
 * Created by User on 20.02.17.
 */
public class Trips implements Iterable<Trip>{
    private List<Trip> trips = new ArrayList<>();

    public Trips() {}
    public Trips(int ind) {
        Hotel sirena = new Hotel("Sirena", "Lissabon", 10);
        Hotel bordo = new Hotel("Bordo", "Rim", 9);
        Hotel ocean = new Hotel("Ocean", "Paris", 8);
        Hotel king = new Hotel("King", "Madrid", 10);
        addTrip(new Trip(TripCategory.WINTER_HOLIDAY, Country.PORTUGAL, new TripDate("01:01:2017", "10:01:2017"), sirena, 200, Transport.Plane));
        addTrip(new Trip(TripCategory.BUS_TOUR, Country.ITALY, new TripDate("05:01:2017", "15:01:2017"), bordo, 180, Transport.Bus));
        addTrip(new Trip(TripCategory.SUMMER_HOLIDAY, Country.FRANCE, new TripDate("03:08:2017", "10:08:2017"), ocean, 160, Transport.Train));
        addTrip(new Trip(TripCategory.WEEKEND_TOUR, Country.SPAIN, new TripDate("02:03:2017", "05:03:2017"), king, 200, Transport.Ship));
        addTrip(new Trip(TripCategory.WINTER_HOLIDAY, Country.PORTUGAL, new TripDate("09:01:2017", "14:01:2017"), sirena, 200, Transport.Plane));
        addTrip(new Trip(TripCategory.BUS_TOUR, Country.FRANCE, new TripDate("15:05:2017", "20:05:2017"), ocean, 150, Transport.Ship));
    }

    @Override
    public Iterator<Trip> iterator() {
        return trips.iterator();
    }

    public void addTrip(Trip trip){
        this.trips.add(trip);
    }

    public void removeTrip(Trip trip){
        this.trips.remove(trip);
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public void printTrips(){
        for (Trip a : this.trips) {
            System.out.println(a);
        }
//        System.out.println("Trips are being printed now");
    }

    public Trips sortTrips(Comparator<Trip> comparator){
        Trips result = new Trips();
        result = this;
        Collections.sort(result.trips, comparator);
//        System.out.println("Trips are being sorted now");
        return result;
    }

    public Trips filterTrips(FilteringParameter parametr){
        Trips result = new Trips();
        for (Trip trip : trips){
            if (parametr.match(trip)){
                result.addTrip(trip);
            }
        }
        System.out.println("Trips are being filtered now");
        return result;

    }


}
