package Fund3Exercises;

import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int wagons = Integer.parseInt(scan.nextLine());
        int[] train = new int[wagons];
        int peopleSum = 0;
        for (int i = 0; i < wagons; i++) {
            train[i] = Integer.parseInt(scan.nextLine());
            peopleSum += train[i];
            System.out.printf("%d ", train[i]);
        }
        System.out.printf("%n%d", peopleSum);
    }
}
