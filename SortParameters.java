import java.util.*;

/**
 * Created by Сергей on 26.02.2017.
 */
public class SortParameters {
    private final Map<Integer, List<Comparator<Trip>>> parameters;

    private SortParameters() {
        parameters = new HashMap<>();
        List<Comparator<Trip>> comparatorList = new ArrayList<>(2);
//      add comparator by trip category; first - ascending, second - descending
        comparatorList.add((Trip t1, Trip t2) -> t1.getTripCategory().compareTo(t2.getTripCategory()));
        comparatorList.add((Trip t1, Trip t2) -> t2.getTripCategory().compareTo(t1.getTripCategory()));
        parameters.put(1, new ArrayList<Comparator<Trip>>(comparatorList));
        comparatorList.clear();
//      add comparator by country; first - ascending, second - descending
        comparatorList.add((Trip t1, Trip t2) -> t1.getCountry().compareTo(t2.getCountry()));
        comparatorList.add((Trip t1, Trip t2) -> t2.getCountry().compareTo(t1.getCountry()));
        parameters.put(2, new ArrayList<Comparator<Trip>>(comparatorList));
        comparatorList.clear();
//      add comparator by price; first - ascending, second - descending
        comparatorList.add((Trip t1, Trip t2) -> t1.getPrice() - t2.getPrice());
        comparatorList.add((Trip t1, Trip t2) -> t2.getPrice() - t1.getPrice());
        parameters.put(3, new ArrayList<Comparator<Trip>>(comparatorList));
        comparatorList.clear();
//      add comparator by hotel; first - ascending, second - descending
        comparatorList.add((Trip t1, Trip t2) -> t1.getHotel().getRating() - t2.getHotel().getRating());
        comparatorList.add((Trip t1, Trip t2) -> t2.getHotel().getRating() - t1.getHotel().getRating());
        parameters.put(4, new ArrayList<Comparator<Trip>>(comparatorList));
        comparatorList.clear();
    }
    public static SortParameters newSortParameters() { return new SortParameters(); }
    public int amount() { return parameters.size(); }
    public Comparator<Trip> getParameter(int key1, int key2) { return parameters.get(key1).get(key2 - 1); }
    public String toString() {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("\tTo sort by trip category, press  -  1\n")
                .append("\tTo sort by country, press  -  2\n")
                .append("\tTo sort by trip price, press  -  3\n")
                .append("\tTo sort by hotel rating, press  -  4\n");
        return new String(strBuilder);
    }
}
