package Fund4MoreExercises;

import java.util.Scanner;

public class DataTypes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String type = scan.nextLine();

        switch (type) {
            case "int":
                int numInteger = Integer.parseInt(scan.nextLine());
                System.out.println(numInteger * 2);
                break;
            case "real":
                double numFloating = Double.parseDouble(scan.nextLine());
                System.out.printf("%.2f", numFloating * 1.5);
                break;
            case "string":
                String text = scan.nextLine();
                System.out.printf("$%s$", text);
                break;
        }
    }
}
