package Fund5MoreExercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DrumSet {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double savings = Double.parseDouble(scan.nextLine());
        List<Integer> initialDrumSet = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> drumSet = new ArrayList<>(initialDrumSet);
        String action = scan.nextLine();

        while (!action.equals("Hit it again, Gabsy!")) {
            int hitPower = Integer.parseInt(action);

            for (int i = 0; i < drumSet.size(); i++) {
                drumSet.set(i, drumSet.get(i) - hitPower);

                if (drumSet.get(i) <= 0 && savings > initialDrumSet.get(i) * 3) {
                    drumSet.set(i, initialDrumSet.get(i));
                    savings -= initialDrumSet.get(i) * 3;
                }
            }

            action = scan.nextLine();
        }

        for (int i = 0; i < drumSet.size(); i++) {

            if (drumSet.get(i) <= 0) {
                drumSet.remove(i);
                i--;
            }
        }

        for (int drum : drumSet) {
            System.out.print(drum + " ");
        }

        System.out.printf("%nGabsy has %.2flv.", savings);
    }
}
