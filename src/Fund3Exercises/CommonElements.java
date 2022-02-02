package Fund3Exercises;

import java.util.Scanner;

public class CommonElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] firstArr = scan.nextLine().split(" ");
        String[] secondArr = scan.nextLine().split(" ");
        for (String secondArrElement : secondArr) {
            for (String firstArrElement : firstArr) {
                if (secondArrElement.equals(firstArrElement)) {
                    System.out.printf("%s ", secondArrElement);
                }
            }
        }
    }
}
