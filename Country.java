/**
 * Created by Сергей on 25.02.2017.
 */
public enum Country {
    NONE, PORTUGAL, SPAIN, FRANCE, ITALY;

    public static Country getCountry(int ind) {
        return Country.values()[ind];
    }
}
