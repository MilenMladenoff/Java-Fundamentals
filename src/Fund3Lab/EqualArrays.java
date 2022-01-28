package Fund3Lab;

import java.util.Scanner;

public class EqualArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] firstInput = scan.nextLine().split(" ");
        int[] firstArr = new int[firstInput.length];
        for (int i = 0; i < firstInput.length; i++) {
            firstArr[i] = Integer.parseInt(firstInput[i]);
        }
        String[] secondInput = scan.nextLine().split(" ");
        int[] secondArr = new int[secondInput.length];
        for (int i = 0; i < secondInput.length; i++) {
            secondArr[i] = Integer.parseInt(secondInput[i]);
        }
        boolean arraysAreEqual;
        int sum = 0;
        int diffIndex = 0;
        if (firstArr.length != secondArr.length) {
            arraysAreEqual = false;
        } else {
            arraysAreEqual = true;
            for (int i = 0; i < firstArr.length; i++) {
                sum += firstArr[i];
                if (firstArr[i] != secondArr[i]) {
                    arraysAreEqual = false;
                    diffIndex = i;
                    break;
                }
            }
        }
        if (arraysAreEqual) {
            System.out.printf("Arrays are identical. Sum: %d", sum);
        } else {
            System.out.printf("Arrays are not identical. Found difference at %d index.", diffIndex);
        }
    }
}
