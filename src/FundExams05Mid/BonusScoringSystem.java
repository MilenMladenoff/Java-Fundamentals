package FundExams05Mid;

import java.util.Scanner;

public class BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int students = Integer.parseInt(scan.nextLine());
        int lectures = Integer.parseInt(scan.nextLine());
        int additionalBonus = Integer.parseInt(scan.nextLine());
        double maxStudentAttendance = 0;

        for (int i = 1; i <= students; i++){
            int studentAttendance = Integer.parseInt(scan.nextLine());

            if (studentAttendance > maxStudentAttendance){
                maxStudentAttendance = studentAttendance;
            }
        }

        double maxBonus = maxStudentAttendance / lectures * (5 + additionalBonus);

        if (students == 0){
            System.out.println("Max Bonus: 0.");
        } else {
            System.out.printf("Max Bonus: %.0f.%n", Math.ceil(maxBonus));
        }

        System.out.printf("The student has attended %.0f lectures.", maxStudentAttendance);

    }
}
