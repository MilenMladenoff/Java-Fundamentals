package Fund5Exercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AppendArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> input = Arrays.stream(scan.nextLine().trim().split("\\|")).collect(Collectors.toList());
        input.removeAll(Collections.singleton(" "));
        input.removeAll(Collections.singleton(""));
        Collections.reverse(input);

        for (int i = 0; i < input.size(); i++) {
            List<Integer> arr = Arrays.stream(input.get(i).trim().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
            System.out.print(arr.toString().replaceAll("[\\[\\],]", "") + " ");
        }
    }
}
