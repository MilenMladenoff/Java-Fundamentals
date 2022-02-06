package Fund4Lab;

import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        int n = Integer.parseInt(scan.nextLine());

        System.out.println(repeatString(str, n));
    }

    private static String repeatString(String str, int n) {
        String result = "";

        for (int i = 0; i < n; i++) {
            result += str;
        }
        return result;
    }
}
