package Fund1MoreExercises;

import java.util.Scanner;

public class GamingStore {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double budget = Double.parseDouble(scan.nextLine());
        String game = scan.nextLine();
        double gamePrice = 0;
        double totalSpent = 0;
        while (!game.equals("Game Time")) {
            if (budget == 0) {
                System.out.println("Out of money!");
                break;
            }
            switch (game) {
                case "OutFall 4":
                case "RoverWatch Origins Edition":
                    gamePrice = 39.99;
                    break;
                case "CS: OG":
                    gamePrice = 15.99;
                    break;
                case "Zplinter Zell":
                    gamePrice = 19.99;
                    break;
                case "Honored 2":
                    gamePrice = 59.99;
                    break;
                case "RoverWatch":
                    gamePrice = 29.99;
                    break;
                default:
                    System.out.println("Not Found");
                    game = scan.nextLine();
                    continue;
            }
            if (gamePrice <= budget) {
                System.out.printf("Bought %s%n", game);
                budget -= gamePrice;
                totalSpent += gamePrice;
            } else {
                System.out.println("Too Expensive");
            }
            game = scan.nextLine();
        }
        if (budget > 0) {
            System.out.printf("Total spent: $%.2f. Remaining: $%.2f", totalSpent, budget);
        }
    }
}