package Fund2Exercises;

import java.util.Scanner;

public class BeerKegs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        double maxVolume = 0;
        String maxVolumeModel = "";
        for (int i = 1; i <= n; i++) {
            String model = scan.nextLine();
            double radius = Double.parseDouble(scan.nextLine());
            int height = Integer.parseInt(scan.nextLine());
            double volume = Math.PI * Math.pow(radius, 2) * height;
            if (volume > maxVolume) {
                maxVolume = volume;
                maxVolumeModel = model;
            }
        }
        System.out.println(maxVolumeModel);
    }
}
