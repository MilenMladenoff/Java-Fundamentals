package Fund6MoreExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RawData {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<Car> cars = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String input = scan.nextLine();
            String[] data = input.split("\\s+");
            String model = data[0];
            int speed = Integer.parseInt(data[1]);
            int power = Integer.parseInt(data[2]);
            int weight = Integer.parseInt(data[3]);
            String type = data[4];
            double tire1Pressure = Double.parseDouble(data[5]);
            int tire1Age = Integer.parseInt(data[6]);
            double tire2Pressure = Double.parseDouble(data[7]);
            int tire2Age = Integer.parseInt(data[8]);
            double tire3Pressure = Double.parseDouble(data[9]);
            int tire3Age = Integer.parseInt(data[10]);
            double tire4Pressure = Double.parseDouble(data[11]);
            int tire4Age = Integer.parseInt(data[12]);

            Engine engine = new Engine(speed, power);
            Cargo cargo = new Cargo(weight, type);
            Tires tires = new Tires(tire1Pressure, tire1Age, tire2Pressure, tire2Age, tire3Pressure, tire3Age, tire4Pressure, tire4Age);
            Car car = new Car(model, engine, cargo, tires);
            cars.add(car);
        }

        String command = scan.nextLine();

        if (command.equals("fragile")) {
            cars.stream().filter(s -> s.getCargo().getType().equals(command) && (s.getTires().getTire1Pressure() < 1 || s.getTires().getTire2Pressure() < 1
                    || s.getTires().getTire3Pressure() < 1 || s.getTires().getTire4Pressure() < 1)).forEach(s -> System.out.println(s.getModel()));
        } else {
            cars.stream().filter(s -> s.getCargo().getType().equals(command) && s.getEngine().getPower() > 250).forEach(s -> System.out.println(s.getModel()));
        }

    }

    static class Car {
        private String model;
        private Engine engine;
        private Cargo cargo;
        private Tires tires;

        public String getModel() {
            return model;
        }

        public Engine getEngine() {
            return engine;
        }

        public Cargo getCargo() {
            return cargo;
        }

        public Tires getTires() {
            return tires;
        }

        public Car(String model, Engine engine, Cargo cargo, Tires tires) {
            this.model = model;
            this.engine = engine;
            this.cargo = cargo;
            this.tires = tires;
        }
    }

    static class Engine {
        private int speed;
        private int power;

        public int getSpeed() {
            return speed;
        }

        public int getPower() {
            return power;
        }

        public Engine(int speed, int power) {
            this.speed = speed;
            this.power = power;
        }
    }

    static class Cargo {
        private int weight;
        private String type;

        public int getWeight() {
            return weight;
        }

        public String getType() {
            return type;
        }

        public Cargo(int weight, String type) {
            this.weight = weight;
            this.type = type;
        }
    }

    static class Tires {
        private double tire1Pressure;
        private int tire1age;
        private double tire2Pressure;
        private int tire2age;
        private double tire3Pressure;
        private int tire3age;
        private double tire4Pressure;
        private int tire4age;

        public double getTire1Pressure() {
            return tire1Pressure;
        }

        public int getTire1age() {
            return tire1age;
        }

        public double getTire2Pressure() {
            return tire2Pressure;
        }

        public int getTire2age() {
            return tire2age;
        }

        public double getTire3Pressure() {
            return tire3Pressure;
        }

        public int getTire3age() {
            return tire3age;
        }

        public double getTire4Pressure() {
            return tire4Pressure;
        }

        public int getTire4age() {
            return tire4age;
        }

        public Tires(double tire1Pressure, int tire1age, double tire2Pressure, int tire2age, double tire3Pressure, int tire3age, double tire4Pressure, int tire4age) {
            this.tire1Pressure = tire1Pressure;
            this.tire1age = tire1age;
            this.tire2Pressure = tire2Pressure;
            this.tire2age = tire2age;
            this.tire3Pressure = tire3Pressure;
            this.tire3age = tire3age;
            this.tire4Pressure = tire4Pressure;
            this.tire4age = tire4age;
        }
    }
}
