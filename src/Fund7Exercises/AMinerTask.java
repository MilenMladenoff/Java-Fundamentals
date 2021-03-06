package Fund7Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String resource = scan.nextLine();
        Map<String, Integer> resources = new LinkedHashMap<>();

        while (!resource.equals("stop")) {
            int quantity = Integer.parseInt(scan.nextLine());
            resources.putIfAbsent(resource, 0);
            resources.put(resource, resources.get(resource) + quantity);
            resource = scan.nextLine();
        }

        resources.forEach((k, v) -> System.out.printf("%s -> %d%n", k, v));
    }
}
