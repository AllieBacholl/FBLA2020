package data;

/**
 * Converts between data in the combo boxes to data in the tables/database.
 * @author Allie Bacholl
 */
public class Convert {
	
    // ******************************
    // Public Methods
    // ******************************
    /**
     * Converts the specified grade from a table to a grade as shown in the grade combo box.
     * @param tblGrade The grade of a student as shown in the tables/database.
     * @return The specified grade as shown in the grade combo box.
     */
    public static String getGradeTblToBox(String tblGrade) {
        String boxGrade = null;
        switch (tblGrade) {
            case "9":	boxGrade = "Freshman - 9th";
						break;
            case "10":  boxGrade = "Sophomore - 10th";
                        break;
            case "11":  boxGrade = "Junior - 11th";
                        break;
            case "12":  boxGrade = "Senior - 12th";
                        break;
        }
        
        return boxGrade;
    }
    
    /**
     * Converts the specified grade from a combo box to a grade as shown in the tables/database.
     * @param boxGrade The grade of a student as shown in the grade combo box.
     * @return The specified grade as shown in the tables/database.
     */
    public static String getGradeBoxToTbl(String boxGrade) {
        String tblCSA = null;
        switch (boxGrade) {
            case "Freshman - 9th":      tblCSA = "9";
                                        break;
            case "Sophomore - 10th":    tblCSA = "10";
                                        break;
            case "Junior - 11th":       tblCSA = "11";
                                        break;
            case "Senior - 12th":       tblCSA = "12";
                                        break;
        }
        
        return tblCSA;
    }
    
    /**
     * Converts the specified CSA category from a table to a CSA category as shown in the CSA combo box.
     * @param tblCSA The CSA category of a student as shown in the tables/database.
     * @return The specified CSA category as shown in the CSA combo box.
     */
    public static String getcsaTblToBox(String tblCSA) {
        String boxCSA = null;
        switch (tblCSA) {
            case "None":        boxCSA = "None";
                                break;
            case "Community":   boxCSA = "CSA Community - 50 hours";
                                break;
            case "Service":     boxCSA = "CSA Service - 200 hours";
                                break;
            case "Achievement": boxCSA = "CSA Achievement - 500 hours";
                                break;
        }
        
        return boxCSA;
    }
    
    /**
     * Converts the specified CSA category from the CSA combo box to a CSA category as shown in the tables/database.
     * @param boxCSA The CSA category of a student as shown in the CSA combo box.
     * @return The specified CSA category as shown in the tables/database.
     */
    public static String getcsaBoxToTbl(String boxCSA) {
        String tblCSA = null;
        switch (boxCSA) {
            case "None":                        tblCSA = "None";
                                                break;
            case "CSA Community - 50 hours":    tblCSA = "Community";
                                                break;
            case "CSA Service - 200 hours":     tblCSA = "Service";
                                                break;
            case "CSA Achievement - 500 hours": tblCSA = "Achievement";
                                                break;
        }
        
        return tblCSA;
    }
}
