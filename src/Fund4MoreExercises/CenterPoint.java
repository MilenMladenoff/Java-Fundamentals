package Fund4MoreExercises;

import java.util.Scanner;

public class CenterPoint {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x1 = Integer.parseInt(scan.nextLine());
        int y1 = Integer.parseInt(scan.nextLine());
        int x2 = Integer.parseInt(scan.nextLine());
        int y2 = Integer.parseInt(scan.nextLine());

        int point1 = Math.abs(x1) + Math.abs(y1);
        int point2 = Math.abs(x2) + Math.abs(y2);
        String closestPoint = "";

        if (point1 <= point2) {
            closestPoint = x1 + ", " + y1;
        } else {
            closestPoint = x2 + ", " + y2;
        }

        System.out.println("(" + closestPoint + ")");
    }
}
