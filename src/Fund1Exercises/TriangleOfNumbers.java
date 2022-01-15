package Fund1Exercises;

import java.util.Scanner;

public class TriangleOfNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        for (int column = 1; column <= n; column++){
            for (int row = 1; row <= column; row++){
                System.out.printf("%d ", column);
            }
            System.out.println();
        }
    }
}
