package Fund2MoreExercises;

import java.util.Scanner;

public class FromLeftToTheRight {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 1; i <= n; i++) {
            double n1 = Double.parseDouble(scan.next());
            double n2 = Double.parseDouble(scan.next());
            int digitsSum = 0;
            if (n1 > n2) {
                double biggerNum = Math.abs(n1);
                while (biggerNum > 0) {
                    digitsSum += biggerNum % 10;
                    biggerNum /= 10;
                }
            } else {
                double biggerNum = Math.abs(n2);
                while (biggerNum > 0) {
                    digitsSum += biggerNum % 10;
                    biggerNum /= 10;
                }
            }
            System.out.println(digitsSum);
        }
    }
}