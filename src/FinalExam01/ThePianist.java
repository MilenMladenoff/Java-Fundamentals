package FinalExam01;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ThePianist {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, Piece> pieces = new LinkedHashMap<>();

        for (int i = 1; i <= n; i++) {
            String[] currentPiece = scan.nextLine().split("\\|");
            String pieceName = currentPiece[0];
            String composer = currentPiece[1];
            String pieceKey = currentPiece[2];
            Piece piece = new Piece(pieceName, composer, pieceKey);
            pieces.put(pieceName, piece);
        }

        String inputCommand = scan.nextLine();

        while (!inputCommand.equals("Stop")) {
            String[] commandLine = inputCommand.split("\\|");
            String command = commandLine[0];
            String pieceName = commandLine[1];

            switch (command) {
                case "Add":
                    String composer = commandLine[2];
                    String pieceKey = commandLine[3];

                    if (pieces.containsKey(pieceName)) {
                        System.out.printf("%s is already in the collection!%n", pieceName);
                    } else {
                        Piece piece = new Piece(pieceName, composer, pieceKey);
                        pieces.put(pieceName, piece);
                        System.out.printf("%s by %s in %s added to the collection!%n", pieceName, composer, pieceKey);
                    }

                    break;
                case "Remove":

                    if (pieces.containsKey(pieceName)) {
                        pieces.remove(pieceName);
                        System.out.printf("Successfully removed %s!%n", pieceName);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", pieceName);
                    }

                    break;
                case "ChangeKey":
                    String newKey = commandLine[2];

                    if (pieces.containsKey(pieceName)) {
                        pieces.get(pieceName).setPieceKey(newKey);
                        System.out.printf("Changed the key of %s to %s!%n", pieceName, newKey);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", pieceName);
                    }

                    break;
            }

            inputCommand = scan.nextLine();
        }

        pieces.forEach((k, v) -> System.out.println(v.toString()));
    }

    private static class Piece {
        String pieceName;
        String composer;
        String pieceKey;

        public Piece(String pieceName, String composer, String pieceKey) {
            this.pieceName = pieceName;
            this.composer = composer;
            this.pieceKey = pieceKey;
        }

        public void setPieceKey(String pieceKey) {
            this.pieceKey = pieceKey;
        }

        @Override
        public String toString() {
            return String.format("%s -> Composer: %s, Key: %s", this.pieceName, this.composer, this.pieceKey);
        }
    }
}
