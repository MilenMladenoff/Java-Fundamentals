package MidExamPreparations;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShootForTheWin {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> targets = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String shoot = scan.nextLine();
        int shotTargetsCounter = 0;

        while (!shoot.equals("End")) {
            int shotTargetIndex = Integer.parseInt(shoot);

            if (0 <= shotTargetIndex && shotTargetIndex < targets.size() && targets.get(shotTargetIndex) != -1) {
                shotTargetsCounter++;
                int shotTargetValue = targets.get(shotTargetIndex);
                targets.set(shotTargetIndex, -1);

                for (int i = 0; i < targets.size(); i++) {
                    int currentTargetValue = targets.get(i);

                    if (currentTargetValue != -1) {

                        if (currentTargetValue > shotTargetValue) {
                            targets.set(i, targets.get(i) - shotTargetValue);
                        } else {
                            targets.set(i, targets.get(i) + shotTargetValue);
                        }
                    }
                }
            }

            shoot = scan.nextLine();
        }

        System.out.printf("Shot targets: %d -> ", shotTargetsCounter);

        for (int target : targets) {
            System.out.print(target + " ");
        }
    }
}
