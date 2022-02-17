package Fund5Exercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> schedule = Arrays.stream(scan.nextLine().split(", ")).collect(Collectors.toList());
        List<String> commandLine = Arrays.stream(scan.nextLine().split(":")).collect(Collectors.toList());
        String command = commandLine.get(0);

        while (!command.equals("course start")) {
            String lesson = commandLine.get(1);

            switch (command) {
                case "Add":

                    if (!schedule.contains(lesson)) {
                        schedule.add(lesson);
                    }

                    break;
                case "Insert":
                    int index = Integer.parseInt(commandLine.get(2));

                    if (!schedule.contains(lesson)) {
                        schedule.add(index, lesson);
                    }

                    break;
                case "Remove":
                    schedule.remove(lesson);
                    schedule.remove(lesson + "-Exercise");
                    break;
                case "Swap":
                    String secondLesson = commandLine.get(2);
                    String fistLessonExercise = lesson + "-Exercise";
                    String secondLessonExercise = secondLesson + "-Exercise";

                    if (schedule.contains(lesson) && schedule.contains(secondLesson)) {
                        int lessonIndex = schedule.indexOf(lesson);
                        int secondLessonIndex = schedule.indexOf(secondLesson);
                        Collections.swap(schedule, lessonIndex, secondLessonIndex);
                    }

                    if (schedule.contains(fistLessonExercise)) {
                        Collections.swap(schedule, schedule.indexOf(fistLessonExercise), schedule.indexOf(lesson) + 1);
                    }

                    if (schedule.contains(secondLessonExercise)) {
                        schedule.remove(secondLessonExercise);
                        schedule.add(schedule.indexOf(secondLesson) + 1, secondLessonExercise);
                    }

                    break;
                case "Exercise":

                    if (schedule.contains(lesson) && !schedule.contains(lesson + "-Exercise")) {
                        schedule.add(schedule.indexOf(lesson) + 1, lesson + "-Exercise");
                    } else if (!schedule.contains(lesson)) {
                        schedule.add(lesson);
                        schedule.add(lesson + "-Exercise");
                    }

                    break;
            }

            commandLine = Arrays.stream(scan.nextLine().split(":")).collect(Collectors.toList());
            command = commandLine.get(0);
        }

        for (int i = 1; i <= schedule.size(); i++) {
            System.out.printf("%d.%s%n", i, schedule.get(i - 1));
        }

    }
}
