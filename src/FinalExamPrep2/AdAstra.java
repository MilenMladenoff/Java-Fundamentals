package FinalExamPrep2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Pattern pattern = Pattern.compile("([#|])(?<item>[A-Za-z\\s]+)\\1(?<date>[\\d]{2}[/][\\d]{2}[/][\\d]{2})\\1(?<calories>[\\d]{1,5})\\1");
        Matcher matcher = pattern.matcher(scan.nextLine());
        List<Food> foods = new ArrayList<>();

        while (matcher.find()) {
            String item = matcher.group("item");
            String date = matcher.group("date");
            int calories = Integer.parseInt(matcher.group("calories"));
            Food food = new Food(item, date, calories);
            foods.add(food);
        }

        int days = foods.stream().mapToInt(Food::getCalories).sum() / 2000;
        System.out.printf("You have food to last you for: %d days!%n", days);
        foods.forEach(System.out::println);

    }

    static class Food {
        String item;
        String date;
        int calories;

        public Food(String item, String date, int calories) {
            this.item = item;
            this.date = date;
            this.calories = calories;
        }

        public String getItem() {
            return item;
        }

        public void setItem(String item) {
            this.item = item;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public int getCalories() {
            return calories;
        }

        public void setCalories(int calories) {
            this.calories = calories;
        }

        @Override
        public String toString() {
            return String.format("Item: %s, Best before: %s, Nutrition: %d", this.item, this.date, this.calories);
        }
    }
}
