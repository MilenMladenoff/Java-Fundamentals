package Fund8MoreExercises;

import java.util.Arrays;
import java.util.Scanner;

public class TreasureFinder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] key = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String inputLine = scan.nextLine();

        while (!inputLine.equals("find")) {
            int keyIndexCounter = 0;
            StringBuilder decryptedLine = new StringBuilder();

            for (int i = 0; i < inputLine.length(); i++) {
                char symbol = (char) (inputLine.charAt(i) - key[keyIndexCounter]);
                decryptedLine.append(symbol);
                keyIndexCounter++;

                if (keyIndexCounter == key.length) {
                    keyIndexCounter = 0;
                }
            }

            String treasureType = "";
            String coordinates = "";

            for (int i = 0; i < decryptedLine.length(); i++) {
                String decryptedString = decryptedLine.toString();
                treasureType = decryptedString.substring(decryptedString.indexOf('&') + 1, decryptedString.lastIndexOf('&'));
                coordinates = decryptedString.substring(decryptedString.indexOf('<') + 1, decryptedString.indexOf('>'));
            }

            System.out.printf("Found %s at %s%n", treasureType, coordinates);
            inputLine = scan.nextLine();
        }

    }
}
