package Fund3MoreExercises;

import java.util.Scanner;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(" ");
        int[] array = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            array[i] = Integer.parseInt(input[i]);
        }
        int[] listLengths = new int[array.length];
        int[] listPrevious = new int[array.length];
        for (int i = 0; i < listLengths.length; i++) {
            listLengths[i] = 1;
            listPrevious[i] = -1;
        }
        for (int currentIndex = 1; currentIndex < array.length; currentIndex++) {
            for (int prevIndex = 0; prevIndex < currentIndex; prevIndex++) {
                if (array[prevIndex] < array[currentIndex]) {
                    int currentLength = listLengths[prevIndex] + 1;
                    if (currentLength > listLengths[currentIndex]) {
                        listLengths[currentIndex] = currentLength;
                        listPrevious[currentIndex] = prevIndex;
                    }
                }
            }
        }
        int maxListLength = 0;
        int maxLengthIndex = -1;
        for (int i = 0; i < listLengths.length; i++) {
            if (listLengths[i] > maxListLength) {
                maxListLength = listLengths[i];
                maxLengthIndex = i;
            }
        }
        int index = maxLengthIndex;
        int[] list = new int[maxListLength];
        int position = 0;
        while (index != -1) {
            list[position] = array[index];
            position++;
            index = listPrevious[index];
        }
        for (int i = list.length - 1; i >= 0; i--) {
            System.out.print(list[i] + " ");
        }
    }
}
