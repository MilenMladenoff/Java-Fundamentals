package Fund2Exercises;

import java.util.Scanner;

public class PokeMon {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int m = Integer.parseInt(scan.nextLine());
        int y = Integer.parseInt(scan.nextLine());
        int targetsCounter = 0;
        double nInitialValue = (double) n / 2;
        while (n >= m){
            n -= m;
            targetsCounter++;
            if (n == nInitialValue && y != 0){
                n /= y;
            }
        }
        System.out.println(n);
        System.out.println(targetsCounter);
    }
}
