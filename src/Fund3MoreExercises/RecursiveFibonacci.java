package Fund3MoreExercises;

import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        long[] fibonacci = new long[n];
        if (1 <= n && n <= 50){
            for (int i = 0; i < n; i++) {
                if (i ==0 || i == 1){
                    fibonacci[i] = 1;
                } else {
                    fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
                }
            }
            System.out.println(fibonacci[n -1]);
        } else {
            System.out.println(n);
        }
    }
}
