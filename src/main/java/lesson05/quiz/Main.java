package lesson05.quiz;

import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        QuizManager manager = new QuizManager();

        Quiz quiz = manager.createQuiz("Викторина по Java и ООП");
        manager.setCurrentQuiz(quiz);

        Question[] questions = {
            new MultipleChoiceQuestion(
                "Какой принцип ООП позволяет одному интерфейсу работать с разными типами объектов?",
                10,
                "A",
                Arrays.asList("Полиморфизм", "Инкапсуляция", "Наследование", "Абстракция")
            ),

            new OpenQuestion(
                "Назовите язык программирования, на котором мы изучаем ООП",
                15,
                "Java"
            ),

            new MultipleChoiceQuestion(
                "Что обеспечивает принцип инкапсуляции?",
                10,
                "B",
                Arrays.asList("Множественное наследование", "Сокрытие данных", "Перегрузку методов", "Полиморфизм")
            )
        };


        Player player1 = new Player("Алексей Иванов");
        Player player2 = new Player("Мария Петрова");
        Player player3 = new Player("Дмитрий Сидоров");

        quiz.addPlayer(player1);
        quiz.addPlayer(player2);
        quiz.addPlayer(player3);


        List<Question> quizQuestions = quiz.getQuestions();
        for (int i = 0; i < quizQuestions.size(); i++) {
            Question q = quizQuestions.get(i);
            System.out.printf("Вопрос %d: %s (Тип: %s, Баллы: %d)\n",
                i + 1, q.getQuestionType(), q.getClass().getSimpleName(), q.getPoints());
        }
        quiz.startQuiz();

        String[][] playerAnswers = {
            {"A", "Java", "true", "B"},
            {"A", "Python", "false", "B"},
            {"B", "Java", "true", "A"}
        };

        Player[] players = {player1, player2, player3};

        for (int questionIndex = 0; questionIndex < quizQuestions.size(); questionIndex++) {
            Question currentQuestion = quizQuestions.get(questionIndex);
            System.out.println("\n" + "=".repeat(60));
            System.out.println("Вопрос " + (questionIndex + 1) + ":");

            currentQuestion.displayQuestion();

            System.out.println("\nОтветы игроков:");
            for (int playerIndex = 0; playerIndex < players.length; playerIndex++) {
                String answer = playerAnswers[playerIndex][questionIndex];
                System.out.println(players[playerIndex].getName() + " отвечает: " + answer);

                quiz.processAnswer(players[playerIndex], questionIndex, answer);
            }
        }

        quiz.endQuiz();
        quiz.showFinalResults();
        quiz.showQuestionStatistics();
    }
}
