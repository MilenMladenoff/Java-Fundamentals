package Fund2Exercises;

import java.util.Scanner;

public class SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int yield = Integer.parseInt(scan.nextLine());
        int totalExtracted = 0;
        int days = 0;
        for (int i = yield; i >= 100; i -= 10) {
            totalExtracted += i;
            totalExtracted -= 26;
            days++;
        }
        if (totalExtracted > 26) {
            totalExtracted -= 26;
        }
        System.out.println(days);
        System.out.println(totalExtracted);
    }
}
