package Fund1Lab;

import java.util.Scanner;

public class MultiplicationTable2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());
        int multiplier = Integer.parseInt(scan.nextLine());
        int product = 0;
        if (multiplier > 10){
            System.out.printf("%d X %d = %d%n", number, multiplier, number * multiplier);
        } else {
            for (int i = multiplier; i <= 10; i++){
                product = number * i;
                System.out.printf("%d X %d = %d%n", number, i, product);
            }
        }
    }
}
