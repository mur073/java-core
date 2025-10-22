package lesson05.learningcenter;

import java.time.LocalDate;

public class AttendanceRecord {
    private final Student student;
    private final Course course;
    private final LocalDate date;
    private boolean present;

    public AttendanceRecord(Student student, Course course, LocalDate date, boolean present) {
        this.student = student;
        this.course = course;
        this.date = date;
        this.present = present;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public LocalDate getDate() {
        return date;
    }

    public boolean isPresent() {
        return present;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }

    @Override
    public String toString() {
        return String.format("%s - %s (%s): %s",
                course.getName(), student.getName(), date,
                present ? "Присутствует" : "Отсутствует");
    }
}
