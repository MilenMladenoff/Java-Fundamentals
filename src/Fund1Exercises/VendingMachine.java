package Fund1Exercises;

import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        double coinsSum = 0;
        while (!input.equals("Start")) {
            double coin = Double.parseDouble(input);
            if (coin == 0.1 || coin == 0.2 || coin == 0.5 || coin == 1 || coin == 2) {
                coinsSum += coin;
            } else {
                System.out.printf("Cannot accept %.2f%n", coin);
            }
            input = scan.nextLine();
        }
        String product = scan.nextLine();
        double productPrice = 0;
        while (!product.equals("End")) {
            boolean isInvalidProduct = false;
            switch (product) {
                case "Nuts":
                    productPrice = 2;
                    break;
                case "Water":
                    productPrice = 0.7;
                    break;
                case "Crisps":
                    productPrice = 1.5;
                    break;
                case "Soda":
                    productPrice = 0.8;
                    break;
                case "Coke":
                    productPrice = 1;
                    break;
                default:
                    System.out.println("Invalid product");
                    isInvalidProduct = true;
                    break;
            }
            if (!isInvalidProduct) {
                if (productPrice <= coinsSum) {
                    System.out.printf("Purchased %s%n", product);
                    coinsSum -= productPrice;
                } else {
                    System.out.println("Sorry, not enough money");
                }
            }
            product = scan.nextLine();
        }
        System.out.printf("Change: %.2f", coinsSum);
    }
}
