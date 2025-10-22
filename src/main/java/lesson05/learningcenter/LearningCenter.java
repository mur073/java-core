package lesson05.learningcenter;

import java.util.ArrayList;
import java.util.List;

public class LearningCenter {
    private final String name;
    private final List<Course> courses;
    private final List<Teacher> teachers;
    private final List<Student> students;

    public LearningCenter(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
        this.teachers = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addTeacher(Teacher teacher) {
        if (!teachers.contains(teacher)) {
            teachers.add(teacher);
            System.out.println("Преподаватель " + teacher.getName() + " добавлен в учебный центр");
        }
    }

    public List<Teacher> getTeachers() {
        return new ArrayList<>(teachers);
    }

    public void addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
            System.out.println("Студент " + student.getName() + " зарегистрирован в учебном центре");
        }
    }

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }

    public Course createCourse(String courseName, String description, Teacher teacher, int maxStudents) {
        if (!teachers.contains(teacher)) {
            System.out.println("Преподаватель должен быть сначала добавлен в учебный центр");
            return null;
        }

        Course course = new Course(courseName, description, teacher, maxStudents);
        courses.add(course);
        System.out.println("Курс \"" + courseName + "\" создан с преподавателем " + teacher.getName());
        return course;
    }

    public List<Course> getCourses() {
        return new ArrayList<>(courses);
    }

    public Course findCourse(String courseName) {
        return courses.stream()
                .filter(course -> course.getName().equalsIgnoreCase(courseName))
                .findFirst()
                .orElse(null);
    }

    public Teacher findTeacher(int teacherId) {
        return teachers.stream()
                .filter(teacher -> teacher.getId() == teacherId)
                .findFirst()
                .orElse(null);
    }

    public Student findStudent(int studentId) {
        return students.stream()
                .filter(student -> student.getId() == studentId)
                .findFirst()
                .orElse(null);
    }

    public void printCourseStatistics(Course course) {
        System.out.println("Статистика курса: ");
        System.out.println(course);

        List<Student> courseStudents = course.getStudents();
        if (courseStudents.isEmpty()) {
            System.out.println("На курс не записан ни один студент");
            return;
        }

        System.out.println("\nСтуденты курса:");
        for (Student student : courseStudents) {
            System.out.printf("- %s\n", student.getName());
        }
    }

    @Override
    public String toString() {
        return String.format("Учебный центр \"%s\"\nКурсов: %d, Преподавателей: %d, Студентов: %d",
                name, courses.size(), teachers.size(), students.size());
    }
}
