package Fund1Lab;

import java.util.Scanner;

public class TheatrePromotion {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String dayType = scan.nextLine();
        int age = Integer.parseInt(scan.nextLine());
        switch (dayType){
            case "Weekday":
                if (0 <= age && age <= 18){
                    System.out.println("12$");
                    break;
                } else if (18 < age && age <= 64){
                    System.out.println("18$");
                    break;
                } else if (64 < age && age <= 122){
                    System.out.println("12$");
                    break;
                } else {
                    System.out.println("Error!");
                    break;
                }
            case "Weekend":
                if (0 <= age && age <= 18){
                    System.out.println("15$");
                    break;
                } else if (18 < age && age <= 64){
                    System.out.println("20$");
                    break;
                } else if (64 < age && age <= 122){
                    System.out.println("15$");
                    break;
                } else {
                    System.out.println("Error!");
                    break;
                }
            case "Holiday":
                if (0 <= age && age <= 18){
                    System.out.println("5$");
                    break;
                } else if (18 < age && age <= 64){
                    System.out.println("12$");
                    break;
                } else if (64 < age && age <= 122){
                    System.out.println("10$");
                    break;
                } else {
                    System.out.println("Error!");
                    break;
                }
        }
    }
}
