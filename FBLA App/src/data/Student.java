package data;

/**
 * Student is used to store the data of every student in the database for easy access.
 * @author Allie Bacholl
 */
public class Student {
	
    // ******************************
    // Fields
    // ******************************
    private final String id;
    private final String firstName;
    private final String lastName;
    private final String grade;
    private final String hours;
    private final String csaCat;
	
    // ******************************
    // Public Methods
    // ******************************
    /**
     * Constructs a student with a specified ID, first name, last name, grade, service hours, and CSA category.
     * @param id The student's ID
     * @param firstName The student's first name
     * @param lastName The student's last name
     * @param grade The student's grade
     * @param hours The student's service hours
     * @param csaCat The student's CSA category
     */
    public Student(String id, String firstName, String lastName, String grade, String hours, String csaCat) {
        this.id = id;    
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
        this.hours = hours;
        this.csaCat = csaCat;
    }
    
    /**
     * Returns the ID of the student.
     * @return The student's ID
     */
    public String getID() {
        return id;
    }
    
    /**
     * Returns the first name of the student.
     * @return The student's first name
     */
    public String getFirstName() {
        return firstName;
    }
            
    /**
     * Returns the last name of the student.
     * @return The student's last name
     */
    public String getLastName() {
        return lastName;
    }
    
    /**
     * Returns the grade of the student.
     * @return The student's grade
     */
    public String getGrade() {
        return grade;
    }
    
    /**
     * Returns the service hours of the student.
     * @return The student's service hours
     */
    public String getHours() {
        return hours;
    }
    
    /**
     * Returns the CSA category of the student.
     * @return The student's CSA category
     */
    public String getCSACat() {
        return csaCat;
    }
}
