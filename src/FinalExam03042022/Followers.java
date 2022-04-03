package FinalExam03042022;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Followers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] commandLine = scan.nextLine().split(": ");
        Map<String, User> users = new LinkedHashMap();

        while (!commandLine[0].equals("Log out")) {
            String command = commandLine[0];
            String userName = commandLine[1];
            User user = new User(0, 0);

            switch (command) {
                case "New follower":
                    users.putIfAbsent(userName, user);
                    break;
                case "Like":

                    if (users.containsKey(userName)) {
                        int totalLikes = users.get(userName).getLikesCounter();
                        int addLikes = Integer.parseInt(commandLine[2]);
                        users.get(userName).setLikesCounter(totalLikes + addLikes);
                    } else {
                        users.putIfAbsent(userName, user);
                        user.setLikesCounter(Integer.parseInt(commandLine[2]));
                    }

                    break;
                case "Comment":

                    if (users.containsKey(userName)) {
                        int totalComments = users.get(userName).getCommentsCounter();
                        users.get(userName).setCommentsCounter(totalComments + 1);
                    } else {
                        users.putIfAbsent(userName, user);
                        user.setCommentsCounter(1);
                    }

                    break;
                case "Blocked":

                    if (users.containsKey(userName)) {
                        users.remove(userName);
                    } else {
                        System.out.printf("%s doesn't exist.%n", userName);
                    }

                    break;
            }

            commandLine = scan.nextLine().split(": ");
        }

        System.out.printf("%d followers %n", users.size());
        users.forEach((k, v) -> {
            System.out.printf("%s: ", k);
            System.out.printf("%d%n", users.get(k).getCommentsCounter() + users.get(k).getLikesCounter());
        });
    }

    public static class User {
        public User(int likesCounter, int commentsCounter) {
            this.likesCounter = likesCounter;
            this.commentsCounter = commentsCounter;
        }

        public int getLikesCounter() {
            return likesCounter;
        }

        public void setLikesCounter(int likesCounter) {
            this.likesCounter = likesCounter;
        }

        public int getCommentsCounter() {
            return commentsCounter;
        }

        public void setCommentsCounter(int commentsCounter) {
            this.commentsCounter = commentsCounter;
        }

        int likesCounter;
        int commentsCounter;
    }
}
