package Fund3Exercises;

import java.util.Scanner;

public class LadyBugs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int fieldSize = Integer.parseInt(scan.nextLine());
        String[] initialLadybugsIndexes = scan.nextLine().split(" ");
        int[] initialLadybugsPositions = new int[initialLadybugsIndexes.length];
        for (int i = 0; i < initialLadybugsIndexes.length; i++){
            initialLadybugsPositions[i] = Integer.parseInt(initialLadybugsIndexes[i]);
        }
        int[] startField = new int[fieldSize];
        for (int i = 0; i < initialLadybugsPositions.length; i++){
            int index = initialLadybugsPositions[i];
            if (index >= 0 && startField.length > index){
                startField[index] = 1;
            }
        }
        String command = scan.nextLine();
        while (!command.equals("end")){
            String[] commandData = command.split(" ");
            int ladybugIndex = Integer.parseInt(commandData[0]);
            String direction = commandData[1];
            int flyLength = Integer.parseInt(commandData[2]);
            if (ladybugIndex < 0 || ladybugIndex >= startField.length || startField[ladybugIndex] != 1){
                command = scan.nextLine();
                continue;
            }
            startField[ladybugIndex] = 0;
            switch (direction){
                case "right":
                    ladybugIndex += flyLength;
                    while (ladybugIndex < fieldSize && startField[ladybugIndex] == 1){
                        ladybugIndex += flyLength;
                    }
                    if (ladybugIndex < fieldSize){
                        startField[ladybugIndex] = 1;
                    }
                    break;
                case "left":
                    ladybugIndex -= flyLength;
                    while (ladybugIndex >= 0 && startField[ladybugIndex] == 1){
                        ladybugIndex -= flyLength;
                    }
                    if (ladybugIndex >= 0){
                        startField[ladybugIndex] = 1;
                    }
                    break;
            }
            command = scan.nextLine();
        }
        for (int i = 0; i < startField.length; i++){
            System.out.printf("%d ", startField[i]);
        }
    }
}
