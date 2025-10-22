package lesson05.learningcenter;

import java.time.LocalDate;
import java.util.*;

public class Course {
    private final String name;
    private final String description;
    private final Teacher teacher;
    private final List<Student> students;
    private final List<AttendanceRecord> attendance;
    private final Map<Student, List<Integer>> gradesMap;

    public Course(String name, String description, Teacher teacher, int maxStudents) {
        this.name = name;
        this.description = description;
        this.teacher = teacher;
        this.students = new LinkedList<>();
        this.attendance = new LinkedList<>();
        this.gradesMap = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }

    public void addStudent(Student student) {
        if (students.contains(student)) {
            System.out.println("Студент " + student.getName() + " уже записан на курс " + name);
            return;
        }

        students.add(student);
        gradesMap.put(student, new ArrayList<>());
        System.out.println("Студент " + student.getName() + " успешно добавлен на курс " + name);
    }

    public boolean removeStudent(Student student) {
        if (students.remove(student)) {
            gradesMap.remove(student);
            attendance.removeIf(record -> record.getStudent().equals(student));
            System.out.println("Студент " + student.getName() + " удален с курса " + name);
            return true;
        }
        return false;
    }

    public void markAttendance(Student student, LocalDate date, boolean present) {
        if (!students.contains(student)) {
            System.out.println("Студент " + student.getName() + " не записан на курс " + name);
            return;
        }

        AttendanceRecord record = new AttendanceRecord(student, this, date, present);
        attendance.add(record);
        System.out.println("Посещаемость отмечена: " + record);
    }

    public void addGrade(Student student, int grade) {
        if (!students.contains(student)) {
            System.out.println("Студент " + student.getName() + " не записан на курс " + name);
            return;
        }

        if (grade < 0 || grade > 100) {
            System.out.println("Оценка должна быть в диапазоне от 0 до 100");
            return;
        }

        gradesMap.get(student).add(grade);
        student.addGrade(this.name, grade);
        System.out.println("Оценка " + grade + " выставлена студенту " + student.getName() + " по курсу " + name);
    }

    public List<AttendanceRecord> getAttendance() {
        return new ArrayList<>(attendance);
    }

    public List<AttendanceRecord> getAttendanceRecords(Student student) {
        return attendance.stream()
                .filter(record -> record.getStudent().equals(student))
                .toList();
    }

    public List<Integer> getStudentGrades(Student student) {
        List<Integer> grades = gradesMap.get(student);
        return grades != null ? new ArrayList<>(grades) : new ArrayList<>();
    }

    @Override
    public String toString() {
        return String.format("Курс: %s\nОписание: %s\nПреподаватель: %s\nКоличество студентов: %d",
                name, description, teacher.getName(), students.size());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Course course = (Course) obj;
        return name.equals(course.name) && teacher.equals(course.teacher);
    }

    @Override
    public int hashCode() {
        return name.hashCode() + teacher.hashCode();
    }
}
