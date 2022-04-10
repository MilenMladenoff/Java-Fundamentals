package FinalExamPrep1;

import java.util.Scanner;

public class TheImitationGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder message = new StringBuilder(scan.nextLine());
        String[] commandLine = scan.nextLine().split("\\|");
        String command = commandLine[0];

        while (!command.equals("Decode")) {

            switch (command) {
                case "Move":
                    int charsToMoveCount = Integer.parseInt(commandLine[1]);
                    String textToMove = message.substring(0, charsToMoveCount);
                    message.delete(0, charsToMoveCount);
                    message.append(textToMove);
                    break;
                case "Insert":
                    int index = Integer.parseInt(commandLine[1]);
                    String value = commandLine[2];
                    message.insert(index, value);
                    break;
                case "ChangeAll":
                    String textToReplace = commandLine[1];
                    String replacement = commandLine[2];

                    while ((message.toString()).contains(textToReplace)) {
                        int startIndex = message.indexOf(textToReplace);
                        message.replace(startIndex, startIndex + textToReplace.length(), replacement);
                    }

                    break;
            }

            commandLine = scan.nextLine().split("\\|");
            command = commandLine[0];
        }

        System.out.printf("The decrypted message is: %s", message);

    }
}
