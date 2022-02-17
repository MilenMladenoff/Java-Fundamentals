package Fund5Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<String> bombLine = Arrays.stream(scan.nextLine().split(" ")).collect(Collectors.toList());
        int bombNum = Integer.parseInt(bombLine.get(0));
        int bombPower = Integer.parseInt(bombLine.get(1));

        while (numbers.contains(bombNum)){
            int bombIndex = numbers.indexOf(bombNum);
            int start = Math.max(0, bombIndex - bombPower);
            int end = Math.min(numbers.size() - 1, bombIndex + bombPower);

            for (int i = start; i <= end; i++){
                numbers.remove(start);
            }
        }

        int numbersSum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            numbersSum += numbers.get(i);
        }
        System.out.println(numbersSum);
    }
}
