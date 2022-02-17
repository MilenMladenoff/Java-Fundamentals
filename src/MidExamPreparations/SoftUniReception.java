package MidExamPreparations;

import java.util.Scanner;

public class SoftUniReception {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int employee1 = Integer.parseInt(scan.nextLine());
        int employee2 = Integer.parseInt(scan.nextLine());
        int employee3 = Integer.parseInt(scan.nextLine());
        int studentsPerHour = employee1 + employee2 + employee3;
        int students = Integer.parseInt(scan.nextLine());
        int hoursCounter = 0;

        while (students > 0) {
            hoursCounter++;

            if (hoursCounter % 4 != 0) {
                students -= studentsPerHour;
            }
        }

        System.out.printf("Time needed: %dh.", hoursCounter);
    }
}
