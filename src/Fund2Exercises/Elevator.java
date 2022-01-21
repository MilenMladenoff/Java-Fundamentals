package Fund2Exercises;

import java.util.Scanner;

public class Elevator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double persons = Double.parseDouble(scan.nextLine());
        int capacity = Integer.parseInt(scan.nextLine());
        double courses = Math.ceil(persons / capacity);
        System.out.printf("%.0f", courses);
    }
}
