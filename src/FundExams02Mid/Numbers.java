package FundExams02Mid;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Numbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        double numbersSum = 0;

        for (int i = 0; i < numbers.size(); i++) {
            numbersSum += numbers.get(i);
        }

        double numbersAverageValue = numbersSum / numbers.size();
        Collections.sort(numbers);
        Collections.reverse(numbers);
        boolean isTop = false;

        int topLoopRange = 5;

        if (topLoopRange > numbers.size()) {
            topLoopRange = numbers.size();
        }

        for (int i = 0; i < topLoopRange; i++) {

            if (numbers.get(i) > numbersAverageValue) {
                isTop = true;
                System.out.printf("%d ", numbers.get(i));
            }
        }

        if (!isTop) {
            System.out.println("No");
        }
    }
}
