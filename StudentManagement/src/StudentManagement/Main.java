package StudentManagement;

import java.util.Scanner;

// Main class for running the program
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagement studentManagement = new StudentManagementImpl();

        while (true) {
            System.out.println("==============================================================");
            System.out.println("                 *** STUDENT MANAGEMENT ***                   ");
            System.out.println("1. Insert new student                | 2. Delete student by ID");
            System.out.println("3. Edit student by ID                | 4. List all students");
            System.out.println("5. Sort students by name             | 6. Sort students by GPA");
            System.out.println("7. Sort students by Id               | 8. Find student with highest GPA");    
            System.out.println("9. Save students to file             | 10. Load students from file");
            System.out.println("0. Exit");
            System.out.print("Select an option(1-9): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1:
                    System.out.print("+ Enter student ID: ");
                    String id = scanner.nextLine();
                    System.out.print("+ Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("+ Enter major: ");
                    String major = scanner.nextLine();
                    System.out.print("+ Enter student GPA(4.0/4.0): ");
                    float GPA = scanner.nextFloat();
                    studentManagement.addStudent(new Student(id, name, major, GPA));
                    System.out.println("==> Add successfully!");
                    break;
                case 2:
                    System.out.print("+ Enter student ID to delete: ");
                    String deleteId = scanner.nextLine();
                    studentManagement.deleteStudentById(deleteId);
                    System.out.println("==> Delete successfully!");
                    break;
                case 3:
                    System.out.print("+ Enter student ID to edit: ");
                    String editId = scanner.nextLine();
                    System.out.print("+ Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("+Enter new major: ");
                    String newMajor = scanner.nextLine();
                    System.out.print("+ Enter new GPA: ");
                    float newGPA = scanner.nextFloat();
                    studentManagement.updateStudentById(editId, newName, newMajor, newGPA);
                    System.out.println("==> Edit done!");
                    break;
                case 4:
                    System.out.println("+----------------------------------------------------------------------------------+");
                    System.out.println("|    ID    |             NAME             |             Major            |   GPA   |");
                    System.out.println("+----------------------------------------------------------------------------------+");
                    studentManagement.listAllStudents();
                    System.out.println("+----------------------------------------------------------------------------------+");
                    break;
                case 5:
                    studentManagement.sortByName();
                    System.out.println("+----------------------------------------------------------------------------------+");
                    System.out.println("|    ID    |             NAME             |             Major            |   GPA   |");
                    System.out.println("+----------------------------------------------------------------------------------+");
                    studentManagement.listAllStudents();
                    System.out.println("+----------------------------------------------------------------------------------+");

                    break;
                case 6:
                    studentManagement.sortByGPA();
                    System.out.println("+----------------------------------------------------------------------------------+");
                    System.out.println("|    ID    |             NAME             |             Major            |   GPA   |");
                    System.out.println("+----------------------------------------------------------------------------------+");
                    studentManagement.listAllStudents();
                    System.out.println("+----------------------------------------------------------------------------------+");

                    break;
                case 7:
                    studentManagement.sortById();
                    System.out.println("+----------------------------------------------------------------------------------+");
                    System.out.println("|    ID    |             NAME             |             Major            |   GPA   |");
                    System.out.println("+----------------------------------------------------------------------------------+");
                    studentManagement.listAllStudents();
                    System.out.println("+----------------------------------------------------------------------------------+");
                    
                    break;
                case 8:
                    Student highestGPAStudent = studentManagement.findHighestGPAStudent();
                    if (highestGPAStudent != null) {
                        System.out.println("Student with the HIGHEST GPA: " );
                        System.out.println("+----------------------------------------------------------------------------------+");
                        System.out.println("|    ID    |             NAME             |             Major            |   GPA   |");
                        System.out.println("+----------------------------------------------------------------------------------+");
                        System.out.println(highestGPAStudent);
                        System.out.println("+----------------------------------------------------------------------------------+");
                    } 
                    else {
                        System.out.println("No students found.");
                    }
                    break;
                case 9:
                    System.out.print("+ Enter file name to save: ");
                    String saveFileName = scanner.nextLine();
                    studentManagement.saveStudentsToFile(saveFileName);
                    break;
                case 10:
                    System.out.print("+ Enter file name to load: ");
                    String loadFileName = scanner.nextLine();
                    studentManagement.loadStudentsFromFile(loadFileName);
                    break;
                case 0:
                    System.out.println("Exiting program...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
