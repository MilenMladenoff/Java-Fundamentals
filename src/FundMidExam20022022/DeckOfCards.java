package FundMidExam20022022;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DeckOfCards {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> deck = Arrays.stream(scan.nextLine().split(", ")).collect(Collectors.toList());
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            List<String> command = Arrays.stream(scan.nextLine().split(", ")).collect(Collectors.toList());
            String action = command.get(0);

            switch (action) {
                case "Add":

                    if (deck.contains(command.get(1))) {
                        System.out.println("Card is already in the deck");
                    } else {
                        deck.add(command.get(1));
                        System.out.println("Card successfully added");
                    }

                    break;
                case "Remove":

                    if (deck.contains(command.get(1))) {
                        deck.remove(command.get(1));
                        System.out.println("Card successfully removed");
                    } else {
                        System.out.println("Card not found");
                    }

                    break;
                case "Remove At":
                    int index = Integer.parseInt(command.get(1));

                    if (index >= 0 && deck.size() > index) {
                        deck.remove(index);
                        System.out.println("Card successfully removed");
                    } else {
                        System.out.println("Index out of range");
                    }

                    break;
                case "Insert":
                    index = Integer.parseInt(command.get(1));

                    if (index < 0 || deck.size() <= index) {
                        System.out.println("Index out of range");
                    } else {

                        if (deck.contains(command.get(2))) {
                            System.out.println("Card is already added");
                        } else {
                            deck.add(index, command.get(2));
                            System.out.println("Card successfully added");
                        }
                    }

                    break;
            }
        }

        System.out.println(deck.toString().replaceAll("[\\[\\]]", ""));
    }
}
