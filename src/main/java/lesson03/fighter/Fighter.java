package lesson03.fighter;

public class Fighter {

    final private long id;
    final private String name;
    private int health;
    final private int attack;

    public Fighter(String name, int health, int attack) {
        this.id = FighterIdGenerator.generate();
        this.name = name;
        this.health = health;
        this.attack = attack;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public void takeDamage(int damage) {
        this.health = Math.max(0, this.health - damage);
    }

    public void getFighterInfo() {
        System.out.println("Fighter information:");
        System.out.printf("\t- Code: %d\n", id);
        System.out.printf("\t- Name: %s\n", name);
        System.out.printf("\t- Health: %d\n", health);
        System.out.printf("\t- Attack: %d\n", attack);
    }

    public boolean isAlive() {
        return health > 0;
    }

    private static class FighterIdGenerator {
        private static long nextFighterId = 1L;

        public static long generate() {
            return nextFighterId++;
        }
    }
}
