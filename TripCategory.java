/**
 * Created by Сергей on 25.02.2017.
 */
public enum TripCategory {
    NONE, WINTER_HOLIDAY, BUS_TOUR, SUMMER_HOLIDAY, WEEKEND_TOUR;

    public static TripCategory getTripCategory(int ind) {
        return TripCategory.values()[ind - 1];
    }
}
