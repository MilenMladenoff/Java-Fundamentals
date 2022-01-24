package Fund2MoreExercises;

import java.util.Scanner;

public class DecryptingMessage {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int key = Integer.parseInt(scan.nextLine());
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 1; i <= n; i++) {
            char letter = scan.nextLine().charAt(0);
            int letterCode = letter + key;
            char decryptedLetter = (char) letterCode;
            System.out.print(decryptedLetter);
        }


    }
}
