package Fund6MoreExercises;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CompanyRoster {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<Employee> employees = new ArrayList<>();
        List<Department> departments = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String input = scan.nextLine();
            String[] data = input.split("\\s+");
            String name = data[0];
            double salary = Double.parseDouble(data[1]);
            String position = data[2];
            String department = data[3];
            String email = "n/a";
            int age = -1;

            if (data.length >= 5) {

                if (data[4].contains("@")) {
                    email = data[4];
                } else {
                    age = Integer.parseInt(data[4]);
                }
            }

            if (data.length == 6) {
                age = Integer.parseInt(data[5]);
            }

            Employee employee = new Employee(name, salary, position, department, email, age);
            employees.add(employee);

            Department wholeDepartment = departments.stream().filter(s -> s.getName().equals(department)).findFirst().orElse(null);

            if (wholeDepartment == null) {
                Department departmentAdd = new Department(department, salary, 1);
                departments.add(departmentAdd);
            } else {
                wholeDepartment.setSalary(wholeDepartment.getSalary() + salary);
                wholeDepartment.setPeople(wholeDepartment.getPeople() + 1);
            }
        }

        double highestAvgSalary = 0;
        String departmentPrint = " ";

        for (Department dep : departments) {
            double avgSalary = dep.salary / dep.people;

            if (avgSalary > highestAvgSalary) {
                highestAvgSalary = avgSalary;
                departmentPrint = dep.name;
            }
        }

        System.out.printf("Highest Average Salary: %s%n", departmentPrint);
        String departmentPeople = departmentPrint;
        employees.stream().filter(s -> s.getDepartment().equals(departmentPeople)).sorted(Comparator.comparing(Employee::getSalary).reversed()).collect(Collectors.toList()).stream()
                .forEach(s -> System.out.printf("%s %.2f %s %d%n", s.getName(), s.getSalary(), s.getEmail(), s.getAge()));

    }

    static class Employee {
        String name;
        double salary;
        String position;
        String department;
        String email;
        int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public Employee(String name, double salary, String position, String department, String email, int age) {
            this.name = name;
            this.salary = salary;
            this.position = position;
            this.department = department;
            this.email = email;
            this.age = age;
        }
    }

    static class Department {
        String name;
        double salary;
        int people;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public int getPeople() {
            return people;
        }

        public void setPeople(int people) {
            this.people = people;
        }

        public Department(String name, double salary, int people) {
            this.name = name;
            this.salary = salary;
            this.people = people;
        }
    }
}
