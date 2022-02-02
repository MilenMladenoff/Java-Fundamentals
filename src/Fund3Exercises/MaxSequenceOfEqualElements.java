package Fund3Exercises;

import java.util.Scanner;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] arr = scan.nextLine().split(" ");
        int[] numbers = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            numbers[i] = Integer.parseInt(arr[i]);
        }
        int maxSequence = 0;
        int maxSequenceNumber = 0;
        int equalsCounter = 0;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i - 1] == numbers[i]) {
                equalsCounter++;
            } else {
                equalsCounter = 0;
            }
            if (equalsCounter > maxSequence) {
                maxSequence = equalsCounter;
                maxSequenceNumber = numbers[i];
            }
        }
        for (int i = 0; i <= maxSequence; i++) {
            System.out.printf("%d ", maxSequenceNumber);
        }
    }
}
