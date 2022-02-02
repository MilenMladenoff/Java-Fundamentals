package Fund3MoreExercises;

import java.util.Arrays;
import java.util.Scanner;

public class EncryptSortAndPrintArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            int sum = 0;
            for (int j = 0; j < input.length(); j++) {
                char letter = input.charAt(j);
                switch (letter) {
                    case 'A':
                    case 'a':
                    case 'E':
                    case 'e':
                    case 'I':
                    case 'i':
                    case 'O':
                    case 'o':
                    case 'U':
                    case 'u':
                        sum += letter * input.length();
                        break;
                    default:
                        sum += letter / input.length();
                        break;
                }
            }
            numbers[i] = sum;
        }
        Arrays.sort(numbers);
        for (int result : numbers) {
            System.out.println(result);
        }
    }
}
