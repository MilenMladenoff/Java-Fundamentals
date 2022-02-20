package FundExams01Mid;

import java.util.Scanner;

public class ComputerStore {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        double priceWithoutTaxes = 0;

        while (!input.equals("special") && !input.equals("regular")){
            double partPrice = Double.parseDouble(input);

            if (partPrice < 0){
                System.out.println("Invalid price!");
            } else {
                priceWithoutTaxes += partPrice;
            }

            input = scan.nextLine();
        }

        if (priceWithoutTaxes == 0){
            System.out.println("Invalid order!");
        } else {
            double taxes = priceWithoutTaxes * 1.2 - priceWithoutTaxes;
            double totalPrice = priceWithoutTaxes + taxes;

            if (input.equals("special")){
                totalPrice *= 0.9;
            }

            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$%n", priceWithoutTaxes);
            System.out.printf("Taxes: %.2f$%n", taxes);
            System.out.println("-----------");
            System.out.printf("Total price: %.2f$", totalPrice);
        }
    }
}
