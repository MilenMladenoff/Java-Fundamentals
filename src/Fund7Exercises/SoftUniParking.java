package Fund7Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, String> cars = new LinkedHashMap<>();

        for (int i = 1; i <= n; i++) {
            String[] command = scan.nextLine().split(" ");

            if (command[0].equals("register")) {

                if (!cars.containsKey(command[1])) {
                    cars.put(command[1], command[2]);
                    System.out.printf("%s registered %s successfully%n", command[1], command[2]);
                } else {
                    System.out.printf("ERROR: already registered with plate number %s%n", cars.get(command[1]));
                }
            } else {

                if (!cars.containsKey(command[1])) {
                    System.out.printf("ERROR: user %s not found%n", command[1]);
                } else {
                    cars.remove(command[1]);
                    System.out.printf("%s unregistered successfully%n", command[1]);
                }
            }
        }

        cars.forEach((k, v) -> System.out.printf("%s => %s%n", k, v));
    }
}
