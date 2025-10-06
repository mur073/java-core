package lesson05.learningcenter;


public class Teacher extends Person {
    private String specialization;

    public Teacher(int id, String name, String email, String specialization) {
        super(id, name, email);
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }


    @Override
    public String getRole() {
        return "Преподаватель";
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Специализация: %s", specialization);
    }
}
