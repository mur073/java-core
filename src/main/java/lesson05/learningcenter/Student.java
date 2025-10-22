package lesson05.learningcenter;

import java.util.HashMap;
import java.util.Map;

public class Student extends Person {
    private String group;
    private final Map<String, Integer> grades;

    public Student(int id, String name, String email, String group) {
        super(id, name, email);
        this.group = group;
        this.grades = new HashMap<>();
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Map<String, Integer> getGrades() {
        return grades;
    }

    public void addGrade(String courseName, int grade) {
        grades.put(courseName, grade);
    }

    public Integer getGradeForCourse(String courseName) {
        return grades.get(courseName);
    }

    @Override
    public String getRole() {
        return "Студент";
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Группа: %s", group);
    }
}
