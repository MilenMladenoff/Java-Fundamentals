package Fund6Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RandomizeWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> words = Arrays.stream(scan.nextLine().split(" ")).collect(Collectors.toList());
        Random rnd = new Random();

        for (int i = 0; i < words.size(); i++) {
            int randomizedPos = rnd.nextInt(words.size());

            if (i != randomizedPos) {
                String initialWord = words.get(i);
                words.set(i, words.get(randomizedPos));
                words.set(randomizedPos, initialWord);
            }
        }

        for (String word : words) {
            System.out.println(word);
        }

    }
}
