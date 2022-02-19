package Fund5MoreExercises;

import java.util.*;
import java.util.stream.Collectors;

public class MixedUpLists {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> firstList = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondList = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        Collections.reverse(secondList);
        List<Integer> mixedList = new ArrayList<>();

        for (int i = 0; i <= firstList.size() + 1; i++) {

            if (!firstList.isEmpty() && !secondList.isEmpty()) {
                mixedList.add(firstList.get(i));
                firstList.remove(i);
                mixedList.add(secondList.get(i));
                secondList.remove(i);
            } else {
                break;
            }

            i--;
        }

        Collections.sort(mixedList);

        if (firstList.size() < secondList.size()) {
            printMixedListResultRange(secondList, mixedList);
        } else {
            Collections.sort(firstList);
            printMixedListResultRange(firstList, mixedList);
        }
    }

    private static void printMixedListResultRange(List<Integer> secondList, List<Integer> mixedList) {
        Collections.sort(secondList);

        for (int i = 0; i < mixedList.size(); i++) {

            if (mixedList.get(i) > secondList.get(0) && secondList.get(1) > mixedList.get(i)) {
                System.out.print(mixedList.get(i) + " ");
            }
        }
    }
}
