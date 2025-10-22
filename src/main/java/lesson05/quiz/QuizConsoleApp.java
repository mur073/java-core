package lesson05.quiz;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class QuizConsoleApp {
    private final QuizManager quizManager;
    private final Scanner scanner;

    public QuizConsoleApp() {
        this.quizManager = new QuizManager();
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            showMainMenu();
            int choice = getIntInput("Выберите действие: ");

            switch (choice) {
                case 1 -> createQuiz();
                case 2 -> selectQuiz();
                case 3 -> addQuestionToQuiz();
                case 4 -> addPlayerToQuiz();
                case 5 -> runQuiz();
                case 6 -> showResults();
                case 8 -> {
                    System.out.println("До свидания!");
                    return;
                }
                default -> System.out.println("Неверный выбор! Попробуйте снова.");
            }
        }
    }

    private void showMainMenu() {
        System.out.println("\nМеню");
        System.out.println("1. Создать новый квиз");
        System.out.println("2. Выбрать активный квиз");
        System.out.println("3. Добавить вопрос в квиз");
        System.out.println("4. Добавить игрока в квиз");
        System.out.println("5. Запустить квиз");
        System.out.println("6. Показать результаты");
        System.out.println("7. Выход");
    }

    private void createQuiz() {
        System.out.print("Введите название квиза: ");
        String title = scanner.nextLine();
        Quiz quiz = quizManager.createQuiz(title);
        quizManager.setCurrentQuiz(quiz);
    }

    private void selectQuiz() {
        quizManager.showAllQuizzes();
        if (quizManager.getAllQuizzes().isEmpty()) {
            return;
        }

        System.out.print("Введите номер квиза: ");
        int index = getIntInput("") - 1;

        List<Quiz> quizzes = quizManager.getAllQuizzes();
        if (index >= 0 && index < quizzes.size()) {
            quizManager.setCurrentQuiz(quizzes.get(index));
        } else {
            System.out.println("Неверный номер квиза!");
        }
    }

    private void addQuestionToQuiz() {
        Quiz currentQuiz = quizManager.getCurrentQuiz();
        if (currentQuiz == null) {
            System.out.println("Сначала выберите или создайте квиз!");
            return;
        }

        System.out.println("Типы вопросов:");
        System.out.println("1. Множественный выбор");
        System.out.println("2. Открытый вопрос");

        int type = getIntInput("Выберите тип вопроса: ");

        System.out.print("Введите текст вопроса: ");
        String questionText = scanner.nextLine();

        int points = getIntInput("Введите количество баллов за вопрос: ");

        Question question;

        if (type == 1) {
            System.out.println("Введите варианты ответов (минимум 2):");
            System.out.print("Вариант A: ");
            String optionA = scanner.nextLine();
            System.out.print("Вариант B: ");
            String optionB = scanner.nextLine();
            System.out.print("Вариант C (или Enter для пропуска): ");
            String optionC = scanner.nextLine();
            System.out.print("Вариант D (или Enter для пропуска): ");
            String optionD = scanner.nextLine();

            List<String> options = Arrays.asList(optionA, optionB);
            if (!optionC.trim().isEmpty()) {
                options = Arrays.asList(optionA, optionB, optionC);
            }
            if (!optionD.trim().isEmpty()) {
                options = Arrays.asList(optionA, optionB, optionC, optionD);
            }

            System.out.print("Введите правильный ответ (A, B, C или D): ");
            String correctAnswer = scanner.nextLine().toUpperCase();

            question = new MultipleChoiceQuestion(questionText, points, correctAnswer, options);
        } else {
            System.out.print("Введите правильный ответ: ");
            String correctAnswer = scanner.nextLine();

            question = new OpenQuestion(questionText, points, correctAnswer);
        }

        currentQuiz.addQuestion(question);
    }

    private void addPlayerToQuiz() {
        Quiz currentQuiz = quizManager.getCurrentQuiz();
        if (currentQuiz == null) {
            System.out.println("Сначала выберите или создайте квиз!");
            return;
        }

        System.out.print("Введите имя игрока: ");
        String playerName = scanner.nextLine();

        Player player = new Player(playerName);
        currentQuiz.addPlayer(player);
    }

    private void runQuiz() {
        Quiz currentQuiz = quizManager.getCurrentQuiz();
        if (currentQuiz == null) {
            System.out.println("Сначала выберите или создайте квиз!");
            return;
        }

        currentQuiz.startQuiz();

        List<Question> questions = currentQuiz.getQuestions();
        List<Player> players = currentQuiz.getPlayers();

        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);
            System.out.println("\n" + "=".repeat(50));
            System.out.println("ВОПРОС " + (i + 1) + " из " + questions.size());

            question.displayQuestion();

            for (Player player : players) {
                System.out.println("\nОтвечает игрок: " + player.getName());
                System.out.print("Ответ: ");
                String answer = scanner.nextLine();

                currentQuiz.processAnswer(player, i, answer);
            }

            if (i < questions.size() - 1) {
                currentQuiz.showCurrentResults();
                System.out.println("\nНажмите Enter для продолжения...");
                scanner.nextLine();
            }
        }

        currentQuiz.endQuiz();
        currentQuiz.showFinalResults();
    }

    private void showResults() {
        Quiz currentQuiz = quizManager.getCurrentQuiz();
        if (currentQuiz == null) {
            System.out.println("Сначала выберите квиз!");
            return;
        }

        System.out.println("1. Текущие результаты");
        System.out.println("2. Финальные результаты");
        System.out.println("3. Статистика по вопросам");

        int choice = getIntInput("Что показать? ");

        switch (choice) {
            case 1 -> currentQuiz.showCurrentResults();
            case 2 -> currentQuiz.showFinalResults();
            case 3 -> currentQuiz.showQuestionStatistics();
            default -> System.out.println("Неверный выбор!");
        }
    }

    private int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Пожалуйста, введите корректное число!");
            }
        }
    }

    public static void main(String[] args) {
        QuizConsoleApp app = new QuizConsoleApp();
        app.run();
    }
}
