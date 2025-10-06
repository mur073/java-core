package lesson05.learningcenter;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        LearningCenter center = new LearningCenter("IT Academy");
        System.out.println(center);
        System.out.println();

        Teacher javaTeacher = new Teacher(1, "Иван Петров", "ivan@academy.com", "Java Backend");
        Teacher frontendTeacher = new Teacher(2, "Мария Сидорова", "maria@academy.com", "Frontend");

        center.addTeacher(javaTeacher);
        center.addTeacher(frontendTeacher);
        System.out.println();

        Student student1 = new Student(101, "Алексей Смирнов", "alex@student.com", "Java-2024");
        Student student2 = new Student(102, "Елена Козлова", "elena@student.com", "Java-2024");
        Student student3 = new Student(103, "Дмитрий Волков", "dmitry@student.com", "Frontend-2024");

        center.addStudent(student1);
        center.addStudent(student2);
        center.addStudent(student3);
        System.out.println();

        Course javaCourse = center.createCourse("Java Core", "Основы программирования на Java", javaTeacher, 20);
        Course frontendCourse = center.createCourse("HTML/CSS/JS", "Основы frontend разработки", frontendTeacher, 15);
        System.out.println();

        javaCourse.addStudent(student1);
        javaCourse.addStudent(student2);
        frontendCourse.addStudent(student3);
        frontendCourse.addStudent(student1);
        System.out.println();

        Person[] people = {javaTeacher, frontendTeacher, student1, student2, student3};
        for (Person person : people) {
            System.out.println(person.toString());
            System.out.println("Роль: " + person.getRole());
        }
        System.out.println();

        System.out.println("\nЖурнал посещаемости: \n");
        LocalDate today = LocalDate.now();
        LocalDate yesterday = today.minusDays(1);
        LocalDate twoDaysAgo = today.minusDays(2);

        javaCourse.markAttendance(student1, yesterday, true);
        javaCourse.markAttendance(student1, twoDaysAgo, true);
        javaCourse.markAttendance(student2, yesterday, false);
        javaCourse.markAttendance(student2, twoDaysAgo, true);

        frontendCourse.markAttendance(student3, yesterday, true);
        frontendCourse.markAttendance(student1, yesterday, true);
        System.out.println();

        javaCourse.addGrade(student1, 85);
        javaCourse.addGrade(student1, 90);
        javaCourse.addGrade(student1, 78);
        javaCourse.addGrade(student2, 92);
        javaCourse.addGrade(student2, 88);

        frontendCourse.addGrade(student3, 95);
        frontendCourse.addGrade(student1, 82);
        System.out.println();

        System.out.println();
        center.printCourseStatistics(javaCourse);
        center.printCourseStatistics(frontendCourse);

        System.out.println();
        System.out.println(center);
        System.out.println("\nВсе курсы:");
        for (Course course : center.getCourses()) {
            System.out.println("- " + course.getName() + " (Преподаватель: " + course.getTeacher().getName() +
                             ", Студентов: " + course.getStudents().size() + ")");
        }
    }
}
