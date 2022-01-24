package Fund2MoreExercises;

import java.util.Scanner;

public class BalancedBrackets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int bracketsCounter = 0;
        char lastBracket = '\0';
        boolean isBalanced = true;
        for (int i = 1; i <= n; i++) {
            char symbol = scan.nextLine().charAt(0);
            if (symbol == '(' && lastBracket == '(') {
                isBalanced = false;
                break;
            }
            if (symbol == ')' && lastBracket == ')') {
                isBalanced = false;
                break;
            }
            if (symbol == '(') {
                bracketsCounter++;
                lastBracket = '(';
            }
            if (symbol == ')') {
                bracketsCounter++;
                lastBracket = ')';
            }
        }
        if (bracketsCounter % 2 != 0) {
            isBalanced = false;
        }
        if (isBalanced) {
            System.out.println("BALANCED");
        } else {
            System.out.println("UNBALANCED");
        }
    }
}
