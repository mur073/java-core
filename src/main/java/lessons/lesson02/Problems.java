package lessons.lesson02;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.random.RandomGenerator;

public class Problems {
    public static void main(String[] args) {
        Problems problems = new Problems();

        problems.guessNumber();
    }

    private int readInteger() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter value for N: ");

        int number = scanner.nextInt();

        scanner.close();
        return number;
    }

    private int readPositiveInteger() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter value for N (positive): ");
            int n = scanner.nextInt();

            if (n > 0) {
                scanner.close();
                return n;
            } else {
                System.out.println("N must be positive");
            }
        }
    }

    private double readNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number: ");

        double number = scanner.nextDouble();

        scanner.close();
        return number;
    }

    private double readPositiveNumber() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter positive number: ");
            double number = scanner.nextDouble();

            if (number > 0) {
                scanner.close();
                return number;
            } else {
                System.out.println("Number must be positive");
            }
        }
    }

    // Вывести числа от 1 до 100 (каждые 10 цифр в одну строку и каждую группу с новой строки).
    public void printNumbers() {
        for (int i = 1; i <= 100; ++i) {
            System.out.printf("%d ", i);

            if (i % 10 == 0) {
                System.out.println();
            }
        }
    }

    // Сумма чисел от 1 до N (ввод N с клавиатуры).
    public void sumNumbers() {
        int n = readPositiveInteger();

        // Formula for the sum of arithmetic progression
        int sum = (1 + n) * n / 2;

        System.out.printf("Sum from 1 to %d is %d\n", n, sum);
    }

    // Произведение чисел от 1 до N.
    public void multiplyNumbers() {
        int n = readPositiveInteger();

        long product = 1L;
        for (int i = 1; i <= n; ++i) {
            product *= i;
        }

        System.out.printf("Product of numbers from 1 to %d is %d\n", n, product);
    }

    // Сумма четных чисел от 1 до N.
    public void sumOfEvenNumbers() {
        // we could again use here the formula for arithmetic progression

        int n = readPositiveInteger();
        int sumofEven = 0;

        for (int i = 2; i <= n; i += 2) {
            sumofEven += i;
        }

        System.out.printf("Sum of even numbers from 1 to %d is %d\n", n, sumofEven);
    }

    public void sumOfDigits() {
        int originalNumber =  readInteger();
        int n = Math.abs(originalNumber);
        int sum = 0;

        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }

        System.out.printf("Sum of digits of number %d is %d\n", originalNumber, sum);
    }

    // Разворот числа (например, 1234 → 4321).
    public void reverseNumber() {
        int originalNumber = readInteger();
        int sign = originalNumber >= 0 ? 1 : -1;
        int n = Math.abs(originalNumber);
        int reversedNumber = 0;

        while (n > 0) {
            int digit = n % 10;
            reversedNumber = reversedNumber * 10 + digit;

            n /= 10;
        }

        System.out.printf("Reversed of %d is %d\n", originalNumber, reversedNumber * sign);
    }

    // Найти факториал N (через цикл, не рекурсией).
    public void factorial() {
        int n = readPositiveInteger();

        long product = 1;
        for (int i = 1; i <= n; ++i) {
            product *= i;
        }

        System.out.printf("%d! is %d\n", n, product);
    }

    // Найти первое число, которое делится на 7 и больше 1000.
    public void firstNumberDivisibleBySevenAndGreaterThanThousand() {
        int currentNumber = 1000;
        while (true) {
            if (currentNumber % 7 == 0) {
                System.out.printf("First number that is divisible by 7 and greater than 1000 is %d\n", currentNumber);
                return;
            }

            currentNumber++;
        }
    }

    private boolean isPrimeNumber(int number) {
        for (int i = 2; i*i <= number; ++i) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    // Вывести все простые числа до N.
    public void findPrimeNumbers() {
        int n = readPositiveInteger();

        System.out.printf("Prime number from 1 to %d are: ", n);
        for (int i = 2; i <= n; ++i) {
            if (isPrimeNumber(i)) {
                System.out.printf("%d ", i);
            }
        }
        System.out.println();
    }

    // Нарисовать треугольники из звездочек
    public void printTriangles() {
        int n = readPositiveInteger();
        int distance = 5;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j <= i; ++j) {
                System.out.print("*");
            }
            for (int j = 0; j < distance; ++j) {
                System.out.print(" ");
            }
            for (int j = 0; j < n - i; ++j) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println();

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n - i; ++j) {
                System.out.print("*");
            }
            for (int j = 0; j < distance; ++j) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; ++j) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // Обмен значений
    // Пользователь вводит два числа. Поменяйте их местами и выведите результат.
    public void swapNumbers() {
        int number1 = readInteger();
        int number2 = readInteger();

        int tmp = number1;
        number1 = number2;
        number2 = tmp;

        System.out.printf("Number1 = %d, number2 = %d\n", number1, number2);
    }

    // Программа позволяет вывести на экран таблицу умножения для разных случаев.
    public void multiplicationTable() {
        int n = readPositiveInteger();

        for (int i = 1; i <= 9; ++i) {
            System.out.printf("%d x %d = %d\n", n, i, n * i);
        }
    }

    // Пусть курс доллара задан переменной exchange = 12500. Пользователь вводит сумму в долларах. Выведите сумму в сумах.
    public void moneyConverter() {
        int exchange = 12500;
        double amountInDollars = readPositiveNumber();
        double amountInSums =  amountInDollars * exchange;

        System.out.printf("Amount in sums is %f\n", amountInSums);
    }

    // Пользователь вводит число. Определите, четное оно или нет и выведите ответ на экран.
    public void isEven() {
        int number = readInteger();

        if (number % 2 == 0) {
            System.out.println("Number is even");
        } else {
            System.out.println("Number is odd");
        }
    }

    // Пользователь вводит 3 числа. Найдите и выведите наибольшее.
    public void max3() {
        int number1 = readInteger();
        int number2 = readInteger();
        int number3 = readInteger();

        int max = Math.max(number1, Math.max(number2, number3));
        System.out.printf("Max number is %d\n", max);
    }

    // Пользователь вводит два числа и операцию (+, -, *, /). Выведите результат вычисления. Используйте if или switch.
    public void calculator() {
        Scanner scanner = new Scanner(System.in);

        double number1 = readNumber();
        double number2 = readNumber();

        System.out.print("Choose operation (+, -, *, /): ");
        String operation = scanner.nextLine();
        scanner.close();

        switch (operation) {
            case "+":
                System.out.printf("%f + %f = %f\n", number1, number2, number1 + number2);
                break;
            case "-":
                System.out.printf("%f - %f = %f\n", number1, number2, number1 - number2);
                break;
            case "*":
                System.out.printf("%f * %f = %f\n", number1, number2, number1 * number2);
                break;
            case "/":
                if (number2 == 0) {
                    System.out.println("Zero division error");
                } else {
                    System.out.printf("%f / %f = %f\n", number1, number2, number1 / number2);
                }
                break;
            default:
                System.out.println("Unknown operation");
        }
    }

    // Пользователь вводит n чисел (в массив). Найдите и выведите среднее значение.
    public void calculateAverage() {
        int n = readPositiveInteger();
        ArrayList<Double> numbers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Enter %d numbers separated by space: ", n);
        for (int i = 0; i < n; ++i) {
            numbers.add(scanner.nextDouble());
        }
        scanner.close();

        double sum = 0;
        for (double number: numbers) {
            sum += number;
        }
        System.out.printf("Average is %f\n", sum / n);
    }

    // Пользователь вводит массив и число. Проверьте, есть ли это число в массиве.
    public void findNumber() {
        int n = readPositiveInteger();
        ArrayList<Double> numbers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Enter %d numbers separated by space: ", n);
        for (int i = 0; i < n; ++i) {
            numbers.add(scanner.nextDouble());
        }

        System.out.print("Enter number you want to find: ");
        double numberToFind = scanner.nextDouble();
        scanner.close();

        int foundNumberIndex = numbers.indexOf(numberToFind);

        if (foundNumberIndex >= 0) {
            System.out.printf("Number %f occurs at index %d\n", numberToFind, foundNumberIndex);
        } else {
            System.out.printf("Number %f was not found\n", numberToFind);
        }
    }

    // Генерировать случайное число и дать игроку попытки угадать его.
    public void guessNumber() {
        Scanner scanner = new Scanner(System.in);
        int bound = 25;
        int randomNumber = RandomGenerator.getDefault().nextInt(bound);
        int triesCount = 0;

        while (true) {
            triesCount++;

            System.out.printf("Guess an integer between 0 and %d: ", bound);

            int userGuess = scanner.nextInt();
            if (userGuess == randomNumber) {
                System.out.printf("You won! It took %d tries\n", triesCount);
                scanner.close();
                return;
            }

            System.out.println("Try again");
        }
    }
}
