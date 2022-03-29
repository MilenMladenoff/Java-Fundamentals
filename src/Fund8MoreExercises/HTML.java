package Fund8MoreExercises;

import java.util.Scanner;

public class HTML {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String articleTitle = scan.nextLine();
        System.out.printf("<h1>%n%s%n</h1>%n", articleTitle);
        String articleContent = scan.nextLine();
        System.out.printf("<article>%n%s%n</article>%n", articleContent);
        String comment = scan.nextLine();

        while (!comment.equals("end of comments")) {
            System.out.printf("<div>%n%s%n</div>%n", comment);
            comment = scan.nextLine();
        }
    }
}
