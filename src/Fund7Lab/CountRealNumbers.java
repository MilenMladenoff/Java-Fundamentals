package Fund7Lab;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double[] numbers = Arrays
                .stream(scan.nextLine().split(" "))
                .mapToDouble(Double::parseDouble).toArray();

        Map<Double, Integer> numbersCount = new TreeMap<>();

        for (double number : numbers) {

            if (!numbersCount.containsKey(number)) {
                numbersCount.put(number, 0);
            }

            numbersCount.put(number, numbersCount.get(number) + 1);
        }

        for (Map.Entry<Double, Integer> entry : numbersCount.entrySet()) {
            DecimalFormat df = new DecimalFormat("#.#######");
            System.out.printf("%s -> %d%n", df.format(entry.getKey()), entry.getValue());
        }
    }
}
