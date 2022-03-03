package Fund6Exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

public class VehicleCatalogue {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Vehicle> vehicles = new ArrayList<>();
        String line = scan.nextLine();

        while (!line.equals("End")) {
            String[] data = line.split("\\s+");
            Vehicle vehicle = new Vehicle(data[0], data[1], data[2], Integer.parseInt(data[3]));
            vehicles.add(vehicle);
            line = scan.nextLine();
        }

        line = scan.nextLine();

        while (!line.equals("Close the Catalogue")) {
            String model = line;
            vehicles.stream().filter(vehicle -> vehicle.getModel().equals(model)).forEach(vehicle -> System.out.println(vehicle.toString()));
            line = scan.nextLine();
        }

        List<Vehicle> cars = vehicles.stream().filter(vehicle -> vehicle.getType().equals("car")).collect(Collectors.toList());
        List<Vehicle> trucks = vehicles.stream().filter(vehicle -> vehicle.getType().equals("truck")).collect(Collectors.toList());

        double carsAvgHp = averageHp(cars);
        double trucksAvgHp = averageHp(trucks);

        System.out.printf("Cars have average horsepower of: %.2f.%n", carsAvgHp);
        System.out.printf("Trucks have average horsepower of: %.2f.%n", trucksAvgHp);
    }

    private static double averageHp(List<Vehicle> vehiclesByType) {

        if (vehiclesByType.size() == 0) {
            return 0;
        }

        return vehiclesByType.stream().mapToDouble(Vehicle::getHorsepower).sum() / vehiclesByType.size();
    }

    static class Vehicle {
        String type;
        String model;
        String color;
        int horsepower;

        public Vehicle(String type, String model, String color, int horsepower) {
            this.type = type;
            this.model = model;
            this.color = color;
            this.horsepower = horsepower;
        }

        @Override
        public String toString() {
            return String.format("Type: %s%nModel: %s%nColor: %s%nHorsepower: %d", getType().toUpperCase().charAt(0) + getType().substring(1), this.model, this.color, this.horsepower);
        }

        public String getType() {
            return type;
        }

        public String getModel() {
            return model;
        }

        public String getColor() {
            return color;
        }

        public int getHorsepower() {
            return horsepower;
        }
    }
}
