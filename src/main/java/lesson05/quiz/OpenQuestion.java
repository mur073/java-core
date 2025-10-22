package lesson05.quiz;

import java.util.ArrayList;
import java.util.List;

public class OpenQuestion extends Question {

    public OpenQuestion(String questionText, int points, String correctAnswer) {
        super(questionText, points, correctAnswer);
    }

    @Override
    public boolean checkAnswer(String userAnswer) {
        return correctAnswer.toLowerCase().trim().equals(userAnswer.toLowerCase().trim());
    }

    @Override
    public void displayQuestion() {
        System.out.println("\n" + questionText + " (" + points + " баллов)");
        System.out.print("Ваш ответ: ");
    }

    @Override
    public List<String> getAnswerOptions() {
        return new ArrayList<>();
    }

    @Override
    public String getQuestionType() {
        return "Открытый вопрос";
    }
}
