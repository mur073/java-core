package lesson02;

import java.util.Scanner;

public class Game {
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }

    private int readUserChoice(int max) {
        while (true) {
            System.out.printf("Введите номер вашего выбора (от 1 до %d): ", max);

            int choice = scanner.nextInt();
            if (choice >= 1 && choice <= max) {
                return choice;
            } else {
                System.out.printf("Пожалуйста, введите число от 1 до %d: ", max);
            }
        }
    }

    public void start() {
        System.out.println(
                """
                        Пробуждение
                        \s
                        Ты приходишь в себя на холодном песке у берега озера. \
                        Вокруг — туман, ночь, ни души. Телефон в кармане почти разряжен (1%).
                       \s
                        В другом кармане — спичка и клочок бумаги с надписью:
                            "Не доверяй голосам. Иди к северу."
                           \s
                        Выбор:
                        1. 🔦 Пойти на восток, туда, где в тумане мерцает свет.
                        2. 🧭 Пойти на север, как советует записка.
                        3. 🪵 Остаться у озера, может, кто-то придёт.
                       \s"""
        );

        int choice = readUserChoice( 3);

        if (choice == 1) {
            scene2AHandler();
        } else if (choice == 2) {
             scene2BHandler();
        } else {
             scene2CHandler();
        }
    }

    public void scene2AHandler() {
        System.out.println("""
                Восточный свет
                \s
                Ты идёшь на свет и находишь старую электростанцию. Внезапно загорается прожектор.
                \s
                Голос в громкоговорителе: «Стоять. Идентификация...»
                \s
                Ты ничего не понимаешь.
                \s
                Выбор:
                1. 🤖 Ответить: «Я человек, я потерялся!»
                2. 🏃 Убежать назад в лес.
                """);

        int choice = readUserChoice(2);
        if (choice == 1) {
            scene3AHandler();
        } else {
            scene3BHandler();
        }
    }

    public void scene2BHandler() {
        System.out.println("""
                Северный путь
                \s
                Ты следуешь на север и находишь заброшенную деревню. Дома пусты, но в одном — следы костра и дневник.
                \s
                    "Озеро просыпается в полнолуние. Не верь голосам. Прячься до рассвета."
                \s
                Выбор:
                1. 🔥 Остаться в доме до рассвета.
                2. 🚪 Выйти и идти дальше в туман.
                """);

        int choice = readUserChoice(2);
        if (choice == 1) {
            scene3CHandler();
        } else {
            scene3DHandler();
        }
    }
    public void scene2CHandler() {
        System.out.println("""
                Ожидание у озера
                \s
                Ты остаёшься на месте. Из тумана слышишь детский голос:
                    «Помоги мне… пожалуйста…»
                Тебя охватывает страх.
                \s
                Выбор:
                1. 👧 Пойти на голос.
                2. 😨 Убежать прочь в лес.
                
                """);

        int choice = readUserChoice(2);
        if (choice == 1) {
            scene3EHandler();
        } else {
            scene3FHandler();
        }
    }

    private void scene3AHandler() {
        System.out.println("""
                Попытка общения
                \s
                Ты кричишь, но свет слепит тебя. Из темноты появляется фигура в противогазе.
                \s
                Вас усыпляют. Очнулся ты уже в лаборатории. Ты стал частью эксперимента.
                """);

        endingLoseHandler();
    }

    private void scene3BHandler() {
        System.out.println("""
                Ты бежишь, но спотыкаешься. Прожектор гаснет. Что-то двигается в кустах.
                \s
                Ты исчез без следа.
                """);

        endingWinHandler();
    }

    private void scene3CHandler(
    ) {
        System.out.println("""
                Ты сидишь у костра. Проходят часы. На рассвете из тумана выходит группа людей — выжившие.
                \s
                Они помогают тебе выбраться.
                """);

        endingWinHandler();
    }

    private void scene3DHandler() {
        System.out.println("""
                Ты блуждаешь в тумане и выходишь к маяку. Там — старая рация. Связь удаётся установить.
                \s
                На следующий день — эвакуация.
                """
        );

        endingWinHandler();
    }

    private void scene3EHandler() {
        System.out.println("""
                Ты идёшь на голос и видишь девочку в белом. Она улыбается и исчезает в воде.
                \s
                Вокруг тебя — тени. Ты не можешь двигаться.
                """);
        endingLakeCurseHandler();
    }

    private void scene3FHandler() {
        System.out.println("""
                Побег в лес
                \s
                Ты бежишь прочь. Натыкаешься на подземный люк. Внутри — бункер. Там — доказательства эксперимента:
                мониторы, карты, журналы.
                \s
                Выбор:
                1. 💣 Разрушить центр управления.
                2. 🧠 Присоединиться к проекту.
                """);

        int choice = readUserChoice(2);
        if (choice == 1) {
            scene4AHandler();
        } else {
            scene4BHandler();
        }
    }

    public void scene4AHandler() {
        System.out.println("""
                Ты активируешь самоуничтожение. Озеро начинает светиться. Тьма уходит. Ты спас мир… но погиб.
                """);

        endingHeroHandler();
    }

    public void scene4BHandler() {
        System.out.println("""
                Ты входишь в проект. Тебе дают новое имя. Ты становишься частью того, что раньше преследовало тебя.
                """);

        endingSecretPlayerHandler();
    }

    public void endingWinHandler() {
        System.out.println("Конец игры: Победа!");
        System.out.println("Ты выбрался и спасся.");
    }

    public void endingLoseHandler() {
        System.out.println("Конец игры: Неудача!");
        System.out.println("Ты исчез без следа.");
    }

    public void endingLakeCurseHandler() {
        System.out.println("Конец игры: Проклятие озера!");
        System.out.println("Попал под влияние озера.");
    }

    public void endingHeroHandler() {
        System.out.println("Конец игры: Герой!");
        System.out.println("Спас мир, но погиб.");
    }

    public void endingSecretPlayerHandler() {
        System.out.println("Конец игры: Тайный участник!");
        System.out.println("Стал частью эксперимента.");
    }
}
