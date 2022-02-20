package FundExams01Mid;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TheLift {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int peopleWaiting = Integer.parseInt(scan.nextLine());
        List<Integer> lift = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        boolean hasEmptySpots = false;

        for (int i = 0; i < lift.size(); i++) {
            int currentWagon = lift.get(i);

            if (currentWagon == 4){
                continue;
            }

            if (4 - currentWagon < peopleWaiting) {
                lift.set(i, 4);
                peopleWaiting -= (4 - currentWagon);
                currentWagon = 4;
            } else {
                currentWagon = lift.get(i) + peopleWaiting;
                lift.set(i, currentWagon);
                peopleWaiting = 0;
            }

            if (currentWagon < 4){
                hasEmptySpots = true;
                break;
            }
        }

        if (hasEmptySpots){
            System.out.println("The lift has empty spots!");
        } else {

            if (peopleWaiting > 0){
                System.out.printf("There isn't enough space! %d people in a queue!%n", peopleWaiting);
            }
        }

        for (int item : lift) {
            System.out.print(item + " ");
        }
    }
}
