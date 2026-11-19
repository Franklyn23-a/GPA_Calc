
public class Course {

    private final String courseCode;
    private String courseTitle;
    private int creditHours;
    private String instructor;
    private String department;

    // Constructor
    public Course(String courseCode, String courseTitle,
                  int creditHours, String instructor,
                  String department) {

        if (courseCode == null || courseCode.isBlank()) {
            throw new IllegalArgumentException("Course code is required.");
        }

        this.courseCode = courseCode;

        setCourseTitle(courseTitle);
        setCreditHours(creditHours);
        setInstructor(instructor);
        setDepartment(department);
    }

    // Getters
    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public String getInstructor() {
        return instructor;
    }

    public String getDepartment() {
        return department;
    }

    // Setters
    public void setCourseTitle(String courseTitle) {
        if (courseTitle == null || courseTitle.isBlank()) {
            throw new IllegalArgumentException("Course title is required.");
        }
        this.courseTitle = courseTitle;
    }

    public void setCreditHours(int creditHours) {
        if (creditHours <= 0) {
            throw new IllegalArgumentException(
                "Credit hours must be positive."
            );
        }
        this.creditHours = creditHours;
    }

    public void setInstructor(String instructor) {
        if (instructor == null || instructor.isBlank()) {
            throw new IllegalArgumentException("Instructor is required.");
        }
        this.instructor = instructor;
    }

    public void setDepartment(String department) {
        if (department == null || department.isBlank()) {
            throw new IllegalArgumentException("Department is required.");
        }
        this.department = department;
    }

    // Display course details
    public void displayCourseDetails() {

        System.out.println("Course Code: " + courseCode);
        System.out.println("Course Title: " + courseTitle);
        System.out.println("Credit Hours: " + creditHours);
        System.out.println("Instructor: " + instructor);
        System.out.println("Department: " + department);
    }

    @Override
    public String toString() {
        return courseCode + " - " + courseTitle
                + " (" + creditHours + " credit hours)";
    }
}
