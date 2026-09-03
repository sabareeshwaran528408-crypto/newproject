import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Student {

    int rollNo;
    String name;
    int age;
    String department;

    double mark1;
    double mark2;
    double mark3;

    double total;
    double average;
    String grade;

    // Constructor
    Student(int rollNo, String name, int age, String department,
            double mark1, double mark2, double mark3) {

        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.department = department;

        this.mark1 = mark1;
        this.mark2 = mark2;
        this.mark3 = mark3;

        calculateResult();
    }

    // Calculate total, average and grade
    void calculateResult() {

        total = mark1 + mark2 + mark3;
        average = total / 3.0;

        if (average >= 90) {
            grade = "A+";
        }
        else if (average >= 80) {
            grade = "A";
        }
        else if (average >= 70) {
            grade = "B";
        }
        else if (average >= 60) {
            grade = "C";
        }
        else if (average >= 50) {
            grade = "D";
        }
        else {
            grade = "F";
        }
    }

    // Display student details
    void display() {

        System.out.println("----------------------------------------");
        System.out.println("Roll Number : " + rollNo);
        System.out.println("Name        : " + name);
        System.out.println("Age         : " + age);
        System.out.println("Department  : " + department);
        System.out.println("Mark 1      : " + mark1);
        System.out.println("Mark 2      : " + mark2);
        System.out.println("Mark 3      : " + mark3);
        System.out.println("Total       : " + total);
        System.out.println("Average     : " + average);
        System.out.println("Grade       : " + grade);
        System.out.println("----------------------------------------");
    }
}


public class StudentManagementSystem {

    static Scanner sc = new Scanner(System.in);

    static ArrayList<Student> students = new ArrayList<>();


    // ----------------------------------------------------
    // Add Student
    // ----------------------------------------------------
    static void addStudent() {

        System.out.println("\n========== ADD STUDENT ==========");

        System.out.print("Enter Roll Number: ");
        int rollNo = sc.nextInt();
        sc.nextLine();

        // Check duplicate roll number
        for (Student s : students) {

            if (s.rollNo == rollNo) {
                System.out.println("Roll number already exists!");
                return;
            }
        }

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Department: ");
        String department = sc.nextLine();

        System.out.print("Enter Mark 1: ");
        double mark1 = sc.nextDouble();

        System.out.print("Enter Mark 2: ");
        double mark2 = sc.nextDouble();

        System.out.print("Enter Mark 3: ");
        double mark3 = sc.nextDouble();

        Student student = new Student(
                rollNo,
                name,
                age,
                department,
                mark1,
                mark2,
                mark3
        );

        students.add(student);

        System.out.println("\nStudent added successfully!");
    }


    // ----------------------------------------------------
    // Display All Students
    // ----------------------------------------------------
    static void displayStudents() {

        System.out.println("\n========== ALL STUDENTS ==========");

        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        for (Student s : students) {
            s.display();
        }
    }


