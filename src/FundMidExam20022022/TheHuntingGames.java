package FundMidExam20022022;

import java.util.Scanner;

public class TheHuntingGames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int days = Integer.parseInt(scan.nextLine());
        int players = Integer.parseInt(scan.nextLine());
        double energy = Double.parseDouble(scan.nextLine());
        double waterPerDay = Double.parseDouble(scan.nextLine());
        double foodPerDay = Double.parseDouble(scan.nextLine());
        double totalWater = waterPerDay * days * players;
        double totalFood = foodPerDay * days * players;

        for (int i = 1; i <= days; i++) {
            double energyLost = Double.parseDouble(scan.nextLine());
            energy -= energyLost;

            if (energy <= 0) {
                break;
            }

            if (i % 2 == 0) {
                energy *= 1.05;
                totalWater *= 0.7;
            }

            if (i % 3 == 0) {
                energy *= 1.1;
                totalFood -= totalFood / players;
            }
        }

        if (energy > 0) {
            System.out.printf("You are ready for the quest. You will be left with - %.2f energy!", energy);
        } else {
            System.out.printf("You will run out of energy. You will be left with %.2f food and %.2f water.", totalFood, totalWater);
        }
    }
}
