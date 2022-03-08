package Fund7Lab;

import java.util.*;

public class OddOccurrences {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] words = scan.nextLine().split(" ");
        Map<String, Integer> counts = new LinkedHashMap<>();

        for (String word : words) {
            String wordInLowercase = word.toLowerCase();

            if (counts.containsKey(wordInLowercase)) {
                counts.put(wordInLowercase, counts.get(wordInLowercase) + 1);
            } else {
                counts.put(wordInLowercase, 1);
            }
        }

        List<String> odds = new ArrayList<>();

        for (var entry : counts.entrySet()) {

            if (entry.getValue() % 2 == 1) {
                odds.add(entry.getKey());
            }
        }

        for (int i = 0; i < odds.size(); i++) {
            System.out.print(odds.get(i));

            if (i < odds.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
