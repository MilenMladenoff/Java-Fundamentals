package Fund5Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<String> guests = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            List<String> input = Arrays.stream(scan.nextLine().split(" ")).collect(Collectors.toList());
            String name = input.get(0);

            if (input.contains("not")) {

                if (guests.contains(name)) {
                    guests.remove(name);
                } else {
                    System.out.printf("%s is not in the list!%n", name);
                }

            } else {

                if (guests.contains(name)) {
                    System.out.printf("%s is already in the list!%n", name);
                } else {
                    guests.add(name);
                }
            }
        }

        for (String guest : guests) {
            System.out.println(guest);
        }
    }
}
