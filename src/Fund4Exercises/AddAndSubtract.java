package Fund4Exercises;

import java.util.Scanner;

public class AddAndSubtract {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int first = Integer.parseInt(scan.nextLine());
        int second = Integer.parseInt(scan.nextLine());
        int third = Integer.parseInt(scan.nextLine());

        subtractSumWithThird(sumFirstAndSecond(first, second), third);
    }

    private static void subtractSumWithThird(int sumFirstAndSecond, int third) {
        System.out.println(sumFirstAndSecond - third);
    }

    private static int sumFirstAndSecond(int first, int second) {
        return first + second;
    }
}
