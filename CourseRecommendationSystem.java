
import java.util.ArrayList;
import java.util.Scanner;

// Student class
class Student {
    String name;
    ArrayList<String> skills = new ArrayList<>();
    ArrayList<String> completedCourses = new ArrayList<>();

    Student(String name) {
        this.name = name;
    }

    void addSkill(String skill) {
        skills.add(skill);
        System.out.println("Skill added successfully!");
    }

    void viewSkills() {
        if (skills.isEmpty()) {
            System.out.println("No skills added yet.");
        } else {
            System.out.println("Your Skills:");

            for (String skill : skills) {
                System.out.println("- " + skill);
            }
        }
    }

    void recommendCourses() {
        System.out.println("\nRecommended Courses:");

        if (skills.isEmpty()) {
            System.out.println("Add skills to get course recommendations.");
            return;
        }

        for (String skill : skills) {
            switch (skill.toLowerCase()) {
                case "java":
                    System.out.println("- Advanced Java Programming");
                    System.out.println("- Spring Boot Basics");
                    break;

                case "python":
                    System.out.println("- Data Science with Python");
                    System.out.println("- Machine Learning Basics");
                    break;

                case "web development":
                    System.out.println("- HTML, CSS, JavaScript");
                    System.out.println("- React JS");
                    break;

                case "c++":
                    System.out.println("- Data Structures in C++");
                    break;

                default:
                    System.out.println("- General Programming Course");
            }
        }
    }

    void completeCourse(String course) {
        completedCourses.add(course);
        System.out.println("Course marked as completed!");
    }

    void viewCompletedCourses() {
        if (completedCourses.isEmpty()) {
            System.out.println("No completed courses.");
        } else {
            System.out.println("Completed Courses:");

            for (String course : completedCourses) {
                System.out.println("- " + course);
            }
        }
    }
}

// Main class
public class CourseRecommendationSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student student = null;

        while (true) {
            System.out.println("\n===== COURSE RECOMMENDATION SYSTEM =====");
            System.out.println("1. Create Student");
            System.out.println("2. Add Skill");
            System.out.println("3. View Skills");
            System.out.println("4. Get Course Recommendations");
            System.out.println("5. Complete a Course");
            System.out.println("6. View Completed Courses");
            System.out.println("7. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Clear input buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();

                    student = new Student(name);
                    System.out.println("Student created successfully!");
                    break;

                case 2:
                    if (student == null) {
                        System.out.println("Create a student first!");
                        break;
                    }

                    System.out.print("Enter skill: ");
                    String skill = sc.nextLine();
                    student.addSkill(skill);
                    break;

                case 3:
                    if (student != null) {
                        student.viewSkills();
                    } else {
                        System.out.println("Create a student first!");
                    }
                    break;

                case 4:
                    if (student != null) {
                        student.recommendCourses();
                    } else {
                        System.out.println("Create a student first!");
                    }
                    break;

                case 5:
                    if (student == null) {
                        System.out.println("Create a student first!");
                        break;
                    }

                    System.out.print("Enter course name: ");
                    String course = sc.nextLine();
                    student.completeCourse(course);
                    break;

                case 6:
                    if (student != null) {
                        student.viewCompletedCourses();
                    } else {
                        System.out.println("Create a student first!");
                    }
                    break;

                case 7:
                    System.out.println("Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