    // ----------------------------------------------------
    // Search Student
    // ----------------------------------------------------
    static void searchStudent() {

        System.out.println("\n========== SEARCH STUDENT ==========");

        System.out.print("Enter Roll Number: ");
        int rollNo = sc.nextInt();

        boolean found = false;

        for (Student s : students) {

            if (s.rollNo == rollNo) {

                System.out.println("\nStudent Found!");
                s.display();

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }


    // ----------------------------------------------------
    // Update Student
    // ----------------------------------------------------
    static void updateStudent() {

        System.out.println("\n========== UPDATE STUDENT ==========");

        System.out.print("Enter Roll Number: ");
        int rollNo = sc.nextInt();
        sc.nextLine();

        boolean found = false;

        for (Student s : students) {

            if (s.rollNo == rollNo) {

                System.out.println("\nCurrent Details:");
                s.display();

                System.out.print("Enter New Name: ");
                s.name = sc.nextLine();

                System.out.print("Enter New Age: ");
                s.age = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter New Department: ");
                s.department = sc.nextLine();

                System.out.print("Enter New Mark 1: ");
                s.mark1 = sc.nextDouble();

                System.out.print("Enter New Mark 2: ");
                s.mark2 = sc.nextDouble();

                System.out.print("Enter New Mark 3: ");
                s.mark3 = sc.nextDouble();

                // Recalculate result
                s.calculateResult();

                System.out.println("\nStudent updated successfully!");

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }


    // ----------------------------------------------------
    // Delete Student
    // ----------------------------------------------------
    static void deleteStudent() {

        System.out.println("\n========== DELETE STUDENT ==========");

        System.out.print("Enter Roll Number: ");
        int rollNo = sc.nextInt();

        boolean found = false;

        for (int i = 0; i < students.size(); i++) {

            if (students.get(i).rollNo == rollNo) {

                students.remove(i);

                System.out.println("Student deleted successfully!");

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }


    // ----------------------------------------------------
    // Class Average
    // ----------------------------------------------------
    static void classAverage() {

        System.out.println("\n========== CLASS AVERAGE ==========");

        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        double totalAverage = 0;

        for (Student s : students) {
            totalAverage += s.average;
        }

        double average = totalAverage / students.size();

        System.out.println("Number of Students : " + students.size());
        System.out.println("Class Average      : " + average);
    }


    // ----------------------------------------------------
    // Find Top Student
    // ----------------------------------------------------
    static void topStudent() {

        System.out.println("\n========== TOP STUDENT ==========");

        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        Student top = students.get(0);

        for (Student s : students) {

            if (s.average > top.average) {
                top = s;
            }
        }

        System.out.println("\nTop Student:");

        top.display();
    }


    // ----------------------------------------------------
    // Grade Statistics
    // ----------------------------------------------------
    static void gradeStatistics() {

        System.out.println("\n========== GRADE STATISTICS ==========");

        int aPlus = 0;
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        int f = 0;

        for (Student s : students) {

            switch (s.grade) {

                case "A+":
                    aPlus++;
                    break;

                case "A":
                    a++;
                    break;

                case "B":
                    b++;
                    break;

                case "C":
                    c++;
                    break;

                case "D":
                    d++;
                    break;

                case "F":
                    f++;
                    break;
            }
        }

        System.out.println("A+ Grade : " + aPlus);
        System.out.println("A Grade  : " + a);
        System.out.println("B Grade  : " + b);
        System.out.println("C Grade  : " + c);
        System.out.println("D Grade  : " + d);
        System.out.println("F Grade  : " + f);
    }


    // ----------------------------------------------------
    // Sort Students by Average
    // ----------------------------------------------------
    static void sortStudents() {

        System.out.println("\n========== SORT STUDENTS ==========");

        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        Collections.sort(
            students,
            new Comparator<Student>() {

                @Override
                public int compare(Student s1, Student s2) {

                    return Double.compare(
                            s2.average,
                            s1.average
                    );
                }
            }
        );

        System.out.println("Students sorted by average!");

        displayStudents();
    }


    // ----------------------------------------------------
    // Display Passed Students
    // ----------------------------------------------------
    static void displayPassedStudents() {

        System.out.println("\n========== PASSED STUDENTS ==========");

        boolean found = false;

        for (Student s : students) {

            if (s.average >= 50) {

                s.display();

                found = true;
            }
        }

        if (!found) {
            System.out.println("No passed students.");
        }
    }


    // ----------------------------------------------------
    // Display Failed Students
    // ----------------------------------------------------
    static void displayFailedStudents() {

        System.out.println("\n========== FAILED STUDENTS ==========");

        boolean found = false;

        for (Student s : students) {

            if (s.average < 50) {

                s.display();

                found = true;
            }
        }

        if (!found) {
            System.out.println("No failed students.");
        }
    }


    // ----------------------------------------------------
    // Main Method
    // ----------------------------------------------------
    public static void main(String[] args) {

        int choice;

        while (true) {

            System.out.println("\n");
            System.out.println("==========================================");
            System.out.println("       STUDENT MANAGEMENT SYSTEM");
            System.out.println("==========================================");
            System.out.println("1.  Add Student");
            System.out.println("2.  Display All Students");
            System.out.println("3.  Search Student");
            System.out.println("4.  Update Student");
            System.out.println("5.  Delete Student");
            System.out.println("6.  Class Average");
            System.out.println("7.  Top Student");
            System.out.println("8.  Grade Statistics");
            System.out.println("9.  Sort Students");
            System.out.println("10. Display Passed Students");
            System.out.println("11. Display Failed Students");
            System.out.println("12. Exit");
            System.out.println("==========================================");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    displayStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    updateStudent();
                    break;

                case 5:
                    deleteStudent();
                    break;

                case 6:
                    classAverage();
                    break;

                case 7:
                    topStudent();
                    break;

                case 8:
                    gradeStatistics();
                    break;

                case 9:
                    sortStudents();
                    break;

                case 10:
                    displayPassedStudents();
                    break;

                case 11:
                    displayFailedStudents();
                    break;

                case 12:
                    System.out.println(
                        "\nThank you for using the Student Management System!"
                    );

                    sc.close();
                    return;

                default:
                    System.out.println(
                        "\nInvalid choice! Please enter 1-12."
                    );
            }
        }
    }
}