package Fund6Exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderByAge {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Person> persons = new ArrayList<>();
        String input = scan.nextLine();

        while (!input.equals("End")) {
            String[] data = input.split("\\s+");
            Person person = new Person(data[0], data[1], Integer.parseInt(data[2]));
            persons.add(person);
            input = scan.nextLine();
        }

        persons.stream().sorted((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge())).forEach(person -> System.out.println(person.toString()));
    }

    static class Person {
        String name;
        String id;
        int age;

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return String.format("%s with ID: %s is %d years old.", this.name, this.id, this.age);
        }

        public Person(String name, String id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }
    }
}
