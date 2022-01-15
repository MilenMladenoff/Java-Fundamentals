package Fund1Exercises;

import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String username = scan.nextLine();
        String password = "";
        for (int i = username.length() - 1; i >= 0; i--){
            char symbol = username.charAt(i);
            password += symbol;
        }
        String input = scan.nextLine();
        int tryCounter = 0;
        while (!input.equals(password)){
            tryCounter++;
            if (tryCounter == 4){
                System.out.printf("User %s blocked!%n", username);
                break;
            }
            System.out.println("Incorrect password. Try again.");
            input = scan.nextLine();
        }
        if (input.equals(password)){
            System.out.printf("User %s logged in.%n", username);
        }
    }
}
