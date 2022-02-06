package Fund4Lab;

import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String product = scan.nextLine();
        int quantity = Integer.parseInt(scan.nextLine());
        double singlePrice = 0;

        switch (product) {
            case "coffee":
                singlePrice = 1.50;
                break;
            case "water":
                singlePrice = 1.00;
                break;
            case "coke":
                singlePrice = 1.40;
                break;
            case "snack":
                singlePrice = 2.00;
                break;
        }

        double totalPrice = singlePrice * quantity;
        System.out.printf("%.2f", totalPrice);
    }
}
