package Fund5MoreExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TakeSkipRope {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        List<Integer> numbers = new ArrayList<>();
        List<Character> nonNumbers = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {

            if (input.charAt(i) >= 48 && 57 >= input.charAt(i)){
                numbers.add(Character.getNumericValue(input.charAt(i)));
            } else {
                nonNumbers.add(input.charAt(i));
            }
        }

        int nonNumbersIndex = -1;
        List<String> result = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i++) {

            if (i % 2 == 0){

                for (int j = 0; j < numbers.get(i); j++) {
                    nonNumbersIndex++;

                    if (nonNumbersIndex == nonNumbers.size()){
                        break;
                    }

                    result.add(Character.toString(nonNumbers.get(nonNumbersIndex)));
                }

            } else {

                for (int j = 0; j < numbers.get(i); j++) {
                    nonNumbersIndex++;

                    if (nonNumbersIndex == nonNumbers.size()){
                        break;
                    }
                }
            }

            if (nonNumbersIndex == nonNumbers.size()){
                break;
            }
        }

        for (String element : result) {
            System.out.print(element);
        }
    }
}
