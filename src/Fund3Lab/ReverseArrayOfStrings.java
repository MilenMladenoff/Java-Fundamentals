package Fund3Lab;

import java.util.Scanner;

public class ReverseArrayOfStrings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] items = scan.nextLine().split(" ");
        for (int i = 0; i < items.length / 2; i++) {
            String oldItem = items[i];
            items[i] = items[items.length - 1 - i];
            items[items.length - 1 - i] = oldItem;
        }
        System.out.println(String.join(" ", items));
    }
}
