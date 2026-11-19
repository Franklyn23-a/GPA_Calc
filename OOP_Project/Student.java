
import java.util.ArrayList;

public class Student extends Person {

    private final String studentId;
    private String major;
    private int level;

    private ArrayList<Semester> semesters;

    // Constructor
    public Student(String name, String email,
                   String studentId, String major, int level) {

        super(name, email);

        if (studentId == null || studentId.isBlank()) {
            throw new IllegalArgumentException("Student ID is required.");
        }

        this.studentId = studentId;
        this.semesters = new ArrayList<>();

        setMajor(major);
        setLevel(level);
    }

    // Getters
    public String getStudentId() {
        return studentId;
    }

    public String getMajor() {
        return major;
    }

    public int getLevel() {
        return level;
    }

    public ArrayList<Semester> getSemesters() {
        return new ArrayList<>(semesters);
    }

    // Setters
    public void setMajor(String major) {
        if (major == null || major.isBlank()) {
            throw new IllegalArgumentException("Programme is required.");
        }
        this.major = major;
    }

    public void setLevel(int level) {
        if (level < 1 || level > 4) {
            throw new IllegalArgumentException(
                "Level must be between 1 and 4."
            );
        }
        this.level = level;
    }

    // Add a semester
    public void addSemester(Semester semester) {

        if (semester == null) {
            throw new IllegalArgumentException("Semester cannot be null.");
        }

        if (findSemester(semester.getSemesterId()) != null) {
            throw new IllegalArgumentException("Semester already exists.");
        }

        semesters.add(semester);
    }

    // Find a semester
    public Semester findSemester(String semesterId) {

        for (Semester semester : semesters) {

            if (semester.getSemesterId().equalsIgnoreCase(semesterId)) {
                return semester;
            }
        }

        return null;
    }

    // Remove a semester
    public boolean removeSemester(String semesterId) {

        Semester semester = findSemester(semesterId);

        if (semester == null) {
            return false;
        }

        semesters.remove(semester);
        return true;
    }

    // Display student information
    @Override
    public void introduce() {

        super.introduce();

        System.out.println("Student ID: " + studentId);
        System.out.println("Programme: " + major);
        System.out.println("Academic Level: " + level);
    }

    // Display academic record
    public void displayAcademicRecord() {

        System.out.println("\n========== STUDENT ACADEMIC RECORD ==========");

        introduce();

        if (semesters.isEmpty()) {
            System.out.println("No semesters registered.");
            return;
        }

        for (Semester semester : semesters) {
            semester.displaySemesterDetails();
        }
    }
}
