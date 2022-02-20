package FundExams02Mid;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<String> command = Arrays.stream(scan.nextLine().split(" ")).collect(Collectors.toList());
        String action = command.get(0);

        while (!action.equals("end")) {

            switch (action) {
                case "swap":
                    int index1 = Integer.parseInt(command.get(1));
                    int index2 = Integer.parseInt(command.get(2));
                    Collections.swap(numbers, index1, index2);
                    break;
                case "multiply":
                    index1 = Integer.parseInt(command.get(1));
                    index2 = Integer.parseInt(command.get(2));
                    numbers.set(index1, numbers.get(index1) * numbers.get(index2));
                    break;
                case "decrease":

                    for (int i = 0; i < numbers.size(); i++) {
                        numbers.set(i, numbers.get(i) - 1);
                    }

                    break;
            }

            command = Arrays.stream(scan.nextLine().split(" ")).collect(Collectors.toList());
            action = command.get(0);
        }

        System.out.println(numbers.toString().replaceAll("[\\[\\]]", ""));
    }
}
