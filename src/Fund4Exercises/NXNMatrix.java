package Fund4Exercises;

import java.util.Scanner;

public class NXNMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        printNXNmatrix(n);
    }

    private static void printNXNmatrix(int n) {
        for (int rows = 1; rows <= n; rows++){
            for (int cols = 1; cols <= n; cols++) {
                System.out.printf("%d ", n);
            }
            System.out.println();
        }
    }
}
