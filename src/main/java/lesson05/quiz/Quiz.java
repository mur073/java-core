package lesson05.quiz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Quiz {
    private final String title;
    private final List<Question> questions;
    private final List<Player> players;
    private final Map<Player, List<String>> playerAnswers;
    private boolean isActive;

    public Quiz(String title) {
        this.title = title;
        this.questions = new ArrayList<>();
        this.players = new ArrayList<>();
        this.playerAnswers = new HashMap<>();
        this.isActive = false;
    }

    public String getTitle() {
        return title;
    }

    public List<Question> getQuestions() {
        return new ArrayList<>(questions);
    }

    public List<Player> getPlayers() {
        return new ArrayList<>(players);
    }

    public boolean isActive() {
        return isActive;
    }

    public void addQuestion(Question question) {
        questions.add(question);
        System.out.println("Вопрос добавлен: " + question.getQuestionText());
    }

    public void addPlayer(Player player) {
        if (!players.contains(player)) {
            players.add(player);
            playerAnswers.put(player, new ArrayList<>());
            System.out.println("Игрок " + player.getName() + " зарегистрирован в квизе");
        } else {
            System.out.println("Игрок " + player.getName() + " уже участвует в квизе");
        }
    }

    public void startQuiz() {
        if (questions.isEmpty()) {
            System.out.println("Невозможно запустить квиз: нет вопросов!");
            return;
        }

        if (players.isEmpty()) {
            System.out.println("Невозможно запустить квиз: нет игроков!");
            return;
        }

        isActive = true;
        System.out.println("Участвующих игроков: " + players.size());
        System.out.println("Вопросов: " + questions.size());
    }

    public void endQuiz() {
        isActive = false;
    }

    public boolean processAnswer(Player player, int questionIndex, String answer) {
        if (!isActive) {
            System.out.println("Квиз не активен!");
            return false;
        }

        if (!players.contains(player)) {
            System.out.println("Игрок не зарегистрирован в квизе!");
            return false;
        }

        if (questionIndex < 0 || questionIndex >= questions.size()) {
            System.out.println("Неверный номер вопроса!");
            return false;
        }

        Question question = questions.get(questionIndex);
        boolean isCorrect = question.checkAnswer(answer);

        // Сохраняем ответ
        playerAnswers.get(player).add(answer);

        if (isCorrect) {
            player.addScore(question.getPoints());
            System.out.println("Правильный ответ! Игрок " + player.getName() +
                             " получает " + question.getPoints() + " баллов");
        } else {
            System.out.println("Неправильный ответ. Правильный ответ: " + question.getCorrectAnswer());
        }

        return isCorrect;
    }

    public void showCurrentResults() {
        players.stream()
              .sorted((p1, p2) -> Integer.compare(p2.getScore(), p1.getScore()))
              .forEach(System.out::println);
    }

    public void showFinalResults() {
        List<Player> sortedPlayers = new ArrayList<>(players);
        sortedPlayers.sort((p1, p2) -> Integer.compare(p2.getScore(), p1.getScore()));

        for (int i = 0; i < sortedPlayers.size(); i++) {
            Player player = sortedPlayers.get(i);
            String place = (i + 1) + "-е место";
            System.out.println(place + ": " + player);
        }
    }

    public void showQuestionStatistics() {
        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);
            System.out.printf("Вопрос %d (%s): %s\n",
                    i + 1, question.getQuestionType(), question.getQuestionText());
        }
    }

    @Override
    public String toString() {
        return String.format("Квиз: %s (Вопросов: %d, Игроков: %d, Статус: %s)",
                title, questions.size(), players.size(), isActive ? "Активен" : "Неактивен");
    }
}
