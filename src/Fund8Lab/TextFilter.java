package Fund8Lab;

import java.util.Scanner;

public class TextFilter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] banWords = scan.nextLine().split(", ");
        String text = scan.nextLine();

        for (String banWord : banWords) {

            if (text.contains(banWord)) {
                String replacement = repeatStr("*", banWord.length());
                text = text.replace(banWord, replacement);
            }
        }

        System.out.println(text);
    }

    private static String repeatStr(String str, int length) {
        String replacement = "";

        for (int i = 0; i < length; i++) {
            replacement += str;
        }

        return replacement;
    }
}
