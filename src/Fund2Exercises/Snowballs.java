package Fund2Exercises;

import java.util.Scanner;

public class Snowballs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int maxSnowballSnow = 0;
        int maxSnowballTime = 0;
        int maxSnowballQuality = 0;
        double maxSnowballValue = 0;
        for (int i = 1; i <= n; i++) {
            int snowballSnow = Integer.parseInt(scan.nextLine());
            int snowballTime = Integer.parseInt(scan.nextLine());
            int snowballQuality = Integer.parseInt(scan.nextLine());
            double snowballValue = Math.pow((snowballSnow / snowballTime), snowballQuality);
            if (snowballValue > maxSnowballValue) {
                maxSnowballSnow = snowballSnow;
                maxSnowballTime = snowballTime;
                maxSnowballQuality = snowballQuality;
                maxSnowballValue = snowballValue;
            }
        }
        System.out.printf("%d : %d = %.0f (%d)", maxSnowballSnow, maxSnowballTime, maxSnowballValue, maxSnowballQuality);
    }
}
