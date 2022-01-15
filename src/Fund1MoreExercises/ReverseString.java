package Fund1MoreExercises;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        for (int i = input.length() - 1; i >= 0; i--) {
            char symbol = input.charAt(i);
            System.out.print(symbol);
        }
    }
}
