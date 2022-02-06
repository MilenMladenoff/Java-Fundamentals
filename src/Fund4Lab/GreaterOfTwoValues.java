package Fund4Lab;

import java.util.Scanner;

public class GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String type = scan.nextLine();

        if (type.equals("int")) {
            int first = Integer.parseInt(scan.nextLine());
            int second = Integer.parseInt(scan.nextLine());
            System.out.println(getMax(first, second));
        } else if (type.equals("char")) {
            char first = scan.nextLine().charAt(0);
            char second = scan.nextLine().charAt(0);
            System.out.println(getMax(first, second));
        } else {
            String first = scan.nextLine();
            String second = scan.nextLine();
            System.out.println(getMax(first, second));
        }

    }

    static int getMax(int first, int second) {
        return Math.max(first, second);
    }

    static char getMax(char firstChar, char secondChar) {
        if (firstChar > secondChar) {
            return firstChar;
        } else {
            return secondChar;
        }
    }

    static String getMax(String firstStr, String secondStr) {
        if (firstStr.compareTo(secondStr) >= 0) {
            return firstStr;
        } else {
            return secondStr;
        }
    }
}
