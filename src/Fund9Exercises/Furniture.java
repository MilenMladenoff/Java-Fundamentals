package Fund9Exercises;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String inputLine = scan.nextLine();
        Pattern pattern = Pattern.compile(">>(?<name>[\\w]+)<<(?<price>[\\d.]+)!(?<quantity>[\\d]+)");
        List<String> purchases = new LinkedList<>();
        double totalSum = 0;

        while (!inputLine.equals("Purchase")) {
            Matcher matcher = pattern.matcher(inputLine);

            while (matcher.find()) {
                String name = matcher.group("name");
                double price = Double.parseDouble(matcher.group("price"));
                int quantity = Integer.parseInt(matcher.group("quantity"));
                purchases.add(name);
                totalSum += price * quantity;
            }

            inputLine = scan.nextLine();
        }

        System.out.println("Bought furniture:");
        purchases.forEach(System.out::println);
        System.out.printf("Total money spend: %.2f", totalSum);
    }
}
