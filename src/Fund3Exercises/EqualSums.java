package Fund3Exercises;

import java.util.Scanner;

public class EqualSums {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] arr = scan.nextLine().split(" ");
        int[] numbers = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            numbers[i] = Integer.parseInt(arr[i]);
        }
        boolean exists = false;
        for (int i = 0; i < numbers.length; i++) {
            int leftSum = 0;
            int rightSum = 0;
            for (int j = 0; j < i; j++) {
                leftSum += numbers[j];
            }
            for (int k = i + 1; k < numbers.length; k++) {
                rightSum += numbers[k];
            }
            if (leftSum == rightSum) {
                System.out.println(i);
                exists = true;
            }
        }
        if (!exists) {
            System.out.println("no");
        }
    }
}
