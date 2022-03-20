package Fund8Lab;

import java.util.Scanner;

public class ReverseStrings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String inputLine = scan.nextLine();

        while (!inputLine.equals("end")) {
            String reversedString = "";

            for (int i = inputLine.length() - 1; i >= 0; i--) {
                reversedString += inputLine.charAt(i);
            }

            System.out.printf("%s = %s%n", inputLine, reversedString);

            inputLine = scan.nextLine();
        }
    }
}
