package Fund7Exercises;

import java.util.*;

public class Orders {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        Map<String, List<Double>> products = new LinkedHashMap<>();

        while (!line.equals("buy")) {
            String[] data = line.split("\\s+");
            String item = data[0];
            double price = Double.parseDouble(data[1]);
            double quantity = Double.parseDouble(data[2]);

            if (products.containsKey(item)) {
                products.get(item).set(0, price);
                products.get(item).set(1, products.get(item).get(1) + quantity);
            } else {
                products.put(item, new ArrayList<>());
                products.get(item).add(price);
                products.get(item).add(quantity);
            }

            line = scan.nextLine();
        }

        products.forEach((k, v) -> System.out.printf("%s -> %.2f%n", k, v.get(0) * v.get(1)));
    }
}
