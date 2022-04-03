package FinalExam03042022;

import java.util.Scanner;

public class DecryptingCommands {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        String[] commandLine = scan.nextLine().split("\\s+");

        while (!commandLine[0].equals("Finish")) {
            String command = commandLine[0];

            switch (command) {
                case "Replace":
                    String currentChar = commandLine[1];
                    String newChar = commandLine[2];
                    int indexOfCurrentChar = text.indexOf(currentChar);

                    while (indexOfCurrentChar != -1) {
                        text = text.replace(currentChar, newChar);
                        indexOfCurrentChar = text.indexOf(currentChar);
                    }

                    System.out.println(text);
                    break;
                case "Cut":
                    int startIndex = Integer.parseInt(commandLine[1]);
                    int endIndex = Integer.parseInt(commandLine[2]);

                    if (0 > startIndex || 0 > endIndex || startIndex > text.length() - 1 || endIndex > text.length() - 1 || startIndex > endIndex) {
                        System.out.println("Invalid indices!");
                    } else {
                        String textToRemove = text.substring(startIndex, endIndex + 1);
                        int indexOfTextToRemove = text.indexOf(textToRemove);

                        while (indexOfTextToRemove != -1) {
                            text = text.replace(textToRemove, "");
                            indexOfTextToRemove = text.indexOf(textToRemove);
                        }

                        System.out.println(text);
                    }

                    break;
                case "Make":
                    String upperOrLower = commandLine[1];

                    if (upperOrLower.equals("Upper")) {
                        text = text.toUpperCase();
                    } else {
                        text = text.toLowerCase();
                    }

                    System.out.println(text);
                    break;
                case "Check":
                    String check = commandLine[1];

                    if (text.contains(check)) {
                        System.out.printf("Message contains %s%n", check);
                    } else {
                        System.out.printf("Message doesn't contain %s%n", check);
                    }

                    break;
                case "Sum":
                    startIndex = Integer.parseInt(commandLine[1]);
                    endIndex = Integer.parseInt(commandLine[2]);

                    if (0 > startIndex || 0 > endIndex || startIndex > text.length() - 1 || endIndex > text.length() - 1 || startIndex > endIndex) {
                        System.out.println("Invalid indices!");
                    } else {
                        String textForAsciiSum = text.substring(startIndex, endIndex + 1);
                        int asciiSum = 0;

                        for (int i = 0; i < textForAsciiSum.length(); i++) {
                            int asciiValue = textForAsciiSum.charAt(i);
                            asciiSum += asciiValue;
                        }

                        System.out.println(asciiSum);
                    }
                    break;
            }

            commandLine = scan.nextLine().split("\\s+");
        }
    }
}
