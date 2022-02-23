package FundExams06Mid;

import java.util.Scanner;

public class BlackFlag {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int days = Integer.parseInt(scan.nextLine());
        double dailyPlunder = Double.parseDouble(scan.nextLine());
        double target = Double.parseDouble(scan.nextLine());
        double totalGain = 0;

        for (int i = 1; i <= days; i++) {
            totalGain += dailyPlunder;

            if (i % 3 == 0) {
                totalGain += dailyPlunder / 2;
            }

            if (i % 5 == 0) {
                totalGain *= 0.7;
            }
        }

        if (totalGain >= target) {
            System.out.printf("Ahoy! %.2f plunder gained.", totalGain);
        } else {
            System.out.printf("Collected only %.2f%% of the plunder.", totalGain * 100 / target);
        }
    }
}
