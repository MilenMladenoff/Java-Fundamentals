package FinalExam02;

import java.util.Scanner;

public class WorldTour {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder tour = new StringBuilder(scan.nextLine());
        String[] commandLine = scan.nextLine().split(":");

        while (!commandLine[0].equals("Travel")) {
            String command = commandLine[0];

            switch (command) {
                case "Add Stop":
                    int index = Integer.parseInt(commandLine[1]);
                    String placeToInsert = commandLine[2];

                    if (indexIsValid(tour, index)) {
                        tour.insert(index, placeToInsert);
                    }

                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(commandLine[1]);
                    int endIndex = Integer.parseInt(commandLine[2]);

                    if (indexIsValid(tour, startIndex) && indexIsValid(tour, endIndex)) {
                        tour.replace(startIndex, endIndex + 1, "");
                    }

                    break;
                case "Switch":
                    String oldStr = commandLine[1];
                    String newStr = commandLine[2];

                    if (tour.toString().contains(oldStr)) {
                        startIndex = tour.indexOf(oldStr);
                        endIndex = startIndex + oldStr.length();
                        tour.replace(startIndex, endIndex, newStr);
                    }

                    break;
            }
            System.out.println(tour);
            commandLine = scan.nextLine().split(":");
        }

        System.out.printf("Ready for world tour! Planned stops: %s", tour);
    }

    private static boolean indexIsValid(StringBuilder tour, int index) {
        return index >= 0 && tour.length() > index;
    }
}
