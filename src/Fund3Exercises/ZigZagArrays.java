package Fund3Exercises;

import java.util.Scanner;

public class ZigZagArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String[] firstArr = new String[n];
        String[] secondArr = new String[n];
        for (int i = 0; i < n; i++) {
            String[] line = scan.nextLine().split(" ");
            if (i % 2 == 0) {
                firstArr[i] = line[0];
                secondArr[i] = line[1];
            } else {
                firstArr[i] = line[1];
                secondArr[i] = line[0];
            }
        }
        System.out.println(String.join(" ", firstArr));
        System.out.println(String.join(" ", secondArr));
    }
}
