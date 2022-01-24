package Fund2MoreExercises;

import java.util.Scanner;

public class DataTypeFinder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
//        boolean isInteger = false;
//        boolean isDouble = false;
//        while (!input.equals("END")) {
//            int decimalPointCounter = 0;
//            if ((input.charAt(0) == '-' || input.charAt(0) == '+') && input.length() > 1) {
//                for (int i = 1; i < input.length(); i++) {
//                    isInteger = input.charAt(i) >= '0' && input.charAt(i) <= '9';
//                    if (!isInteger) {
//                        break;
//                    }
//                }
//                for (int i = 1; i < input.length(); i++) {
//                    isDouble = (input.charAt(i) >= '0' && input.charAt(i) <= '9');
//                    if (input.charAt(i) == '.') {
//                        decimalPointCounter++;
//                        isDouble = true;
//                    }
//                    if (!isDouble || decimalPointCounter > 1) {
//                        isDouble = false;
//                        break;
//                    }
//                }
//            } else {
//                for (int i = 0; i < input.length(); i++) {
//                    isInteger = input.charAt(i) >= '0' && input.charAt(i) <= '9';
//                    if (!isInteger) {
//                        break;
//                    }
//                }
//                for (int i = 0; i < input.length(); i++) {
//                    isDouble = (input.charAt(i) >= '0' && input.charAt(i) <= '9');
//                    if (input.charAt(i) == '.') {
//                        decimalPointCounter++;
//                        isDouble = true;
//                    }
//                    if (!isDouble || decimalPointCounter > 1) {
//                        isDouble = false;
//                        break;
//                    }
//                }
//            }
//            if (isInteger) {
//                System.out.printf("%s is integer type%n", input);
//            } else if (isDouble) {
//                System.out.printf("%s is floating point type%n", input);
//            } else if (input.length() == 1) {
//                System.out.printf("%s is character type%n", input);
//            } else if (input.equalsIgnoreCase("true") || input.equalsIgnoreCase("false")) {
//                System.out.printf("%s is boolean type%n", input);
//            } else {
//                System.out.printf("%s is string type%n", input);
//            }
//            input = scan.nextLine();
//        }
        while (!input.equals("END")) {
            if (input.equalsIgnoreCase("true") || input.equalsIgnoreCase("false")) {
                System.out.printf("%s is boolean type%n", input);
                input = scan.nextLine();
                continue;
            }
            char firstSymbol = input.charAt(0);
            if (firstSymbol == 45 || firstSymbol == 43) {
                firstSymbol = input.charAt(1);
            }
            if ((firstSymbol < 48 || firstSymbol > 57) && input.length() == 1) {
                System.out.printf("%s is character type%n", input);
            }
            if ((firstSymbol < 48 || firstSymbol > 57) && input.length() > 1) {
                System.out.printf("%s is string type%n", input);
            }
            if (firstSymbol > 47 && firstSymbol < 58) {
                boolean isDouble = false;
                for (int i = 0; i < input.length(); i++) {
                    char symbol = input.charAt(i);
                    if (symbol == '.') {
                        System.out.printf("%s is floating point type%n", input);
                        isDouble = true;
                        break;
                    }
                }
                if (!isDouble) {
                    System.out.printf("%s is integer type%n", input);
                }
            }
            input = scan.nextLine();
        }
    }
}