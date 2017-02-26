/**
 * Created by Сергей on 25.02.2017.
 */
public interface FilteringParameter {
    void specifyParameter();
    boolean match(Trip trip);
}
