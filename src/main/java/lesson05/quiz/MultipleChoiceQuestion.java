package lesson05.quiz;

import java.util.Arrays;
import java.util.List;

public class MultipleChoiceQuestion extends Question {
    private final List<String> options;

    public MultipleChoiceQuestion(String questionText, int points, String correctAnswer, List<String> options) {
        super(questionText, points, correctAnswer);
        this.options = options;
    }

    @Override
    public boolean checkAnswer(String userAnswer) {
        return correctAnswer.equalsIgnoreCase(userAnswer.trim());
    }

    @Override
    public void displayQuestion() {
        System.out.println("\n" + questionText + " (" + points + " баллов)");
        for (int i = 0; i < options.size(); i++) {
            System.out.println((char)('A' + i) + ") " + options.get(i));
        }
        System.out.print("Ваш ответ (введите букву): ");
    }

    @Override
    public List<String> getAnswerOptions() {
        return options;
    }

    @Override
    public String getQuestionType() {
        return "Множественный выбор";
    }
}
