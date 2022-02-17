package Fund5Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonDoNotGo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> sequence = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int removedElementsSum = 0;

        while (!sequence.isEmpty()) {
            int index = Integer.parseInt(scan.nextLine());
            int element = 0;

            if (index < 0) {
                element = sequence.get(0);
                sequence.remove(0);
                sequence.add(0, sequence.get(sequence.size() - 1));
                increaseOrDecreaseElements(sequence, element);
            } else if (index >= sequence.size()) {
                element = sequence.get(sequence.size() - 1);
                sequence.remove(sequence.size() - 1);
                sequence.add(sequence.get(0));
                increaseOrDecreaseElements(sequence, element);
            } else {
                element = sequence.get(index);
                sequence.remove(index);
                increaseOrDecreaseElements(sequence, element);
            }

            removedElementsSum += element;
        }

        System.out.println(removedElementsSum);
    }

    private static void increaseOrDecreaseElements(List<Integer> sequence, int element) {

        for (int i = 0; i < sequence.size(); i++) {

            if (sequence.get(i) <= element) {
                sequence.set(i, sequence.get(i) + element);
            } else {
                sequence.set(i, sequence.get(i) - element);
            }
        }
    }
}
