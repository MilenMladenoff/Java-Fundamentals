package Fund2MoreExercises;

import java.util.Scanner;

public class DataTypeFinder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

//        while (!input.equals("END")) {
//            if (input.equalsIgnoreCase("true") || input.equalsIgnoreCase("false")) {
//                System.out.printf("%s is boolean type%n", input);
//                input = scan.nextLine();
//                continue;
//            }
//            char firstSymbol = input.charAt(0);
//            if (firstSymbol == 45 || firstSymbol == 43) {
//                firstSymbol = input.charAt(1);
//            }
//            if ((firstSymbol < 48 || firstSymbol > 57) && input.length() == 1) {
//                System.out.printf("%s is character type%n", input);
//            }
//            if ((firstSymbol < 48 || firstSymbol > 57) && input.length() > 1) {
//                System.out.printf("%s is string type%n", input);
//            }
//            if (firstSymbol > 47 && firstSymbol < 58) {
//                boolean isDouble = false;
//                for (int i = 0; i < input.length(); i++) {
//                    char symbol = input.charAt(i);
//                    if (symbol == '.') {
//                        System.out.printf("%s is floating point type%n", input);
//                        isDouble = true;
//                        break;
//                    }
//                }
//                if (!isDouble) {
//                    System.out.printf("%s is integer type%n", input);
//                }
//            }
//            input = scan.nextLine();
//        }

        while (!input.equals("END")) {
            Scanner scan2 = new Scanner(input);
            if (scan2.hasNextInt()) {
                System.out.printf("%s is integer type%n", input);
            } else if (scan2.hasNextDouble()) {
                System.out.printf("%s is floating point type%n", input);
            } else if (input.length() == 1) {
                System.out.printf("%s is character type%n", input);
            } else if (scan2.hasNextBoolean()) {
                System.out.printf("%s is boolean type%n", input);
            } else if (scan2.hasNextLine()) {
                System.out.printf("%s is string type%n", input);
            }
            input = scan.nextLine();
        }
    }
}