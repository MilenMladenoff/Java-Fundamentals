package Fund1Exercises;

import java.util.Scanner;

public class RageExpenses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int lostGames = Integer.parseInt(scan.nextLine());
        double headsetPrice = Double.parseDouble(scan.nextLine());
        double mousePrice = Double.parseDouble(scan.nextLine());
        double keyboardPrice = Double.parseDouble(scan.nextLine());
        double displayPrice = Double.parseDouble(scan.nextLine());
        int headsets = 0;
        int mice = 0;
        int keyboards = 0;
        int displays = 0;
        for (int i = 1; i <= lostGames; i++){
            if (i % 2 == 0){
                headsets++;
            }
            if (i % 3 == 0){
                mice++;
            }
            if (i % 2 == 0 && i % 3 == 0){
                keyboards++;
                if (keyboards % 2 == 0){
                    displays++;
                }
            }
        }
        double rageExpenses = headsets * headsetPrice + mice * mousePrice + keyboards * keyboardPrice + displays * displayPrice;
        System.out.printf("Rage expenses: %.2f lv.", rageExpenses);
    }
}
