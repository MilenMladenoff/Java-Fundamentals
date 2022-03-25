package Fund8Exercises;

import java.util.Scanner;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] usernames = scan.nextLine().split(", ");

        for (String username : usernames) {
            boolean isValid = true;

            if (3 > username.length() || username.length() > 16) {
                isValid = false;
            }

            for (int i = 0; i < username.length(); i++) {
                char symbol = username.toLowerCase().charAt(i);

                if (!(Character.isLetter(symbol) || Character.isDigit(symbol) || symbol == 45 || symbol == 95)) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                System.out.println(username);
            }
        }
    }
}
