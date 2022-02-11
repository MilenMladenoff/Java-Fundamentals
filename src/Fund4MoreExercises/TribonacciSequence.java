package Fund4MoreExercises;

import java.util.Scanner;

public class TribonacciSequence {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        if (n < 3) {
            for (int i = 0; i < n; i++) {
                System.out.print("1 ");
            }
        } else {
            for (int number : createTribonacciArr(n)) {
                System.out.print(number + " ");
            }
        }
    }

    private static int[] createTribonacciArr(int n) {
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 2;

        for (int i = 3; i < n; i++) {
            arr[i] = arr[i - 3] + arr[i - 2] + arr[i - 1];
        }

        return arr;
    }
}
