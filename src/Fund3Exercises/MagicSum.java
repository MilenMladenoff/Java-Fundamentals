package Fund3Exercises;

import java.util.Scanner;

public class MagicSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(" ");
        int[] arr = new int[input.length];
        for (int i = 0; i < input.length; i++){
            arr[i] = Integer.parseInt(input[i]);
        }
        int number = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == number) {
                    System.out.printf("%d %d%n", arr[i], arr[j]);
                }
            }
        }
    }
}
