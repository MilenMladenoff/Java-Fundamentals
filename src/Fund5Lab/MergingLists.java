package Fund5Lab;

import java.util.*;
import java.util.stream.Collectors;

public class MergingLists {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers1 = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> numbers2 = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> resultNumbers = new ArrayList<>();
        int loopSize = Math.min(numbers1.size(), numbers2.size()) * 2;

        for (int i = 0; i < loopSize; i++) {
            if (i % 2 == 0) {
                resultNumbers.add(numbers1.get(0));
                numbers1.remove(0);
            } else {
                resultNumbers.add(numbers2.get(0));
                numbers2.remove(0);
            }
        }

        if (numbers1.size() > numbers2.size()) {
            resultNumbers.addAll(getRemainingElements(numbers1, numbers2));
        } else {
            resultNumbers.addAll(getRemainingElements(numbers2, numbers1));
        }

        for (int item : resultNumbers) {
            System.out.print(item + " ");
        }
    }

    private static List<Integer> getRemainingElements(List<Integer> longerList, List<Integer> shorterList) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = shorterList.size(); i < longerList.size(); i++) {
            numbers.add(longerList.get(i));
        }
        return numbers;

    }
}
