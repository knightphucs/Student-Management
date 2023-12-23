package StudentManagement;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class StudentManagementImpl extends BaseStudentManagement {
    @Override
    public void sortById() {
        studentList.sort(Comparator.comparing(Student::getId));
    }
    
    @Override
    public void sortByName() {
        studentList.sort(Comparator.comparing(Student::getName));
    }

    @Override
    public void sortByGPA() {
        studentList.sort(Comparator.comparing(Student::getGPA));
    }

    @Override
    public Student findHighestGPAStudent() {
        if (studentList.isEmpty()) {
            return null;
        }
        return Collections.max(studentList, Comparator.comparing(Student::getGPA));
    }

    /**
     *
     * @param fileName
     */
    @Override
    public void loadStudentsFromFile(String fileName) {
        studentList.clear();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String[] studentInfo = scanner.nextLine().split(",");
                if (studentInfo.length == 4) {
                    Student student = new Student(studentInfo[0], studentInfo[1], studentInfo[2], Float.parseFloat(studentInfo[3]));
                    addStudent(student);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("The specified file was not found: " + fileName);
        }
    }
}
