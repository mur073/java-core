package lesson05.quiz;

import java.util.ArrayList;
import java.util.List;

public class QuizManager {
    private final List<Quiz> quizzes;
    private Quiz currentQuiz;

    public QuizManager() {
        this.quizzes = new ArrayList<>();
        this.currentQuiz = null;
    }

    public Quiz createQuiz(String title) {
        Quiz quiz = new Quiz(title);
        quizzes.add(quiz);
        System.out.println("Квиз \"" + title + "\" создан успешно!");
        return quiz;
    }

    public void setCurrentQuiz(Quiz quiz) {
        if (quizzes.contains(quiz)) {
            this.currentQuiz = quiz;
            System.out.println("Активный квиз: " + quiz.getTitle());
        } else {
            System.out.println("Квиз не найден в системе!");
        }
    }

    public Quiz getCurrentQuiz() {
        return currentQuiz;
    }

    public List<Quiz> getAllQuizzes() {
        return new ArrayList<>(quizzes);
    }

    public Quiz findQuiz(String title) {
        return quizzes.stream()
                .filter(quiz -> quiz.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);
    }

    public void showAllQuizzes() {
        if (quizzes.isEmpty()) {
            System.out.println("Нет созданных квизов");
            return;
        }

        System.out.println("\nВсе квизы: ");
        for (int i = 0; i < quizzes.size(); i++) {
            Quiz quiz = quizzes.get(i);
            String status = (quiz == currentQuiz) ? " [АКТИВНЫЙ]" : "";
            System.out.println((i + 1) + ". " + quiz + status);
        }
    }

    public void createSampleQuestions(Quiz quiz) {
        Question q1 = new MultipleChoiceQuestion(
            "Какой принцип ООП позволяет одному интерфейсу работать с разными типами объектов?",
            10,
            "A",
            List.of("Полиморфизм", "Инкапсуляция", "Наследование", "Абстракция")
        );

        Question q2 = new OpenQuestion(
            "Назовите основной принцип ООП, который скрывает внутреннее устройство объекта",
            15,
            "инкапсуляция"
        );

        Question q3 = new MultipleChoiceQuestion(
            "Что такое абстракция в ООП?",
            10,
            "B",
            List.of("Сокрытие данных", "Выделение главных характеристик", "Наследование свойств", "Множественное наследование")
        );

        quiz.addQuestion(q1);
        quiz.addQuestion(q2);
        quiz.addQuestion(q3);
    }
}
