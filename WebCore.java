import java.util.*;

/**
 * Created by Сергей on 25.02.2017.
 */
public class WebCore {
    private final InternalCores cores;
    private InnerCore core;
    private int input;
    private Trips allTrips;
    private Trips selectedTrips;
    private final Hotels allHotels;
    private boolean firstFiltering;
    private boolean firstSorting;


    private WebCore() {
//      initially core will be assigned to filtering core
        input = 1;
        cores = new InternalCores();
        allHotels = new Hotels();
        allTrips = new Trips();
        selectedTrips = new Trips();
        firstFiltering = true;
        firstSorting = true;
    }
    public static WebCore newWebCore() { return new WebCore(); }
    public void perform() {
        runCore();
        printSelectedTrips();
        while(true) {
            showMenu();
            handleInput();
            runCore();
            printSelectedTrips();
        }
    }
    private void showMenu() {
        System.out.format("%-32s%s%-31s%s%-31s%s", "\nTo filter trips, press", "  -  1\n",
                "To sort trips, press", "  -  2\n", "If you made your choice, press", "  -  0");
    }
    private void handleInput() {
        System.out.print("\nEnter your choice: ");
        Scanner scanner = new Scanner(System.in);
        do {
            while(!scanner.hasNextInt()) {
                System.out.print("\tInvalid input! Enter one of the numbers mentioned above: ");
                scanner.next();
            }
            input = scanner.nextInt();
            if(input == 0) {
                System.out.println("\n\nThank you for having chosen us! See you later!");
                System.exit(0);
            }
            if(input < 0 || input > cores.amount())
                System.out.print("\tInvalid input! Enter one of the numbers mentioned above: ");
        } while(input < 0 || input > cores.amount());
    }
    private void runCore() {
        core = cores.getCore(input);
        core.perform();
    }
    private void printSelectedTrips() { selectedTrips.printTrips(); }


    private class InternalCores {
        private final Map<Integer, InnerCore> internalCores;

        InternalCores() {
            internalCores = new HashMap<>();
            internalCores.put(1, new FilteringCore());
            internalCores.put(2, new SortingCore());
        }
        InnerCore getCore(int key) {
            return internalCores.get(key);
        }
        public int amount() {
            return internalCores.size();
        }

        private class FilteringCore implements InnerCore {
            private int input;
            private final FilterParameters parameters;

            FilteringCore() {
                input = -1;
                parameters = FilterParameters.newFilterParameters();
            }
            public void perform() {
                showParameters();
                getInput();
                specifyParameter();
                modifyTrips();
            }
            public void showParameters() {
                System.out.println("\nParameters for trips filtering:");
                System.out.print(parameters);
                System.out.println("To escape, press  -  0");
            }
            public void getInput() {
                Scanner scanner = new Scanner(System.in);
                do {
                    System.out.print("Enter the number of the criterion specified above: ");
                    while(!scanner.hasNextInt()) {
                        System.out.print("\tInvalid input! ");
                        System.out.print("Enter the number of the criterion specified above: ");
                        scanner.next();
                    }
                    input = scanner.nextInt();
                    if(input == 0) {
                        System.out.println("\n\nSee you later!");
                        System.exit(0);
                    }
                    if(input < 0 || input > parameters.amount())
                        System.out.print("\tInvalid input! ");
                } while(input < 0 || input > parameters.amount());
            }
            public void specifyParameter() { parameters.getParameter(input).specifyParameter(); }
            public void modifyTrips() {
                if(firstFiltering) {
                    selectedTrips = allTrips.filterTrips(parameters.getParameter(input));
                    firstFiltering = false;
                }
                else
                    selectedTrips = selectedTrips.filterTrips(parameters.getParameter(input));
            }
        }
        private class SortingCore implements InnerCore {
            private final SortParameters parameters;
            private int inputOne;
            private int inputTwo;


            SortingCore() {
                inputOne = -1;
                inputTwo = -1;
                parameters = SortParameters.newSortParameters();
            }
            public void perform() {
                showParameters();
                getInput();
                modifyTrips();
            }
            public void showParameters() {
                System.out.println("\nParameters for trips sorting:");
                System.out.print(parameters);
                System.out.println("To escape, press  -  0");}
            public void getInput() {
                getFirstInput();
                getSecondInput();
            }
            private void getFirstInput() {
                Scanner scanner = new Scanner(System.in);
                do {
                    System.out.print("Enter the number of the criterion specified above: ");
                    while(!scanner.hasNextInt()) {
                        System.out.print("\tInvalid input! ");
                        System.out.print("Enter the number of the criterion specified above: ");
                        scanner.next();
                    }
                    inputOne = scanner.nextInt();
                    if(inputOne == 0) {
                        System.out.println("\n\nSee you later!");
                        System.exit(0);
                    }
                    if(inputOne < 0 || inputOne > parameters.amount())
                        System.out.print("\tInvalid input! ");
                } while(inputOne < 0 || inputOne > parameters.amount());
            }
            private void getSecondInput() {
                System.out.println("\tTo sort in ascending order, press  -  1\n" +
                        "\tTo sort in descending order, press  -  2\n" +
                        "\tTo escape, press  -  0");
                Scanner scanner = new Scanner(System.in);
                do {
                    System.out.print("Enter one of the numbers specified above: ");
                    while(!scanner.hasNextInt()) {
                        System.out.print("\tInvalid input! ");
                        System.out.print("Enter one of the numbers specified above: ");
                        scanner.next();
                    }
                    inputTwo = scanner.nextInt();
                    if(inputTwo == 0) {
                        System.out.println("\n\nSee you later!");
                        System.exit(0);
                    }
                    if(inputTwo < 0 || inputTwo > 2)
                        System.out.print("\tInvalid input! ");
                } while(inputTwo < 0 || inputTwo > 2);
            }
            public void modifyTrips() {
                if(firstSorting) {
                    selectedTrips = allTrips.sortTrips(parameters.getParameter(inputOne, inputTwo));
                    firstSorting = false;
                }
                else
                    selectedTrips = selectedTrips.sortTrips(parameters.getParameter(inputOne, inputTwo));
            }
        }
    }
}