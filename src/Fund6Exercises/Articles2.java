package Fund6Exercises;

import java.util.Scanner;

public class Articles2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 1; i <= n; i++) {
            String[] data = scan.nextLine().split(", ");
            String title = data[0];
            String content = data[1];
            String author = data[2];
            Article article = new Article(title, content, author);
            System.out.println(article.toString());
        }
    }

    static class Article {
        String title;
        String content;
        String author;

        public Article(String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }

        @Override
        public String toString() {
            return String.format("%s - %s: %s", this.title, this.content, this.author);
        }
    }
}
