/**
 * Class Name: Subject
 * Description: Represents a subject in Year 2 program.
 * Author: Thai Monika
 * Date: 2025-12-30
 * Version: 1.1
 */

public class Subject {

    // Constant to define maximum allowed students per subject
    // (Currently not enforced but prepared for future use)
    public static final int MAX_STUDENTS = 50;

    // Private attributes to ensure encapsulation
    private String subjectCode;
    private String subjectName;
    private int creditHour;

    /**
     * Constructor with validation to prevent invalid object creation
     */
    public Subject(String subjectCode, String subjectName, int creditHour) {

        // Validate subject code
        if (subjectCode == null || subjectCode.trim().isEmpty()) {
            throw new IllegalArgumentException("Subject code cannot be null or empty.");
        }

        this.subjectCode = subjectCode;
        setSubjectName(subjectName);     // reuse setter validation
        setCreditHour(creditHour);       // reuse setter validation
    }

    // Getter for subject code
    public String getSubjectCode() {
        return subjectCode;
    }

    // Getter for subject name
    public String getSubjectName() {
        return subjectName;
    }

    // Getter for credit hour
    public int getCreditHour() {
        return creditHour;
    }

    /**
     * Setter with validation for subject name
     */
    public void setSubjectName(String subjectName) {
        if (subjectName == null || subjectName.trim().isEmpty()) {
            throw new IllegalArgumentException("Subject name cannot be null or empty.");
        }
        this.subjectName = subjectName;
    }

    /**
     * Setter with validation to prevent invalid credit hour values
     */
    public void setCreditHour(int creditHour) {
        if (creditHour <= 0) {
            throw new IllegalArgumentException("Credit hour must be greater than zero.");
        }
        this.creditHour = creditHour;
    }

    /**
     * Override toString() for better debugging and readability
     */
    @Override
    public String toString() {
        return "Subject{" +
                "subjectCode='" + subjectCode + '\'' +
                ", subjectName='" + subjectName + '\'' +
                ", creditHour=" + creditHour +
                '}';
    }
}
