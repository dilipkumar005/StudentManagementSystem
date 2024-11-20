import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private int id;
    private String name;
    private int age;
    private String course;

   
    public Student(int id, String name, int age, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
    }

   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    
    public void displayStudent() {
        System.out.println("Student ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Course: " + course);
    }
}

public class StudentManagementSystem {

    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Remove Student");
            System.out.println("4. View All Students");
            System.out.println("5. Exit");
            System.out.print("Please choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine();  

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    updateStudent();
                    break;
                case 3:
                    removeStudent();
                    break;
                case 4:
                    viewStudents();
                    break;
                case 5:
                    System.out.println("Exiting... Thank you for using the Student Management System!");
                    return; 
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    
    private static void addStudent() {
        System.out.print("Enter student ID: ");
        int id = sc.nextInt();
        sc.nextLine();  
		
        System.out.print("Enter student name: ");
        String name = sc.nextLine();
		
        System.out.print("Enter student age: ");
        int age = sc.nextInt();
        sc.nextLine();  
		
        System.out.print("Enter student course: ");
        String course = sc.nextLine();

        Student newStudent = new Student(id, name, age, course);
        students.add(newStudent);
        System.out.println("Student added successfully!");
    }

    
    private static void updateStudent() {
        System.out.print("Enter student ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();  

        Student student = findStudentById(id);
        if (student != null) {
            System.out.print("Enter new name: ");
            student.setName(sc.nextLine());
            System.out.print("Enter new age: ");
            student.setAge(sc.nextInt());
            sc.nextLine();  
            System.out.print("Enter new course: ");
            student.setCourse(sc.nextLine());
            System.out.println("Student details updated successfully!");
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    int option = sc.nextInt();
    private static void removeStudent() {
        System.out.print("Enter student ID to remove: ");
        int id = sc.nextInt();

        Student student = findStudentById(id);
        if (student != null) {
            students.remove(student);
            System.out.println("Student removed successfully!");
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    private static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            for (Student student : students) {
                student.displayStudent();
                System.out.println("----------------------------");
            }
        }
    }

   
    private static Student findStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null; 
    }
}
