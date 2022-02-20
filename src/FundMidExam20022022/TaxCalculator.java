package FundMidExam20022022;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TaxCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> vehicles = Arrays.stream(scan.nextLine().split(">>")).collect(Collectors.toList());
        double totalTaxes = 0;

        for (int i = 0; i < vehicles.size(); i++) {
            List<String> vehicleLine = Arrays.stream(vehicles.get(i).split(" ")).collect(Collectors.toList());
            String car = vehicleLine.get(0);
            int years = Integer.parseInt(vehicleLine.get(1));
            int kilometers = Integer.parseInt(vehicleLine.get(2));
            double currentTax = 0;
            boolean carIsValid = true;

            switch (car) {
                case "family":
                    currentTax = 50 - (years * 5) + (12 * (kilometers / 3000));
                    totalTaxes += currentTax;
                    break;
                case "heavyDuty":
                    currentTax = 80 - (years * 8) + (14 * (kilometers / 9000));
                    totalTaxes += currentTax;
                    break;
                case "sports":
                    currentTax = 100 - (years * 9) + (18 * (kilometers / 2000));
                    totalTaxes += currentTax;
                    break;
                default:
                    carIsValid = false;
                    System.out.println("Invalid car type.");
                    break;
            }

            if (carIsValid) {
                System.out.printf("A %s car will pay %.2f euros in taxes.%n", car, currentTax);
            }
        }

        System.out.printf("The National Revenue Agency will collect %.2f euros in taxes.", totalTaxes);
    }
}
