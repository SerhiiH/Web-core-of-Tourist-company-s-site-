import java.util.*;

/**
 * Created by Сергей on 26.02.2017.
 */
public class FilterParameters {
    private final Map<Integer, FilteringParameter> parameters;


    private FilterParameters() {
        parameters = new HashMap<>();
        parameters.put(1, new FilterByCountry());
        parameters.put(2, new FilterByTripCategory());
    }
    public static FilterParameters newFilterParameters() {
        return new FilterParameters();
    }
    public void addParameter(FilteringParameter param) {
        int key = parameters.size() + 1;
        parameters.put(key, param);
    }
    public FilteringParameter getParameter(int key) {
        return parameters.get(key);
    }
    public int amount() {
        return parameters.size();
    }
    public String toString() {
        StringBuilder tmpString = new StringBuilder();
        for(Map.Entry<Integer, FilteringParameter> mapping : parameters.entrySet()) {
            tmpString.append("\tTo filter by ")
                    .append(mapping.getValue())
                    .append(", press  -  ")
                    .append(mapping.getKey())
                    .append("\n");
        }
        return new String(tmpString);
    }


    private class FilterByCountry implements FilteringParameter {
        private Country country;


        FilterByCountry() {
            country = Country.NONE;
        }
        public void specifyParameter() {
            prompt();
            handleInput();
        }
        private void prompt() {
            System.out.println("\nAvailable countries: ");
            for(Country state : Country.values()) {
                if(state == Country.NONE)
                    continue;
                System.out.println("\tTo choose " + state + ", press  -  " + state.ordinal());
            }
            System.out.println("To escape, press  -  0");
        }
        private void handleInput() {
            Scanner scanner = new Scanner(System.in);
            int input;
            do {
                System.out.print("Enter the number of the country specified above: ");
                while(!scanner.hasNextInt()) {
                    System.out.print("\tInvalid input! ");
                    System.out.print("Enter the number of the country specified above: ");
                    scanner.next();
                }
                input = scanner.nextInt();
                if(input == 0) {
                    System.out.println("\n\nSee you later!");
                    System.exit(0);
                }
                if(input < 0 || input >= Country.values().length)
                    System.out.print("\tInvalid input! ");
            } while(input < 0 || input >= Country.values().length);
            country = Country.getCountry(input);
        }
        public boolean match(Trip trip) {
            return country == trip.getCountry();
        }
        public String toString() {
            return "\"Country\"";
        }
    }
    private class FilterByTripCategory implements FilteringParameter {
        private TripCategory tripCategory;

        FilterByTripCategory() { tripCategory = TripCategory.NONE; }
        public void specifyParameter() {
            prompt();
            handleInput();
        }
        private void prompt() {
            System.out.println("\nTrip categories: ");
            for(TripCategory category : TripCategory.values()) {
                if(category == TripCategory.NONE)
                    continue;
                System.out.println("\tTo choose " + category+ ", press  -  " + category.ordinal());
            }
            System.out.println("To escape, press  -  0");
        }
        private void handleInput() {
            Scanner scanner = new Scanner(System.in);
            int input;
            do {
                System.out.print("Enter the number of the TripCategory specified above: ");
                while(!scanner.hasNextInt()) {
                    System.out.print("\tInvalid input! ");
                    System.out.print("Enter the number of the TripCategory specified above: ");
                    scanner.next();
                }
                input = scanner.nextInt();
                if(input == 0) {
                    System.out.println("\n\nSee you later!");
                    System.exit(0);
                }
                if(input < 0 || input >= TripCategory.values().length)
                    System.out.print("\tInvalid input! ");
            } while(input < 0 || input >= TripCategory.values().length);
            tripCategory = TripCategory.getTripCategory(input);
        }
        public boolean match(Trip trip) { return tripCategory == trip.getTripCategory(); }
        public String toString() {
            return "\"Trip category\"";
        }
    }
}
