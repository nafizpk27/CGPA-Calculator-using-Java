import java.util.Scanner;

class Course {
    private String courseName;
    private int creditHours;
    private String grade;


    public Course(String courseName, int creditHours, String grade) {
        this.courseName = courseName;
        this.creditHours = creditHours;
        this.grade = grade;
    }


    public int getCreditHours() {
        return creditHours;
    }

    public String getGrade() {
        return grade;
    }
}

public class CGPACalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of Course:");
        int numCourse = sc.nextInt();
        sc.nextLine();

        Course[] courses = new Course[numCourse];

        for (int i = 0; i< numCourse; i++) {
            System.out.println("Enter details for course " + (i + 1) + ":");
            System.out.print("Course Name: ");
            String courseName = sc.nextLine();
            System.out.print("Credit Hours: ");
            int creditHours = sc.nextInt();
            sc.nextLine(); // Consume newline
            System.out.print("Grade (A, B, C, D, F): ");
            String grade = sc.nextLine().toUpperCase();

            courses[i] = new Course(courseName, creditHours, grade);

        }
        double totalGradePoints = 0;
        int totalCreditHours = 0;

        for (Course course : courses) {
            double gradePoint = convertGradeToPoint(course.getGrade());
            totalGradePoints += gradePoint * course.getCreditHours();
            totalCreditHours += course.getCreditHours();
        }
        double cgpa = totalGradePoints / totalCreditHours;
        System.out.printf("Your CGPA is: %.2f%n", cgpa);}

        private static double convertGradeToPoint(String grade) {
            switch (grade) {
                case "A":
                    return 4.0;
                case "B":
                    return 3.0;
                case "C":
                    return 2.0;
                case "D":
                    return 1.0;
                case "F":
                    return 0.0;
                default:
                    System.out.println("Invalid grade entered. Assuming grade point as 0.0.");
                    return 0.0;
            }
        
    }

    
}
