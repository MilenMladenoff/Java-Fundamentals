package Fund9MoreExercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SantasSecretHelper {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int key = Integer.parseInt(scan.nextLine());
        String inputMessage = scan.nextLine();

        while (!inputMessage.equals("end")) {
            StringBuilder decryptedMessage = new StringBuilder();

            for (int i = 0; i < inputMessage.length(); i++) {
                char symbol = (char) (inputMessage.charAt(i) - key);
                decryptedMessage.append(symbol);
            }

            String regex = "@(?<name>[A-Za-z]+)[^-@!:>]+!(?<behavior>[GN])!";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(decryptedMessage);

            if (matcher.find()) {
                String childName = matcher.group("name");
                String childBehavior = matcher.group("behavior");

                if (childBehavior.equals("G")) {
                    System.out.println(childName);
                }
            }

            inputMessage = scan.nextLine();
        }
    }
}
