package Fund9Exercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Pattern pattern = Pattern.compile("%(?<customer>[A-Z][a-z]+)%[^|$.]*?<(?<product>\\w+)>[^|$.]*?\\|(?<count>\\d+)\\|[^|$.]*?(?<price>\\d+\\.?\\d+)\\$");
        double totalIncome = 0;
        String inputLine = scan.nextLine();

        while (!inputLine.equals("end of shift")) {
            Matcher matcher = pattern.matcher(inputLine);

            while (matcher.find()) {
                String customer = matcher.group("customer");
                String product = matcher.group("product");
                int count = Integer.parseInt(matcher.group("count"));
                double price = Double.parseDouble(matcher.group("price"));
                double purchase = count * price;
                totalIncome += purchase;
                System.out.printf("%s: %s - %.2f%n", customer, product, purchase);
            }

            inputLine = scan.nextLine();
        }

        System.out.printf("Total income: %.2f", totalIncome);
    }
}
