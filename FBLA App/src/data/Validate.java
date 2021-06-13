package data;

import java.util.ArrayList;

/**
 * Checks specified student ID, names, grade, and CSA category.
 * @author Allie Bacholl
 */
public class Validate {
	
    // ******************************
    // Public Methods
    // ******************************
    /**
     * Checks a specified ID to ensure that it can be entered into the database without error.
     * @param idStr The ID to check
     * @throws Exception If specified ID is not a positive integer that is less than 11 digits long
     */
    public static void checkID(String idStr) throws Exception {
        int id; 
        
        if (!(idStr.isEmpty())) {
            if (idStr.length() < 10) {
                if (isInt(idStr)) {   
                    id = Integer.valueOf(idStr);
                    /* Throws exception when the string entered in the ID Text Field is negative. */
                    if (id <= 0) {
                        throw new Exception("Please enter a positive ID in the ID text fields."); 
                    }
                } 
                /* Throws exception when the string entered in the ID text field is not an integer. */
                else {
                    throw new Exception("Please enter an integer in the ID text field. (no characters)"); 
                }
            } 
            /* Throws exception when the string entered in the ID text field is greater than or equal to 11 characters long. */
            else {
                throw new Exception("Please enter an ID less than 10 digits long."); 
            }
        }
	/* Throws exception when nothing is entered in the ID text field. */
        else {
            throw new Exception("Please enter an ID in the ID text fields."); 
        }
    }
    
    /**
     * Checks if the specified ID is unique because the ID is the primary key of the database and needs to be unique.
     * @param newID The new entered ID to check
     * @param currentID The current ID of the student
     * @throws Exception If the ID of the specified student matches the ID of another student
     */
    public static void checkUniqueID(String newID, String currentID) throws Exception {
        ArrayList<Student> studentsArray = Refresh.getSudentsArray(); 
        Student student;
        
        for (int i = 0; i < studentsArray.size(); i++) {
            student = studentsArray.get(i);
            /* 
             * Checks if the new and current ID are equal.
             * If the ID's are not equal, the newID is checked 
             * to see if it matches any of the other students' IDs.
             */
            if (!newID.equals(currentID)) {
                if (newID.equals(student.getID())) {
					String name = student.getFirstName() + " " + student.getLastName();
                    throw new Exception("Please enter a unique ID. (Matched "+ name +"'s ID)");
                }
            }
        }
    }
     
    /**
     * Checks if the specified hour can be used to edit the hours in the database without error.
     * @param hourStr The hour to check
     * @throws Exception If the specified hour is not a positive number with less than 6 digits before the decimal place and 4 digits after
     */
    public static void checkHour(String hourStr) throws Exception {
        double num; 
        if (!(hourStr.isEmpty())) {
            if (isDouble(hourStr)) { 
                if (hourStr.indexOf('.') == -1) {
                    hourStr = hourStr + ".0";
                }
                int decimalIndex = hourStr.indexOf('.');
                int decimalPlaces = hourStr.length() - decimalIndex - 1;
 
                /* Throws exception when the number entered in the hours text field is negative. */
                if (decimalPlaces <=3 && decimalIndex <= 5) {
                    num = Double.valueOf(hourStr);
                    if (num < 0) {
                        throw new Exception("Please enter a positive number in the hours text field."); 
                    }
                }
                /* Throws exception when the number entered in the hours text field has more than 5 digits befor the decimal place and 3 digits after the decimal place. */
                else {
                    throw new Exception("Entered hours cannot have more than 5 digits\nbefore the decimal place and 3 digits after the decimal place."); 
                }
            }
            /* Throws exception when anything other than a decimal number is entered in the hours text field. */
            else {
                throw new Exception("Please enter a number in the hours text field. (No characters)"); 
            }
        }
        /* Throws exception when nothing is entered in the hours text field. */
        else {
            throw new Exception("Please enter a number in the hours text field."); 
        }
    }
    
    /**
     * Checks the specified name to ensure it can be entered into the database without error.
     * @param name Name of student to check
     * @param nameType Name type, either first or last
     * @throws Exception If the name is more than 44 characters long and contains a digit
     */
    public static void checkName(String name, String nameType) throws Exception{
        if (!(name.isEmpty())) {
            if (name.length() < 44) {
                /* Throws exception when the name entered in the hours text field contains digits. */
                if (!(isName(name))) {
                    throw new Exception("Please enter a " + nameType + " name that contains no digits."); 
                }
            } 
            /* Throws exception when the name entered in the hours text field is greater than 44 characters long. */
            else {
                throw new Exception("Please enter a " + nameType + " name that is less than 44 letters long."); 
            }
        }
        /* Throws exception when nothing is entered in the name text field. */
        else {
            throw new Exception("Please enter a " + nameType + " name in the " + nameType + " name text fields."); 
        }
    }
    
    /**
     * Checks the specified grade to ensure it can be entered into the database without error.
     * @param grade The grade of the student to check
     * @throws Exception If the specified grade is not 9, 10, 11, or 12
     */
    public static void checkGrade(String grade) throws Exception{
        if (null == grade) {
            throw new Exception("Please a valid grade into the table. (9, 10, 11, or 12)");
        }
        else switch (grade) {
            case "9":
                break;
            case "10":
                break;
            case "11":
                break;
            case "12":
                break;
            default:
                throw new Exception("Please a valid grade into the table. (9, 10, 11, or 12)"); 
        }
    }

    /**
     * Checks the specified CSA category to ensure it can be entered into the database without error.
     * @param csaCat The CSA category of the student to check
     * @throws Exception If the specified CSA category is not none, community, service, or achievement
     */
    public static void checkCSA(String csaCat) throws Exception {
        if ("None".equalsIgnoreCase(csaCat)) {
        }
        else if ("Community".equalsIgnoreCase(csaCat)) {
        }
        else if ("Service".equalsIgnoreCase(csaCat)) {
        }
        else if ("Achievement".equalsIgnoreCase(csaCat)) {
        }
        else {
            throw new Exception("Please a valid CSA category into the table. (None, Community, Service, or Achievement)"); 
        }
    }
	
    // ******************************
    // Private Methods
    // ******************************
    /**
     * Checks the specified string and returns true if it is only composed of digits.
     * @param str The string that is check to see if it is only composed of digits.
     * @return Returns true if the string is only composed of digits; otherwise, it returns false.
     */
    private static boolean isInt(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i)) == false) {
                return false;
            }
        }    
        
        return true;
    }
    
    /**
     * Checks the specified string and returns true if it is a double.
     * @param str The string that is check to see if it is only composed of digits and less than one period.
     * @return Returns true if the string is only composed of digits and less than one period; otherwise, it returns false.
     */
    private static boolean isDouble(String str) {
	int periodCount = 0;
        for (int i = 0; i < str.length(); i++) {
            if ((Character.isDigit(str.charAt(i)) == false)) {
				if (false == (str.charAt(i) == '.')) {
					return false;
				}
                periodCount++;
            }  
        }  
		
        return periodCount <= 1;
    }
	
    /**
     * Checks the specified string and returns true if it does not contain digits.
     * @param name The string that is check to see if it does not contain digits.
     * @return Returns true if the name does not contain digits; otherwise, it returns false.
     */
    private static boolean isName(String name) {
        for (int i = 0; i < name.length(); i++) {
            if (Character.isDigit(name.charAt(i)) == true) {
                return false;
            }
        }    
        
        return true;
    }
}
