
public class CourseEnrollment {

    private final Course course;

    // Results are initially unavailable
    private Double finalScore;
    private String finalGrade;

    // Constructor
    public CourseEnrollment(Course course) {

        if (course == null) {
            throw new IllegalArgumentException("Course cannot be null.");
        }

        this.course = course;
        this.finalScore = null;
        this.finalGrade = null;
    }

    // Getters
    public Course getCourse() {
        return course;
    }

    public Double getFinalScore() {
        return finalScore;
    }

    public String getFinalGrade() {
        return finalGrade;
    }

    // Record results after assessment calculations
    public void recordFinalResult(double score, String grade) {

        if (score < 0 || score > 100) {
            throw new IllegalArgumentException(
                "Score must be between 0 and 100."
            );
        }

        if (grade == null || grade.isBlank()) {
            throw new IllegalArgumentException("Grade is required.");
        }

        this.finalScore = score;
        this.finalGrade = grade;
    }

    @Override
    public String toString() {

        String result = course.toString();

        if (finalGrade == null) {
            result += " | Result pending";
        } else {
            result += " | Score: " + finalScore
                    + " | Grade: " + finalGrade;
        }

        return result;
    }
}
