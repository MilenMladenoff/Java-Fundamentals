package FundExams03Mid;

import java.util.Scanner;

public class CounterStrike {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int energy = Integer.parseInt(scan.nextLine());
        String input = scan.nextLine();
        int winsCounter = 0;
        boolean energyIsEnough = true;

        while (!input.equals("End of battle")) {
            int energyReduce = Integer.parseInt(input);

            if (energyReduce <= energy) {
                energy -= energyReduce;
                winsCounter++;
            } else {
                System.out.printf("Not enough energy! Game ends with %d won battles and %d energy", winsCounter, energy);
                energyIsEnough = false;
                break;
            }

            if (winsCounter % 3 == 0) {
                energy += winsCounter;
            }

            input = scan.nextLine();
        }

        if (energyIsEnough) {
            System.out.printf("Won battles: %d. Energy left: %d", winsCounter, energy);
        }
    }
}
