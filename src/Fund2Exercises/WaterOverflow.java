package Fund2Exercises;

import java.util.Scanner;

public class WaterOverflow {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int tankFill = 0;
        for (int i = 1; i <= n; i++) {
            int load = Integer.parseInt(scan.nextLine());
            if (tankFill + load <= 255) {
                tankFill += load;
            } else {
                System.out.println("Insufficient capacity!");
            }
        }
        System.out.println(tankFill);
    }
}
