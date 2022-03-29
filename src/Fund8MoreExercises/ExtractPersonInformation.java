package Fund8MoreExercises;

import java.util.Scanner;

public class ExtractPersonInformation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 1; i <= n; i++) {
            String input = scan.nextLine();
            int nameStartIndex = input.indexOf('@') + 1;
            int nameEndIndex = input.indexOf('|');
            String name = input.substring(nameStartIndex, nameEndIndex);
            int ageStartIndex = input.indexOf('#') + 1;
            int ageEndIndex = input.indexOf('*');
            String age = input.substring(ageStartIndex, ageEndIndex);
            System.out.printf("%s is %s years old.%n", name, age);
        }
    }
}
