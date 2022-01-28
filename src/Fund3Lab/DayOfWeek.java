package Fund3Lab;

import java.util.Scanner;

public class DayOfWeek {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] weekDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int day = Integer.parseInt(scan.nextLine());
        if (day >= 1 && 7 >= day) {
            System.out.println(weekDays[day - 1]);
        } else {
            System.out.println("Invalid day!");
        }
    }
}
