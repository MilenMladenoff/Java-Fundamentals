package FinalExamPrep1;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class HeroesOfCodeAndLogicVII {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        LinkedHashMap<String, int[]> heroes = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] hero = scan.nextLine().split("\\s+");
            String heroName = hero[0];
            int hp = Integer.parseInt(hero[1]);
            int mp = Integer.parseInt(hero[2]);
            int[] points = new int[]{hp, mp};
            heroes.put(heroName, points);
        }

        String input = scan.nextLine();

        while (!input.equals("End")) {
            String[] tokens = input.split(" - ");
            String command = tokens[0];
            String heroName = tokens[1];
            int amount = Integer.parseInt(tokens[2]);

            switch (command) {
                case "CastSpell":
                    String spellName = tokens[3];

                    if (heroes.get(heroName)[1] >= amount) {
                        heroes.get(heroName)[1] -= amount;
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n", heroName, spellName, heroes.get(heroName)[1]);
                    } else {
                        System.out.printf("%s does not have enough MP to cast %s!%n", heroName, spellName);
                    }

                    break;
                case "TakeDamage":
                    String attacker = tokens[3];

                    if (heroes.get(heroName)[0] - amount > 0) {
                        heroes.get(heroName)[0] -= amount;
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", heroName, amount, attacker, heroes.get(heroName)[0]);
                    } else {
                        heroes.remove(heroName);
                        System.out.printf("%s has been killed by %s!%n", heroName, attacker);
                    }

                    break;
                case "Recharge":

                    if (heroes.get(heroName)[1] + amount > 200) {
                        amount = 200 - heroes.get(heroName)[1];
                    }

                    heroes.get(heroName)[1] += amount;
                    System.out.printf("%s recharged for %d MP!%n", heroName, amount);
                    break;
                case "Heal":

                    if (heroes.get(heroName)[0] + amount > 100) {
                        amount = 100 - heroes.get(heroName)[0];
                    }

                    heroes.get(heroName)[0] += amount;
                    System.out.printf("%s healed for %s HP!%n", heroName, amount);
                    break;
            }

            input = scan.nextLine();
        }

        heroes.forEach((key, value) -> {
            System.out.println(key);
            System.out.printf("  HP: %d%n  MP: %d%n", value[0], value[1]);
        });

    }
}
