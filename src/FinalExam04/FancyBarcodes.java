package FinalExam04;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Pattern pattern = Pattern.compile("@[#]+([A-Z][A-Za-z\\d]{4,}[A-Z])@[#]+");

        for (int i = 1; i <= n; i++) {
            String input = scan.nextLine();
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                StringBuilder barcodeGroup = new StringBuilder();

                for (int j = 0; j < input.length(); j++) {
                    char symbol = input.charAt(j);

                    if (symbol >= 48 && 57 >= symbol) {
                        barcodeGroup.append(symbol);
                    }
                }

                if (barcodeGroup.isEmpty()) {
                    System.out.println("Product group: 00");
                } else {
                    System.out.printf("Product group: %s%n", barcodeGroup);
                }

            } else {
                System.out.println("Invalid barcode");
            }
        }
    }
}
