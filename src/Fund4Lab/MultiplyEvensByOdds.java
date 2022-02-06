package Fund4Lab;

import java.util.Scanner;

public class MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Math.abs(Integer.parseInt(scan.nextLine()));
        System.out.println(getMultipleOfEvensAndOdds(number));
    }

    private static int getMultipleOfEvensAndOdds(int number){
        int evensSum = getEvensDigitsSum(number);
        int oddsSum = getOddsDigitsSum(number);
        return evensSum * oddsSum;
    }

    private static int getOddsDigitsSum(int number) {
        int oddsSum = 0;
        while (number > 0){
            if (number % 2 != 0){
                oddsSum += number % 10;
            }
            number /= 10;
        }
        return oddsSum;
    }

    private static int getEvensDigitsSum(int number) {
        int evensSum = 0;
        while (number > 0){
            if (number % 2 == 0){
                evensSum += number % 10;
            }
            number /= 10;
        }
        return evensSum;
    }
}
