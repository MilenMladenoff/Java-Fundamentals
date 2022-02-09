package Fund4Exercises;

import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String password = scan.nextLine();

         if (hasBetween6And10Chars(password) && consistOnlyLettersAndDigits(password) && hasAtLeast2Digits(password)){
             System.out.println("Password is valid");
         }

         if (!hasBetween6And10Chars(password)){
             System.out.println("Password must be between 6 and 10 characters");
         }

         if (!consistOnlyLettersAndDigits(password)){
             System.out.println("Password must consist only of letters and digits");
         }

         if (!hasAtLeast2Digits(password)){
             System.out.println("Password must have at least 2 digits");
         }
    }

    private static boolean hasAtLeast2Digits(String password) {
        int digitsCounter = 0;

        for (int i = 0; i < password.length(); i++){
            char symbol = password.charAt(i);
            if (symbol >= 48 && 57 >= symbol){
                digitsCounter++;
                if (digitsCounter >= 2){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean consistOnlyLettersAndDigits(String password) {

        for (int i = 0; i < password.length(); i++){
            char symbol = password.toLowerCase().charAt(i);
            if ((symbol >= 48 && 57 >= symbol) || (symbol >= 97 && 122 >= symbol)){
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    private static boolean hasBetween6And10Chars(String password) {
        return 6 <= password.length() && password.length() <= 10;
    }
}
