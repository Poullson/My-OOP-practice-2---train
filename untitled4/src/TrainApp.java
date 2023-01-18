import java.util.Scanner;
import java.util.ArrayList;

// Train class has the basic information for all types of trains
class Train {
    String name;
    int maximumSpeed;

    // method to add train details
    public void addTrain(String name, int maximumSpeed) {
        this.name = name;
        this.maximumSpeed = maximumSpeed;
    }

    // method to display train details
    public void displayTrain() {
        System.out.println("Name of the train: " + name);
        System.out.println("Maximum speed: " + maximumSpeed);
    }
}

// Locomotive class inherits from Train class and adds thrust information
class Locomotive extends Train {
    int thrust;

    // method to add Locomotive specific information
    public void addTrain(String name, int maximumSpeed, int thrust) {
        super.addTrain(name, maximumSpeed);
        this.thrust = thrust;
    }

    // overriding the displayTrain method to display Locomotive specific information
    public void displayTrain() {
        super.displayTrain();
        System.out.println("Thrust: " + thrust);
    }
}

// PassengerTrain class inherits from Train class and adds numberOfPassenger information
class PassengerTrain extends Train {
    int numberOfPassengers;

    // method to add PassengerTrain specific information
    public void addTrain(String name, int maximumSpeed, int numberOfPassengers) {
        super.addTrain(name, maximumSpeed);
        this.numberOfPassengers = numberOfPassengers;
    }

    // overriding the displayTrain method to display PassengerTrain specific information
    public void displayTrain() {
        super.displayTrain();
        System.out.println("Number of Passengers: " + numberOfPassengers);
    }
}

// FreightTrain class inherits from Train class and adds weight information
class FreightTrain extends Train {
    int weight;

    // method to add FreightTrain specific information
    public void addTrain(String name, int maximumSpeed, int weight) {
        super.addTrain(name, maximumSpeed);
        this.weight = weight;
    }

    // overriding the displayTrain method to display FreightTrain specific information
    public void displayTrain() {
        super.displayTrain();
        System.out.println("Weight: " + weight);
    }
}

// TrainHandler class has an ArrayList of Train objects and methods for adding new trains and finding existing trains by name
class TrainHandler {
    ArrayList<Train> trainList = new ArrayList<>();

    // method to add a new train to trainList
    public void addTrain(Train train) {
        trainList.add(train);
    }

    // method to find a train by name in trainList
    public Train findTrain(String name) {
        for (Train train : trainList) {
            if (train.name.equals(name)) {
                return train;
            }
        }
        return null;
    }
}

// main class to interact with user
public class TrainApp {
    public static void main(String[] args) {
        TrainHandler th = new TrainHandler();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("----------------------------");
            System.out.println("1. Add new train");
            System.out.println("2. View existing train");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            if (choice == 1) {
                System.out.println("Enter train type (locomotive, passenger, freight): ");
                String trainType = sc.nextLine();
                System.out.println("Enter train name: ");
                String trainName = sc.nextLine();
                System.out.println("Enter maximum speed: ");
                int maximumSpeed = sc.nextInt();
                // handling different train types
                if (trainType.equalsIgnoreCase("locomotive")) {
                    System.out.println("Enter thrust: ");
                    int thrust = sc.nextInt();
                    Locomotive loco = new Locomotive();
                    loco.addTrain(trainName, maximumSpeed, thrust);
                    th.addTrain(loco);
                } else if (trainType.equalsIgnoreCase("passenger")) {
                    System.out.println("Enter number of passengers: ");
                    int numberOfPassengers = sc.nextInt();
                    PassengerTrain passenger = new PassengerTrain();
                    passenger.addTrain(trainName, maximumSpeed, numberOfPassengers);
                    th.addTrain(passenger);
                } else if (trainType.equalsIgnoreCase("freight")) {
                    System.out.println("Enter weight: ");
                    int weight = sc.nextInt();
                    FreightTrain freight = new FreightTrain();
                    freight.addTrain(trainName, maximumSpeed, weight);
                    th.addTrain(freight);
                } else {
                    System.out.println("Invalid train type. Please try again.");
                }
            } else if (choice == 2) {
                System.out.println("Enter train name: ");
                String trainName = sc.nextLine();
                // finding the train by name
                Train t = th.findTrain(trainName);
                if (t != null) {
                    t.displayTrain();
                } else {
                    System.out.println("Train not found");
                }
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}