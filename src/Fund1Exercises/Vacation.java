package Fund1Exercises;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int people = Integer.parseInt(scan.nextLine());
        String groupType = scan.nextLine();
        String day = scan.nextLine();
        double singleDailyPrice = 0;
        switch (groupType) {
            case "Students":
                if (day.equals("Friday")) {
                    singleDailyPrice = 8.45;
                } else if (day.equals("Saturday")) {
                    singleDailyPrice = 9.8;
                } else {
                    singleDailyPrice = 10.46;
                }
                break;
            case "Business":
                if (day.equals("Friday")) {
                    singleDailyPrice = 10.9;
                } else if (day.equals("Saturday")) {
                    singleDailyPrice = 15.6;
                } else {
                    singleDailyPrice = 16;
                }
                break;
            case "Regular":
                if (day.equals("Friday")) {
                    singleDailyPrice = 15;
                } else if (day.equals("Saturday")) {
                    singleDailyPrice = 20;
                } else {
                    singleDailyPrice = 22.5;
                }
                break;
        }
        double totalPrice = people * singleDailyPrice;
        if (people >= 30 && groupType.equals("Students")) {
            totalPrice = totalPrice * 0.85;
        }
        if (people >= 100 && groupType.equals("Business")) {
            totalPrice = totalPrice - singleDailyPrice * 10;
        }
        if (10 <= people && people <= 20 && groupType.equals("Regular")) {
            totalPrice = totalPrice * 0.95;
        }
        System.out.printf("Total price: %.2f", totalPrice);

    }
}
