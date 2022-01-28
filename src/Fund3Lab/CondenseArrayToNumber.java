package Fund3Lab;

import java.util.Scanner;

public class CondenseArrayToNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(" ");
        int[] numbers = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }
        for (int repetitions = 0; repetitions < numbers.length - 1; repetitions++) {
            for (int i = 0; i < numbers.length - 1; i++) {
                numbers[i] = numbers[i] + numbers[i + 1];
            }
        }
        System.out.println(numbers[0]);
    }
}
