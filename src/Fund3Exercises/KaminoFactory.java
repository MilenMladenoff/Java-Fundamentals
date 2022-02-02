package Fund3Exercises;

import java.util.Scanner;

public class KaminoFactory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int dnaLength = Integer.parseInt(scan.nextLine());
        String input = scan.nextLine();
        int dnaCounter = 0;
        int bestDnaNum = 1;
        int maxSequence = 0;
        int bestIndex = 0;
        int maxSampleSum = 0;
        int[] bestDna = new int[dnaLength];
        while (!input.equals("Clone them!")) {
            String[] sample = input.split("!+");
            int[] currentSample = new int[dnaLength];
            for (int i = 0; i < dnaLength; i++) {
                currentSample[i] = Integer.parseInt(sample[i]);
            }
            dnaCounter++;
            int longestSequenceOne = 0;
            int longestSequenceTwo = 0;
            int sequenceIndexStart = 0;
            int sequenceIndexTemp = 0;
            int sampleSum = 0;
            if (currentSample[0] == 1) {
                longestSequenceOne++;
                sampleSum++;
            }
            for (int i = 1; i < dnaLength; i++) {
                if (currentSample[i] == 1) {
                    sampleSum++;
                }
                if (currentSample[i - 1] == currentSample[i] && currentSample[i] == 1) {
                    longestSequenceOne++;
                    if (longestSequenceOne > longestSequenceTwo) {
                        sequenceIndexTemp = sequenceIndexStart;
                        longestSequenceTwo = longestSequenceOne;
                    }
                } else if (currentSample[i - 1] == 0 && currentSample[i] == 1) {
                    longestSequenceOne = 1;
                    sequenceIndexStart = i;
                }
            }
            if (longestSequenceTwo > maxSequence
                    || (longestSequenceTwo == maxSequence && sequenceIndexTemp < bestIndex)
                    || (longestSequenceTwo == maxSequence && sequenceIndexTemp == bestIndex && sampleSum > maxSampleSum)) {
                maxSequence = longestSequenceTwo;
                bestDnaNum = dnaCounter;
                maxSampleSum = sampleSum;
                bestDna = currentSample;
                bestIndex = sequenceIndexTemp;
            }
            input = scan.nextLine();
        }
        System.out.printf("Best DNA sample %d with sum: %d.%n", bestDnaNum, maxSampleSum);
        for (int number : bestDna) {
            System.out.printf("%d ", number);
        }
    }
}