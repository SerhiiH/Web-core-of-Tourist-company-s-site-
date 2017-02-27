import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by User on 20.02.17.
 */
public class TripDate {
    SimpleDateFormat sdf = new SimpleDateFormat("dd:MM:yyyy");
    private Date arrivalDate;
    private Date departueDate;

    public TripDate(Date arrivalDate, Date departueDate) {
        this.arrivalDate = arrivalDate;
        this.departueDate = departueDate;
    }

    public TripDate(String arrivalDate, String departueDate) {
        try {
            this.arrivalDate = sdf.parse(arrivalDate);
            this.departueDate = sdf.parse(departueDate);
        } catch(ParseException e){
            System.out.println("Wrong Data format");
        }
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Date getDepartueDate() {
        return departueDate;
    }

    public void setDepartueDate(Date departueDate) {
        this.departueDate = departueDate;
    }

    @Override
    public String toString() {
        return "TripDate{" +
                "arrivalDate=" + arrivalDate +
                ", departueDate=" + departueDate +
                '}';
    }
}
