package FinalExam05;

import java.util.Scanner;

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder activationKey = new StringBuilder(scan.nextLine());
        String inputLine = scan.nextLine();

        while (!inputLine.equals("Generate")) {
            String[] commandLine = inputLine.split(">>>");
            String command = commandLine[0];

            switch (command) {
                case "Contains":
                    String text = commandLine[1];

                    if (activationKey.toString().contains(text)) {
                        System.out.printf("%s contains %s%n", activationKey, text);
                    } else {
                        System.out.println("Substring not found!");
                    }

                    break;
                case "Flip":
                    String upperOrLower = commandLine[1];
                    int startIndex = Integer.parseInt(commandLine[2]);
                    int endIndex = Integer.parseInt(commandLine[3]);
                    String subStr = activationKey.substring(startIndex, endIndex);

                    if (upperOrLower.equals("Upper")) {
                        activationKey.replace(startIndex, endIndex, subStr.toUpperCase());
                    } else {
                        activationKey.replace(startIndex, endIndex, subStr.toLowerCase());
                    }

                    System.out.println(activationKey);
                    break;
                case "Slice":
                    startIndex = Integer.parseInt(commandLine[1]);
                    endIndex = Integer.parseInt(commandLine[2]);
                    activationKey.replace(startIndex, endIndex, "");
                    System.out.println(activationKey);
                    break;
            }

            inputLine = scan.nextLine();
        }

        System.out.printf("Your activation key is: %s", activationKey);
    }
}
