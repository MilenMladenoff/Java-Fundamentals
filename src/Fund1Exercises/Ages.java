package Fund1Exercises;

import java.util.Scanner;

public class Ages {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int ages = Integer.parseInt(scan.nextLine());
        String person = "";
        if (ages <= 2) {
            person = "baby";
        } else if (ages <= 13) {
            person = "child";
        } else if (ages <= 19) {
            person = "teenager";
        } else if (ages <= 65) {
            person = "adult";
        } else {
            person = "elder";
        }
        System.out.println(person);
    }
}
