package lesson03;

import lesson03.book.BookStore;
import lesson03.fighter.StreetFighter;

public class Main {
    public static void main(String[] args) {
        StreetFighter game = new StreetFighter();

        game.addFighter("Ahad", 100, 25);
        game.addFighter("Murio", 95, 30);
        game.addFighter("Rustam", 90, 28);

        game.fight(1L, 2L);
    }
}
