package FinalExam02;

import java.util.*;

public class PlantDiscovery {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, Plant> plants = new LinkedHashMap<>();

        for (int i = 1; i <= n; i++) {
            String[] inputPlant = scan.nextLine().split("<->");
            String plantName = inputPlant[0];
            int rarity = Integer.parseInt(inputPlant[1]);

            if (plants.containsKey(plantName)) {
                plants.get(plantName).setRarity(rarity);
            } else {
                Plant plant = new Plant(plantName, rarity, new ArrayList<>());
                plants.put(plantName, plant);
            }
        }

        String inputCommand = scan.nextLine();

        while (!inputCommand.equals("Exhibition")) {
            String[] commandLine = inputCommand.split("(: )|( - )");
            String plantName = commandLine[1];

            if (!plants.containsKey(plantName)) {
                System.out.println("error");
            } else {
                String command = commandLine[0];

                switch (command) {
                    case "Rate":
                        double rating = Double.parseDouble(commandLine[2]);
                        Plant plant = plants.get(plantName);
                        List<Double> ratings = plant.getRatings();
                        ratings.add(rating);
                        break;
                    case "Update":
                        int newRarity = Integer.parseInt(commandLine[2]);
                        plants.get(plantName).setRarity(newRarity);
                        break;
                    case "Reset":
                        plant = plants.get(plantName);
                        List<Double> removedRatings = plant.getRatings();
                        removedRatings.clear();
                        break;
                }
            }

            inputCommand = scan.nextLine();
        }

        System.out.println("Plants for the exhibition:");
        plants.forEach((k, v) -> System.out.println(v.toString()));
    }

    private static class Plant {
        String plantName;
        int rarity;
        List<Double> ratings;

        public Plant(String plantName, int rarity, List<Double> ratings) {
            this.plantName = plantName;
            this.rarity = rarity;
            this.ratings = new ArrayList<>();
        }

        public void setRarity(int rarity) {
            this.rarity = rarity;
        }

        public List<Double> getRatings() {
            return ratings;
        }

        @Override
        public String toString() {
            return String.format("- %s; Rarity: %d; Rating: %.2f", this.plantName, this.rarity, getAverageRating(this.ratings));
        }

        private Double getAverageRating(List<Double> ratings) {
            double ratingsSum = 0;

            if (ratings.isEmpty()) {
                return 0.0;
            } else {

                for (Double rating : ratings) {
                    ratingsSum += rating;
                }

                return ratingsSum / ratings.size();
            }
        }
    }
}
