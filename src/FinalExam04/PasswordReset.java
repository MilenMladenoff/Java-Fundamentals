package FinalExam04;

import java.util.Scanner;

public class PasswordReset {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder password = new StringBuilder(scan.nextLine());
        String[] commandLine = scan.nextLine().split(" ");

        while (!commandLine[0].equals("Done")) {
            String command = commandLine[0];

            switch (command) {
                case "TakeOdd":
                    StringBuilder oddsChars = new StringBuilder();

                    for (int i = 0; i < password.length(); i++) {

                        if (i % 2 != 0) {
                            oddsChars.append(password.charAt(i));
                        }
                    }

                    password.setLength(0);
                    password.append(oddsChars);
                    break;
                case "Cut":
                    int index = Integer.parseInt(commandLine[1]);
                    int length = Integer.parseInt(commandLine[2]);
                    password.replace(index, index + length, "");
                    break;
                case "Substitute":
                    String existingStr = commandLine[1];
                    String substituteStr = commandLine[2];

                    if (!password.toString().contains(existingStr)) {
                        System.out.println("Nothing to replace!");
                        commandLine = scan.nextLine().split(" ");
                        continue;
                    } else {

                        while (password.toString().contains(existingStr)) {
                            int startIndex = password.indexOf(existingStr);
                            password.replace(startIndex, startIndex + existingStr.length(), substituteStr);
                        }
                    }
            }

            System.out.println(password);
            commandLine = scan.nextLine().split(" ");
        }

        System.out.printf("Your password is: %s", password);
    }
}
