package Fund7Exercises;

import java.util.*;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, List<Double>> studentsData = new LinkedHashMap<>();

        for (int i = 1; i <= n; i++) {
            String name = scan.nextLine();
            double grade = Double.parseDouble(scan.nextLine());
            studentsData.putIfAbsent(name, new ArrayList<>());
            studentsData.get(name).add(grade);
        }

        studentsData.entrySet().stream()
                .filter(s -> s.getValue().stream().mapToDouble(x -> x).average().orElse(0.0) >= 4.5)
                .forEach(entry -> {
                    double avgGrade = entry.getValue()
                            .stream().mapToDouble(x -> x).average().orElse(0.0);
                    System.out.printf("%s -> %.2f%n", entry.getKey(), avgGrade);
                });
    }
}
