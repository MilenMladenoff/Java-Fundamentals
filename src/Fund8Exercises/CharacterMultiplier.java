package Fund8Exercises;

import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(" ");
        char[] str1 = input[0].toCharArray();
        char[] str2 = input[1].toCharArray();
        int smallerString = Math.min(str1.length, str2.length);
        int biggerString = Math.max(str1.length, str2.length);
        int sum = 0;

        for (int i = 0; i < biggerString; i++) {

            if (i < smallerString) {
                sum += str1[i] * str2[i];
            } else if (str1.length > str2.length) {
                sum += str1[i];
            } else {
                sum += str2[i];
            }
        }

        System.out.println(sum);
    }
}
