package StudentManagement;

// Interface for managing students
public interface StudentManagement {
    void addStudent(Student student);
    void deleteStudentById(String id);
    void updateStudentById(String id, String newName, String newMajor, float newGPA);
    void sortById();
    void sortByName();
    void sortByGPA();
    Student findHighestGPAStudent();
    void listAllStudents();
    void saveStudentsToFile(String fileName);
    void loadStudentsFromFile(String fileName);
}
