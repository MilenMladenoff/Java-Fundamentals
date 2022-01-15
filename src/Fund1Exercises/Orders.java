package Fund1Exercises;

import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int orders = Integer.parseInt(scan.nextLine());
        double totalSum = 0;
        for (int i = 1; i <= orders; i++){
            double pricePerCapsule = Double.parseDouble(scan.nextLine());
            int days = Integer.parseInt(scan.nextLine());
            int capsules = Integer.parseInt(scan.nextLine());
            double orderCost = pricePerCapsule * days * capsules;
            System.out.printf("The price for the coffee is: $%.2f%n", orderCost);
            totalSum += orderCost;
        }
        System.out.printf("Total: $%.2f", totalSum);
    }
}
