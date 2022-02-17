package Fund5Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AnonymousThreat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> virus = Arrays.stream(scan.nextLine().split(" ")).collect(Collectors.toList());
        List<String> commandLine = Arrays.stream(scan.nextLine().split(" ")).collect(Collectors.toList());
        String command = commandLine.get(0);

        while (!command.equals("3:1")) {

            switch (command) {
                case "merge":
                    int start = Math.max(0, Integer.parseInt(commandLine.get(1)));
                    int end = Math.min(virus.size() - 1, Integer.parseInt(commandLine.get(2)));
                    List<String> merged = new ArrayList<>();

                    if (start > 0 && start < virus.size()) {
                        merged.addAll(virus.subList(0, start));
                    }

                    if (start < virus.size()) {
                        List<String> mergeElements = virus.subList(start, end + 1);
                        String mergedString = "";
                        for (String mergeElement : mergeElements) {
                            mergedString += mergeElement;
                        }
                        merged.add(mergedString);
                    }

                    if (end + 1 < virus.size()) {
                        merged.addAll(virus.subList(end + 1, virus.size()));
                    }

                    if (!merged.isEmpty()) {
                        virus = merged;
                    }

                    break;
                case "divide":
                    int index = Integer.parseInt(commandLine.get(1));
                    int partitions = Integer.parseInt(commandLine.get(2));
                    String wholeElement = virus.get(index);
                    int dividedElementsLength = wholeElement.length() / partitions;
                    List<String> divided = new ArrayList<>();

                    if (wholeElement.length() % partitions == 0) {

                        for (int i = 0; i < partitions; i++) {
                            divided.add(wholeElement.substring(0, dividedElementsLength));
                            wholeElement = wholeElement.substring(dividedElementsLength);
                        }

                        virus.remove(index);
                        virus.addAll(index, divided);
                    } else {

                        for (int i = 0; i < partitions; i++) {

                            if (i == partitions - 1) {
                                divided.add(wholeElement);
                            } else {
                                divided.add(wholeElement.substring(0, dividedElementsLength));
                                wholeElement = wholeElement.substring(dividedElementsLength);
                            }
                        }

                        virus.remove(index);
                        virus.addAll(index, divided);
                    }
                    break;
            }

            commandLine = Arrays.stream(scan.nextLine().split(" ")).collect(Collectors.toList());
            command = commandLine.get(0);
        }

        for (String item : virus) {
            System.out.print(item + " ");
        }
    }
}
