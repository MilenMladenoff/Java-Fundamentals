package FinalExam03;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class NeedForSpeedIII {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, Car> cars = new LinkedHashMap<>();

        for (int i = 1; i <= n; i++) {
            String[] carData = scan.nextLine().split("\\|");
            String carModel = carData[0];
            int mileage = Integer.parseInt(carData[1]);
            int fuel = Integer.parseInt(carData[2]);
            Car car = new Car(carModel, mileage, fuel);
            cars.put(carModel, car);
        }

        String[] commandLine = scan.nextLine().split(" : ");

        while (!commandLine[0].equals("Stop")) {
            String command = commandLine[0];
            String carModel = commandLine[1];

            switch (command) {
                case "Drive":
                    int distance = Integer.parseInt(commandLine[2]);
                    int fuel = Integer.parseInt(commandLine[3]);

                    if (cars.get(carModel).getFuel() < fuel) {
                        System.out.println("Not enough fuel to make that ride");
                    } else {
                        cars.get(carModel).setMileage(cars.get(carModel).getMileage() + distance);
                        cars.get(carModel).setFuel(cars.get(carModel).getFuel() - fuel);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", carModel, distance, fuel);
                    }

                    if (cars.get(carModel).getMileage() >= 100000) {
                        cars.remove(carModel);
                        System.out.printf("Time to sell the %s!%n", carModel);
                    }

                    break;
                case "Refuel":
                    fuel = Integer.parseInt(commandLine[2]);
                    cars.get(carModel).setFuel(cars.get(carModel).getFuel() + fuel);

                    if (cars.get(carModel).getFuel() <= 75) {
                        System.out.printf("%s refueled with %d liters%n", carModel, fuel);
                    } else {
                        int refueled = fuel - (cars.get(carModel).getFuel() - 75);
                        System.out.printf("%s refueled with %d liters%n", carModel, refueled);
                        cars.get(carModel).setFuel(75);
                    }

                    break;
                case "Revert":
                    int kilometers = Integer.parseInt(commandLine[2]);
                    cars.get(carModel).setMileage(cars.get(carModel).getMileage() - kilometers);

                    if (cars.get(carModel).getMileage() >= 10000) {
                        System.out.printf("%s mileage decreased by %d kilometers%n", carModel, kilometers);
                    } else {
                        cars.get(carModel).setMileage(10000);
                    }

                    break;
            }

            commandLine = scan.nextLine().split(" : ");
        }

        cars.forEach((k, v) -> System.out.println(v.toString()));
    }

    private static class Car {
        String carModel;
        int mileage;
        int fuel;

        public Car(String carModel, int mileage, int fuel) {
            this.carModel = carModel;
            this.mileage = mileage;
            this.fuel = fuel;
        }

        public int getMileage() {
            return mileage;
        }

        public void setMileage(int mileage) {
            this.mileage = mileage;
        }

        public int getFuel() {
            return fuel;
        }

        public void setFuel(int fuel) {
            this.fuel = fuel;
        }

        @Override
        public String toString() {
            return String.format("%s -> Mileage: %d kms, Fuel in the tank: %d lt.", this.carModel, this.mileage, this.fuel);
        }
    }
}
