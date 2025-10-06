package lesson05.learningcenter;

public abstract class Person {
    private String name;
    private String email;
    private int id;

    public Person(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public abstract String getRole();

    @Override
    public String toString() {
        return String.format("%s: %s (ID: %d, Email: %s)", getRole(), name, id, email);
    }
}
