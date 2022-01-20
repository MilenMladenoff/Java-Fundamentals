package Fund2Lab;

import java.util.Scanner;

public class RefactorVolumeOfPyramid {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double length = Double.parseDouble(scan.nextLine());
        double width = Double.parseDouble(scan.nextLine());
        double height = Double.parseDouble(scan.nextLine());
        double volume = (length * width * height) / 3;
        System.out.printf("Length: Width: Height: Pyramid Volume: %.2f", volume);
    }
}
