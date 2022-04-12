package FinalExamPrep2;

import java.util.Scanner;

public class SecretChat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder message = new StringBuilder(scan.nextLine());
        String commandLine = scan.nextLine();

        while (!commandLine.equals("Reveal")) {
            String[] command = commandLine.split(":\\|:");

            switch (command[0]) {
                case "InsertSpace":
                    message.insert(Integer.parseInt(command[1]), " ");
                    break;
                case "Reverse":
                    StringBuilder substring = new StringBuilder(command[1]);

                    if (message.toString().contains(substring)) {
                        int startIndex = message.indexOf(substring.toString());
                        int endIndex = startIndex + substring.length();
                        message.delete(startIndex, endIndex);
                        substring.reverse();
                        message.append(substring);
                    } else {
                        System.out.println("error");
                        commandLine = scan.nextLine();
                        continue;
                    }

                    break;
                case "ChangeAll":
                    String changedOccurrences = message.toString().replaceAll(command[1], command[2]);
                    message.setLength(0);
                    message.append(changedOccurrences);
                    break;
            }

            System.out.println(message);
            commandLine = scan.nextLine();
        }

        System.out.printf("You have a new text message: %s", message);
    }
}
