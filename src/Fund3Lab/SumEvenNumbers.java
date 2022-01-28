package Fund3Lab;

import java.util.Scanner;

public class SumEvenNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String[] items = input.split(" ");
        int[] arr = new int[items.length];
        int sum = 0;
        for (int i = 0; i < items.length; i++) {
            arr[i] = Integer.parseInt(items[i]);
            if (arr[i] % 2 == 0) {
                sum += arr[i];
            }
        }
        System.out.println(sum);
    }
}
