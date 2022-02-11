package Fund4MoreExercises;

import java.util.Scanner;

public class MultiplicationSign {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] arr = new int[3];
        boolean isZero = false;
        int negativeSignCounter = 0;

        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(scan.nextLine());

            if (arr[i] == 0) {
                isZero = true;
            }

            if (arr[i] < 0) {
                negativeSignCounter++;
            }
        }

        if (isZero) {
            System.out.println("zero");
        } else {
            if (negativeSignCounter == 1 || negativeSignCounter == 3) {
                System.out.println("negative");
            } else {
                System.out.println("positive");
            }
        }
    }
}
