
import java.time.LocalDate;
import java.util.ArrayList;

public class Semester {

    private final String semesterId;
    private String semesterName;
    private String academicYear;
    private LocalDate startDate;
    private LocalDate endDate;

    private ArrayList<CourseEnrollment> enrollments;

    // Constructor
    public Semester(String semesterId, String semesterName,
                    String academicYear, LocalDate startDate,
                    LocalDate endDate) {

        if (semesterId == null || semesterId.isBlank()) {
            throw new IllegalArgumentException("Semester ID is required.");
        }

        this.semesterId = semesterId;
        this.enrollments = new ArrayList<>();

        setSemesterName(semesterName);
        setAcademicYear(academicYear);
        setDates(startDate, endDate);
    }

    // Getters
    public String getSemesterId() {
        return semesterId;
    }

    public String getSemesterName() {
        return semesterName;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public ArrayList<CourseEnrollment> getEnrollments() {
        return new ArrayList<>(enrollments);
    }

    // Setters
    public void setSemesterName(String semesterName) {
        if (semesterName == null || semesterName.isBlank()) {
            throw new IllegalArgumentException("Semester name is required.");
        }
        this.semesterName = semesterName;
    }

    public void setAcademicYear(String academicYear) {
        if (academicYear == null || academicYear.isBlank()) {
            throw new IllegalArgumentException("Academic year is required.");
        }
        this.academicYear = academicYear;
    }

    public void setDates(LocalDate startDate, LocalDate endDate) {

        if (startDate == null || endDate == null) {
            throw new IllegalArgumentException("Both dates are required.");
        }

        if (!endDate.isAfter(startDate)) {
            throw new IllegalArgumentException(
                "End date must be after start date."
            );
        }

        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Add course
    public void addCourse(Course course) {

        if (course == null) {
            throw new IllegalArgumentException("Course cannot be null.");
        }

        if (findEnrollment(course.getCourseCode()) != null) {
            throw new IllegalArgumentException(
                "This course is already registered."
            );
        }

        enrollments.add(new CourseEnrollment(course));
    }

    // Find enrollment
    public CourseEnrollment findEnrollment(String courseCode) {

        if (courseCode == null) {
            return null;
        }

        for (CourseEnrollment enrollment : enrollments) {

            if (enrollment.getCourse().getCourseCode()
                    .equalsIgnoreCase(courseCode)) {
                return enrollment;
            }
        }

        return null;
    }

    // Find course
    public Course findCourse(String courseCode) {

        CourseEnrollment enrollment = findEnrollment(courseCode);

        if (enrollment == null) {
            return null;
        }

        return enrollment.getCourse();
    }

    // Remove course
    public boolean removeCourse(String courseCode) {

        CourseEnrollment enrollment = findEnrollment(courseCode);

        if (enrollment == null) {
            return false;
        }

        enrollments.remove(enrollment);
        return true;
    }

    // Update course information
    public void updateCourse(String courseCode,
                             String title,
                             int credits,
                             String instructor,
                             String department) {

        Course course = findCourse(courseCode);

        if (course == null) {
            throw new IllegalArgumentException("Course not found.");
        }

        course.setCourseTitle(title);
        course.setCreditHours(credits);
        course.setInstructor(instructor);
        course.setDepartment(department);
    }

    // Record final course result
    // Member 2 can call this after calculating the grade
    public void recordCourseResult(String courseCode,
                                   double score,
                                   String grade) {

        CourseEnrollment enrollment = findEnrollment(courseCode);

        if (enrollment == null) {
            throw new IllegalArgumentException("Course not found.");
        }

        enrollment.recordFinalResult(score, grade);
    }

    // Calculate total credit hours
    public int calculateTotalCreditHours() {

        int total = 0;

        for (CourseEnrollment enrollment : enrollments) {
            total += enrollment.getCourse().getCreditHours();
        }

        return total;
    }

    // Get all courses
    public ArrayList<Course> getCourses() {

        ArrayList<Course> courses = new ArrayList<>();

        for (CourseEnrollment enrollment : enrollments) {
            courses.add(enrollment.getCourse());
        }

        return courses;
    }

    // Display courses
    public void displayCourses() {

        if (enrollments.isEmpty()) {
            System.out.println("No courses registered.");
            return;
        }

        for (CourseEnrollment enrollment : enrollments) {
            System.out.println(enrollment);
        }
    }

    // Display semester details
    public void displaySemesterDetails() {

        System.out.println("\n========== SEMESTER DETAILS ==========");

        System.out.println("Semester ID: " + semesterId);
        System.out.println("Semester: " + semesterName);
        System.out.println("Academic Year: " + academicYear);
        System.out.println("Start Date: " + startDate);
        System.out.println("End Date: " + endDate);

        System.out.println("\nRegistered Courses:");

        displayCourses();

        System.out.println("Total Credit Hours: "
                + calculateTotalCreditHours());
    }
}
