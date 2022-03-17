package Fund7MoreExercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Snowwhite {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] inputLine = scan.nextLine().split(" <:> ");
        Map<String, Integer> dwarfs = new LinkedHashMap<>();
        Map<String, Integer> dwarfsCountByColor = new LinkedHashMap<>();

        while (!inputLine[0].equals("Once upon a time")){
            String dwarf = inputLine[1] + " " + inputLine[0];
            String color = inputLine[1];
            int physics = Integer.parseInt(inputLine[2]);
            dwarfsCountByColor.putIfAbsent(color, 0);
            dwarfsCountByColor.put(color, dwarfsCountByColor.get(color) + 1);

            if (dwarfs.containsKey(dwarf)){

                if (dwarfs.get(dwarf) < physics){
                    dwarfs.put(dwarf, physics);
                    dwarfsCountByColor.put(color, dwarfsCountByColor.get(color) - 1);
                }

            } else {
                dwarfs.put(dwarf, physics);
            }

            inputLine = scan.nextLine().split(" <:> ");
        }

        dwarfs.entrySet().stream().sorted((p1, p2) -> {
            int sort = Integer.compare(p2.getValue(), p1.getValue());

            if (sort == 0){
                String[] color1 = p1.getKey().split(" ");
                String[] color2 = p2.getKey().split(" ");
                int size1 = dwarfsCountByColor.get(color1[0]);
                int size2 = dwarfsCountByColor.get(color2[0]);
                sort = Integer.compare(size2, size1);
            }

            return sort;
        }).forEach(p -> {
            String[] print = p.getKey().split(" ");
            System.out.printf("(%s) %s <-> %d%n", print[0], print[1], p.getValue());
        });
    }
}
