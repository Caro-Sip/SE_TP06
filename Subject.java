public class Subject {

    
    public static final int MAX_STUDENTS = 50;

    
    public String subjectCode;
    public String subjectName;
    public int creditHour;

    
    public Subject(String subjectCode, String subjectName, int creditHour) {
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
        this.creditHour = creditHour;
    }

    
    public String getSubjectCode() {
        return subjectCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public int getCreditHour() {
        return creditHour;
    }

    
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public void setCreditHour(int creditHour) {
        this.creditHour = creditHour;
    }

    

    public String toString() {
        return subjectCode + " - " + subjectName + " (" + creditHour + ")";
    }
}
