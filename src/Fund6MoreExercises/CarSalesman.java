package Fund6MoreExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarSalesman {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<Engine> engines = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String input = scan.nextLine();
            String[] data = input.split(" ");
            String model = data[0];
            String power = data[1];
            String displacement = "n/a";
            String efficiency = "n/a";

            if (data.length >= 3) {

                if (data[2].matches("-?\\d+")) {
                    displacement = data[2];
                } else {
                    efficiency = data[2];
                }
            }

            if (data.length == 4) {
                efficiency = data[3];
            }

            Engine engine = new Engine(model, power, displacement, efficiency);
            engines.add(engine);
        }

        int m = Integer.parseInt(scan.nextLine());
        List<Car> cars = new ArrayList<>();

        for (int i = 1; i <= m; i++) {
            String input = scan.nextLine();
            String[] data = input.split(" ");
            String model = data[0];
            String engine = data[1];
            String weight = "n/a";
            String color = "n/a";

            if (data.length >= 3) {

                if (data[2].matches("-?\\d+")) {
                    weight = data[2];
                } else {
                    color = data[2];
                }
            }

            if (data.length == 4) {
                color = data[3];
            }

            String engineModel = null;
            String enginePower = null;
            String engineDisplacement = null;
            String engineEfficiency = null;

            for (Engine carEngine : engines) {
                if (carEngine.getModel().equals(engine)) {
                    engineModel = carEngine.getModel();
                    enginePower = carEngine.getPower();
                    engineDisplacement = carEngine.getDisplacement();
                    engineEfficiency = carEngine.getEfficiency();
                    break;
                }
            }

            Engine thisCarEngine = new Engine(engineModel, enginePower, engineDisplacement, engineEfficiency);
            Car car = new Car(model, thisCarEngine, weight, color);
            cars.add(car);
        }

        cars.forEach(s -> System.out.println(s.toString()));
    }

    static class Car {
        private String model;
        private Engine engine;
        private String weight;
        private String color;

        public String getModel() {
            return model;
        }

        public Engine getEngine() {
            return engine;
        }

        public String getWeight() {
            return weight;
        }

        public String getColor() {
            return color;
        }

        @Override
        public String toString() {
            return String.format("%s:%n %s  Weight: %s%n  Color: %s", getModel(), getEngine().toString(), getWeight(), getColor());
        }

        public Car(String model, Engine engine, String weight, String color) {
            this.model = model;
            this.engine = engine;
            this.weight = weight;
            this.color = color;
        }
    }

    static class Engine {
        private String model;
        private String power;
        private String displacement;
        private String efficiency;

        public String getModel() {
            return model;
        }

        public String getPower() {
            return power;
        }

        public String getDisplacement() {
            return displacement;
        }

        public String getEfficiency() {
            return efficiency;
        }

        @Override
        public String toString() {
            return String.format(" %s:%n    Power: %s%n    Displacement: %s%n    Efficiency: %s%n", getModel(), getPower(), getDisplacement(), getEfficiency());
        }

        public Engine(String model, String power, String displacement, String efficiency) {
            this.model = model;
            this.power = power;
            this.displacement = displacement;
            this.efficiency = efficiency;
        }
    }
}
