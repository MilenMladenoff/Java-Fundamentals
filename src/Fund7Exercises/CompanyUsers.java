package Fund7Exercises;

import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] inputLine = scan.nextLine().split(" -> ");
        Map<String, List<String>> companies = new LinkedHashMap<>();

        while (!inputLine[0].equals("End")) {
            companies.putIfAbsent(inputLine[0], new ArrayList<>());

            if (!companies.get(inputLine[0]).contains(inputLine[1])) {
                companies.get(inputLine[0]).add(inputLine[1]);
            }

            inputLine = scan.nextLine().split(" -> ");
        }

        companies.forEach((key, value) -> {
            System.out.println(key);
            value.forEach(v -> System.out.printf("-- %s%n", v));
        });
    }
}
