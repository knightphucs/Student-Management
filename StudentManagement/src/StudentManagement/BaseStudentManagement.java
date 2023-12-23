package StudentManagement;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

// Base class for managing students
public abstract class BaseStudentManagement implements StudentManagement {
    protected List<Student> studentList;

    public BaseStudentManagement() {
        this.studentList = new ArrayList<>();
    }

    @Override
    public void addStudent(Student student) {
        studentList.add(student);
    }

    @Override
    public void deleteStudentById(String id) {
        studentList.removeIf(student -> student.getId().equals(id));
    }

    @Override
    public void updateStudentById(String id, String newName, String newMajor, float newGPA) {
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                student.setName(newName);
                student.setMajor(newMajor);
                student.setGPA(newGPA);
                break;
            }
        }
    }

    @Override
    public void listAllStudents() {
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    @Override
    public void saveStudentsToFile(String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (Student student : studentList) {
                writer.println(student.getId() + "," + student.getName() + "," + student.getMajor() + "," + student.getGPA());
            }
        } 
        catch (IOException e) {
            System.err.println("Something error when writing into file: " + fileName);
        }
    }
}
