package Fund3Exercises;

import java.util.Scanner;

public class TopIntegers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] arr = scan.nextLine().split(" ");
        int[] numbers = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            numbers[i] = Integer.parseInt(arr[i]);
        }
        for (int i = 0; i < numbers.length; i++) {
            boolean isTop = true;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] <= numbers[j]) {
                    isTop = false;
                    break;
                }
            }
            if (isTop) {
                System.out.printf("%d ", numbers[i]);
            }
        }
    }
}
