
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        try {

            System.out.println(" ASHESI STUDENT MANAGEMENT SYSTEM");
            System.out.println("======================================");

            // STEP 1: STUDENT REGISTRATION

            System.out.println("\n STUDENT REGISTRATION");

            System.out.print("Enter full name: ");
            String name = input.nextLine();

            System.out.print("Enter email: ");
            String email = input.nextLine();

            System.out.print("Enter student ID: ");
            String studentId = input.nextLine();

            System.out.print("Enter programme: ");
            String major = input.nextLine();

            int level = readInt(input, "Enter academic level (1-4): ");

            Student student = new Student(
                    name, email, studentId, major, level
            );

            System.out.println("\nStudent registered successfully!");


            // STEP 2: SEMESTER REGISTRATION

            System.out.println("\n===== SEMESTER REGISTRATION =====");

            System.out.print("Enter semester ID: ");
            String semesterId = input.nextLine();

            System.out.print("Enter semester name: ");
            String semesterName = input.nextLine();

            System.out.print("Enter academic year: ");
            String academicYear = input.nextLine();

            System.out.print("Enter start date (YYYY-MM-DD): ");
            LocalDate startDate = LocalDate.parse(input.nextLine());

            System.out.print("Enter end date (YYYY-MM-DD): ");
            LocalDate endDate = LocalDate.parse(input.nextLine());

            Semester semester = new Semester(
                    semesterId,
                    semesterName,
                    academicYear,
                    startDate,
                    endDate
            );

            student.addSemester(semester);

            System.out.println("\nSemester created successfully!");


            // STEP 3: COURSE REGISTRATION

            System.out.println("\n COURSE REGISTRATION ");

            int numberOfCourses = readInt(
                    input, "How many courses do you want to register? "
            );

            for (int i = 0; i < numberOfCourses; i++) {

                System.out.println("\nCOURSE " + (i + 1));

                System.out.print("Enter course code: ");
                String code = input.nextLine();

                System.out.print("Enter course title: ");
                String title = input.nextLine();

                int credits = readInt(input, "Enter credit hours: ");

                System.out.print("Enter instructor name: ");
                String instructor = input.nextLine();

                System.out.print("Enter department: ");
                String department = input.nextLine();

                Course course = new Course(
                        code,
                        title,
                        credits,
                        instructor,
                        department
                );

                semester.addCourse(course);

                System.out.println("Course registered successfully!");
            }


            // STEP 4: DISPLAY STUDENT INFORMATION

            System.out.println("\n\n======================================");
            System.out.println(" REGISTRATION SUMMARY");
            System.out.println("======================================");

            student.displayAcademicRecord();

            System.out.println("\nTotal registered credit hours: "
                    + semester.calculateTotalCreditHours());

            System.out.println("\nRegistration completed successfully!");

        } catch (IllegalArgumentException e) {

            System.out.println("\nInput error: " + e.getMessage());

        } catch (Exception e) {

            System.out.println("\nSomething went wrong: "
                    + e.getMessage());

        } finally {

            input.close();
        }
    }

    // Helper method for reading integer input
    private static int readInt(Scanner input, String message) {

        while (true) {

            System.out.print(message);

            try {
                return Integer.parseInt(input.nextLine());

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid whole number.");
            }
        }
    }
}
