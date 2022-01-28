package Fund3Lab;

import java.util.Scanner;

public class EvenAndOddSubtraction {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] elements = scan.nextLine().split(" ");
        int[] arr = new int[elements.length];
        for (int i = 0; i < elements.length; i++) {
            arr[i] = Integer.parseInt(elements[i]);
        }
        int evenSum = 0;
        int oddSum = 0;
        for (int number : arr) {
            if (number % 2 == 0) {
                evenSum += number;
            } else {
                oddSum += number;
            }
        }
        System.out.println(evenSum - oddSum);
    }
}
