package FundExams01Mid;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MemoryGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> sequence = Arrays.stream(scan.nextLine().split("\\s+")).collect(Collectors.toList());
        String move = scan.nextLine();
        int moveCounter = 0;


        while (!move.equals("end")) {
            List<Integer> indices = Arrays.stream(move.split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
            moveCounter++;
            int index1 = indices.get(0);
            int index2 = indices.get(1);

            if (index1 == index2 || index1 < 0 || sequence.size() <= index1 || index2 < 0 || sequence.size() <= index2) {
                sequence.add(sequence.size() / 2, "-" + moveCounter + "a");
                sequence.add(sequence.size() / 2, "-" + moveCounter + "a");
                System.out.println("Invalid input! Adding additional elements to the board");
            } else {

                if (sequence.get(index1).equals(sequence.get(index2))) {
                    String matchingElement = sequence.get(index1);
                    System.out.printf("Congrats! You have found matching elements - %s!%n", sequence.get(index1));
                    sequence.remove(matchingElement);
                    sequence.remove(matchingElement);
                } else {
                    System.out.println("Try again!");
                }
            }

            if (sequence.isEmpty()) {
                System.out.printf("You have won in %d turns!%n", moveCounter);
                break;
            }

            move = scan.nextLine();
        }

        if (!sequence.isEmpty()) {
            System.out.println("Sorry you lose :(");

            for (String item : sequence) {
                System.out.print(item + " ");
            }
        }
    }
}
