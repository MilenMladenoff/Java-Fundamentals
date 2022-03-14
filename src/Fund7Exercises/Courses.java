package Fund7Exercises;

import java.util.*;

public class Courses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] inputLine = scan.nextLine().split(" : ");
        Map<String, List<String>> courses = new LinkedHashMap<>();

        while (!inputLine[0].equals("end")) {
            courses.putIfAbsent(inputLine[0], new ArrayList<>());
            courses.get(inputLine[0]).add(inputLine[1]);
            inputLine = scan.nextLine().split(" : ");
        }

        courses.entrySet().forEach(e -> {
            System.out.printf("%s: %d%n", e.getKey(), e.getValue().size());
            e.getValue().forEach(v -> System.out.printf("-- %s%n", v));
        });
    }
}
