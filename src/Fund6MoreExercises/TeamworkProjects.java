package Fund6MoreExercises;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TeamworkProjects {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<Team> teams = new ArrayList<>();
        String input;

        for (int i = 1; i <= n; i++) {
            input = scan.nextLine();
            String[] data = input.split("-");
            String creator = data[0];
            String teamName = data[1];
            Team teamExist = teams.stream().filter(s -> s.getTeamName().equals(teamName)).findFirst().orElse(null);
            Team creatorExist = teams.stream().filter(s -> s.getCreator().equals(creator)).findFirst().orElse(null);

            if (teamExist == null && creatorExist == null) {
                Team singleTeam = new Team(creator, teamName);
                teams.add(singleTeam);
                System.out.printf("Team %s has been created by %s!%n", teamName, creator);
            }

            if (teamExist != null) {
                System.out.printf("Team %s was already created!%n", teamName);
            }

            if (creatorExist != null) {
                System.out.printf("%s cannot create another team!%n", creator);
            }
        }

        input = scan.nextLine();

        while (!input.equals("end of assignment")) {
            String[] data = input.split("->");
            String currentMember = data[0];
            String teamName = data[1];
            Team teamExist = teams.stream().filter(s -> s.getTeamName().equals(teamName)).findFirst().orElse(null);
            Team memberExist = teams.stream().filter(s -> s.getMembers().contains(currentMember) || s.getCreator().equals(currentMember)).findFirst().orElse(null);

            if (teamExist == null) {
                System.out.printf("Team %s does not exist!%n", teamName);
            } else if (memberExist != null) {
                System.out.printf("Member %s cannot join team %s!%n", currentMember, teamName);
            } else {
                List<String> members = teamExist.getMembers();
                members.add(currentMember);
                teamExist.setMembers(members);
            }

            input = scan.nextLine();
        }

        teams.stream().filter(s -> s.getMembers().size() > 0).sorted(Comparator.comparing(Team::membersCount).reversed().thenComparing(Team::getTeamName)).forEach(System.out::println);
        System.out.println("Teams to disband:");
        teams.stream().filter(s -> s.getMembers().size() == 0).sorted(Comparator.comparing(Team::getTeamName)).forEach(s -> System.out.println(s.getTeamName()));

    }

    static class Team {
        private String creator;
        private String teamName;
        private List<String> members;

        public String getCreator() {
            return creator;
        }

        public void setCreator(String creator) {
            this.creator = creator;
        }

        public String getTeamName() {
            return teamName;
        }

        public void setTeamName(String teamName) {
            this.teamName = teamName;
        }

        public List<String> getMembers() {
            return members;
        }

        public void setMembers(List<String> members) {
            this.members = members;
        }

        public Team(String creator, String teamName) {
            this.creator = creator;
            this.teamName = teamName;
            this.members = new ArrayList<>();
        }

        public int membersCount() {
            return members.size();
        }

        @Override
        public String toString() {
            List<String> sortedMembers = this.members.stream().sorted().collect(Collectors.toList());
            String printMembers = "";

            for (String member : sortedMembers) {
                printMembers += String.format("%n-- %s", member);
            }

            return String.format("%s%n- %s%s", this.teamName, this.creator, printMembers);
        }
    }
}
