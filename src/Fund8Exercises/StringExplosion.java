package Fund8Exercises;

import java.util.Scanner;

public class StringExplosion {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder result = new StringBuilder(scan.nextLine());
        int strength = 0;

        for (int i = 0; i < result.length(); i++) {

            if (strength > 0 && result.charAt(i) != '>') {
                result.deleteCharAt(i);
                strength--;
                i--;
            } else if (result.charAt(i) == '>') {
                strength += Integer.parseInt(String.valueOf(result.charAt(i + 1)));
            }
        }

        System.out.println(result);
    }
}
