package Fund1Lab;

import java.util.Scanner;

public class SumOfOddNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int oddNum = 1;
        int oddNumbersCounter = 0;
        int oddNumbersSum = 0;
        while (oddNumbersCounter != n){
            oddNumbersSum += oddNum;
            System.out.println(oddNum);
            oddNum += 2;
            oddNumbersCounter++;
        }
        System.out.printf("Sum: %d", oddNumbersSum);
    }
}
