package StudentManagement;

// Student class with private fields
public class Student {
    private String id;
    private String name;
    private String major;
    private float GPA;

    public Student(String id, String name, String major, float GPA) {
        this.id = id;
        this.name = name;
        this.major = major;
        this.GPA = GPA;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public float getGPA() {
        return GPA;
    }

    public void setGPA(float GPA) {
        this.GPA = GPA;
    }

    @Override
    public String toString() {
        return String.format("| %6s |    %-25s |    %-25s |   %.1f   |", id, name, major, GPA);
    }
}
