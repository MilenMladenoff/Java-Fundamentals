package Fund6Exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OpinionPoll {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] data = scan.nextLine().split("\\s+");

            if (Integer.parseInt(data[1]) > 30) {
                Person person = new Person(data[0], Integer.parseInt(data[1]));
                persons.add(person);
            }
        }

        for (Person person : persons) {
            System.out.println(person);
        }

    }

    static class Person {
        String name;

        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return String.format("%s - %d", this.name, this.age);
        }
    }
}
