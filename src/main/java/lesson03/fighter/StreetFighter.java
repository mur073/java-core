package lesson03.fighter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class StreetFighter {

    final private Map<Long, Fighter> fighters = new HashMap<>();
    final private Random random = new Random();

    public StreetFighter() {
    }

    public void addFighter(String name, int health, int attack) {
        Fighter fighter = new Fighter(name, health, attack);

        fighters.put(fighter.getId(), fighter);
    }

    public void getFighterInfo(long code) {
        Fighter fighter = fighters.get(code);

        if (fighter == null) {
            System.out.println("Fighter not found");
            return;
        }

        fighter.getFighterInfo();
    }

    public List<Fighter> getFighters() {
        return fighters.values().stream().toList();
    }

    public void fight(long fighter1Code, long fighter2Code) {
        Fighter fighter1 = fighters.get(fighter1Code);
        Fighter fighter2 = fighters.get(fighter2Code);

        if (fighter1 == null || fighter2 == null) {
            System.out.println("Fighters not found");
            return;
        }

        System.out.printf("Fight: %s vs %s\n", fighter1.getName(), fighter2.getName());

        Fighter attacker, defender;
        if (random.nextBoolean()) {
            attacker = fighter1;
            defender = fighter2;
            System.out.printf("%s attacks first\n", attacker.getName());
        } else {
            attacker = fighter2;
            defender = fighter1;
            System.out.printf("%s attacks first\n", attacker.getName());
        }

        int round = 1;
        while (fighter1.isAlive() && fighter2.isAlive()) {
            System.out.printf("Round %d:\n", round);

            System.out.printf("%s attacks %s and makes %d damage\n",
                attacker.getName(), defender.getName(), attacker.getAttack());
            defender.takeDamage(attacker.getAttack());

            System.out.printf("%s health: %d\n", defender.getName(), defender.getHealth());

            if (!defender.isAlive()) {
                System.out.printf("%s is defeated!\n", defender.getName());
                break;
            }

            Fighter temp = attacker;
            attacker = defender;
            defender = temp;

            round++;
        }

        if (fighter1.isAlive()) {
            System.out.printf("Winner: %s\n", fighter1.getName());
        } else {
            System.out.printf("Winner: %s\n", fighter2.getName());
        }
    }
}
