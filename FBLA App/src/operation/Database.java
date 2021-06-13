package operation;

import database.DatabaseConnection;
import data.Refresh;
import data.Student;
import data.Validate;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;

/**
 * Preforms operations for the students' data tab.
 * @author Allie Bacholl
 */
public class Database {
    
    // ******************************
    // Fields
    // ******************************
    private static final String NOROWERROR = "Please select a row to edit.";
    private static ArrayList<Student> studentsArray;
    
    // ******************************
    // Public Methods
    // ******************************
    /**
     * Adds, subtracts, or sets the specified hours to/from the student at the specified row in the database.
     * @param hoursChangeStr The hour amount to update
     * @param selectedRow The selected table row
     * @param operation The operation to be performed, can be + (add), - (subtract), or set
     */
    public static void updateHours(String hoursChangeStr, int selectedRow, String operation) {
        try {
            if (selectedRow == -1) {
                throw new Exception(NOROWERROR);
            }

            studentsArray = Refresh.getSudentsArray();            
            Student student = studentsArray.get(selectedRow);
            
            double hoursCurrent = Double.valueOf(student.getHours());
            double hoursChange;
            double hours = 0;

            Validate.checkHour(hoursChangeStr);
            hoursChange = Double.valueOf(hoursChangeStr);
            
                
            switch (operation) {
                case "+" :
                    hours = hoursCurrent + hoursChange;
                    break;
                case "-" :
                    if (hoursChange > hoursCurrent) {
                        throw new Exception("Inputed hours is greater than current hours. Cannot have negative service hours.");
                    }
                    else {
                        hours = hoursCurrent - hoursChange;
                        break;
                    }
                case "set" :
                    hours = hoursChange;
                    break;
            }
            
            String studentID = student.getID();

            DatabaseConnection.refreshConnection();
            String sql = "UPDATE students SET `Total Hours`='"+hours+"' WHERE ID='"+Integer.parseInt(studentID)+"'";  
            DatabaseConnection.createPreparedStatement(sql).executeUpdate();
            JOptionPane.showMessageDialog(null, "Hours Updated");

            checkCSACat(Integer.parseInt(studentID), student.getFirstName(), student.getLastName(), hours, student.getCSACat());
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    /**
     * Updates the database at the specified table row from the data entered in the text fields and combo boxes.
     * @param idStr The ID to change the ID at the specified row to
     * @param fName The first name to change the fist name at the specified row to
     * @param lName The last name to change the last name at the specified row to
     * @param gradeStr The grade to change the grade at the specified row
     * @param hoursStr The hour to change the hour at the specified row to
     * @param csaCat The CSA category to change the CSA category at the specified row
     * @param selectedRow The table row to update
     */
    public static void updateDB(String idStr, String fName, String lName, String gradeStr, String hoursStr, String csaCat, int selectedRow) {     
        try {
            
            checkEnteredStr(idStr, fName, lName, gradeStr, hoursStr, csaCat, selectedRow, false);
           
            int selectedRowID = Refresh.getSelectedRowID(selectedRow);
            int id = Integer.valueOf(idStr);
            int grade = Integer.parseInt(gradeStr);

            double hours = Double.valueOf(hoursStr);
            
            updateSQL(id, fName, lName, grade, hours, csaCat, selectedRowID);
            
            checkCSACat(id, fName, lName, hours, csaCat);
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    /**
     * Updates the database at the specified table row from the data entered directly into the student table.
     * @param idStr The ID to change the ID at the specified row to
     * @param fName The first name to change the fist name at the specified row to
     * @param lName The last name to change the last name at the specified row to
     * @param gradeStr The grade to change the grade at the specified row to
     * @param hoursStr The hour to change the hour at the specified row to
     * @param csaCat The CSA category to change the CSA category at the specified row to
     * @param selectedRow The table row to update
     */
    public static void updateDBFromTbl(String idStr, String fName, String lName, String gradeStr, String hoursStr, String csaCat, int selectedRow) {
        try {
            checkEnteredStr(idStr, fName, lName, gradeStr, hoursStr, csaCat, selectedRow, false);
            
            int currentID = Refresh.getSelectedRowID(selectedRow);
            int id = Integer.valueOf(idStr);
            int grade = Integer.parseInt(gradeStr);
            double hours = Double.valueOf(hoursStr);
            
            updateSQL(id, fName, lName, grade, hours, csaCat, currentID);

            checkCSACat(id, fName, lName, hours, csaCat);
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    /**
     * Inserts a new row into the database with specified student data.
     * @param idStr ID of the student to insert, must be unique
     * @param fName First name of the student to insert
     * @param lName Last name of the student to insert
     * @param gradeStr Grade of the student to insert
     * @param hoursStr Hours of the student to insert
     * @param csaCat CSA category of the student to insert
     */
    public static void insertDB(String idStr, String fName, String lName, String gradeStr, String hoursStr, String csaCat) {
        try {  
            checkEnteredStr(idStr, fName, lName, gradeStr, hoursStr, csaCat, 1, true);
            
            int id = Integer.valueOf(idStr); 
            int grade = Integer.parseInt(gradeStr);
            
            DatabaseConnection.refreshConnection();
            String sql = "INSERT INTO students VALUES ('"+id+"','"+fName+"','"+lName+"','"+grade+"','"+0+"','"+csaCat+"')";
            DatabaseConnection.createPreparedStatement(sql).executeUpdate();
            JOptionPane.showMessageDialog(null, "Row Added");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    /**
     * Deletes the specified table row from the database.
     * @param selectedRow Table row to delete
     */
    public static void deleteSQL(int selectedRow) {
        try {

            DatabaseConnection.refreshConnection();

            if (selectedRow == -1) {
                throw new Exception(NOROWERROR);
            }
            
            int selectedRowID = Refresh.getSelectedRowID(selectedRow);
            
            Object[] options = {"Yes", "No"};
            int answer = JOptionPane.showOptionDialog(null, "Are you sure you want to delete this student (ID: "+selectedRowID+")?", "Confirm Deletion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            
            if (answer == 0) {
                String sql = "DELETE FROM students WHERE ID='"+selectedRowID+"'";
                DatabaseConnection.createPreparedStatement(sql).executeUpdate();
                JOptionPane.showMessageDialog(null, "Row Deleted");
            }
            else {
                JOptionPane.showMessageDialog(null, "Row Not Deleted");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    /**
     * Creates a copy of the connected database at the location the user specifies from the file chooser message dialog.
     */
    public static void copyDB() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choose Where to Save a Copy of the Database"); 
        fileChooser.setSelectedFile(new File("students_copy.db"));
 
        int userSelection = fileChooser.showSaveDialog(null);
 
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            
            try {
                if (selectedFile.createNewFile()) {
                    InputStream is = null;
                    OutputStream os = null;
                    try {
                        is = new FileInputStream(DatabaseConnection.getDBLocation());
                        os = new FileOutputStream(selectedFile.getAbsolutePath());
                        byte[] buffer = new byte[1024];
                        int length;
                        while ((length = is.read(buffer)) > 0) {
                            os.write(buffer, 0, length);
                        }
                    } finally {
                        if (is != null) {
                            is.close();
                        }
                        if (os != null) {
                            os.close();
                        }
                    }
                    JOptionPane.showMessageDialog(null, "File Created");
                    
                    Object[] options = {"Yes", "No"};
                    int answer;
        
                    answer = JOptionPane.showOptionDialog(null, "Would you like to change the automatic save location to the new database?", "Change Database Save", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                    if (answer == 0) {   
                        String selectedFileStr = selectedFile.toString();
                        saveDBLocation(selectedFileStr);
                    }
                }
                    
                else {
                    JOptionPane.showMessageDialog(null, "File Already Exists");
                }
                    
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex);
            } 
        }
    }
    
    /**
     * Sets the location of the connected database to the location the user specifies from the file chooser message dialog.
     */
    public static void setDBLocation() {
        final JFileChooser fc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int returnVal = fc.showOpenDialog(null); 
        
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            String selectedFile = fc.getSelectedFile().toString();
            
            saveDBLocation(selectedFile);
        }
    }
    
    // ******************************
    // Private Methods
    // ******************************
    /* Updates the specified row with the specified data. */
    private static void updateSQL(int id, String fName, String lName, int grade, double hours, String csaCat, int selectedRowID) {
        try {
            DatabaseConnection.refreshConnection();
            String sql = "UPDATE students SET ID ='"+id+"' ,`First Name`='"+fName+"' ,`Last Name`='"+lName+"' ,Grade='"+grade+"' ,`Total Hours`='"+hours+"' ,`CSA Category`='"+csaCat+"' WHERE ID='"+selectedRowID+"'";
            DatabaseConnection.createPreparedStatement(sql).executeUpdate();
            JOptionPane.showMessageDialog(null, "Row Updated");
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /* 
     * Checks to make sure the student's hours matches their CSA category. 
     * If they do not match, the user is asked if they would like to change 
     * the student's CSA category to match. 
     */
    private static void checkCSACat(int id, String fName, String lName, double hours, String csaCat) {
        String studentName = fName + " " + lName;
        Object[] options = {"Yes", "No"};
        int answer = 1;
        String changeTo = null;
        String title = "Change CSA Category";
        
        String question = studentName + "'s (ID: " + id + ") total hours ("+hours+") does not match their CSA category ("+csaCat+").\nWould you like to change their CSA category to ";
        
        if (!("None".equals(csaCat)) && hours < 50) {
            changeTo = "None";
            question += changeTo + "?";
            answer = JOptionPane.showOptionDialog(null, question, title, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        }  
        else if (!"Community".equals(csaCat) && (hours < 200 && hours >= 50)) {
            changeTo = "Community";
            question += changeTo + "?";
            answer = JOptionPane.showOptionDialog(null, question, title, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        }
        else if (!"Service".equals(csaCat) && (hours < 500 && hours >= 200)) {
            changeTo = "Service";
            question += changeTo + "?";
            answer = JOptionPane.showOptionDialog(null, question, title, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        }
        else if (!"Achievement".equals(csaCat) && hours >= 500) {
            changeTo = "Achievement";
            question += changeTo + "?";
            answer = JOptionPane.showOptionDialog(null, question, title, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        }
        
        if (answer == 0) {    
            try {
                DatabaseConnection.refreshConnection(); 
                String sql = "UPDATE students SET `CSA Category`='"+changeTo+"' WHERE ID='"+id+"'";
                DatabaseConnection.createPreparedStatement(sql).executeUpdate();    
                JOptionPane.showMessageDialog(null, "CSA Category Updated"); 
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /* Checks the entered strings to ensure they can be entered into the database without error. */
    private static void checkEnteredStr (String id, String fName, String lName, String grade, String hours, String csaCat, int selectedRow, boolean isInsert) throws Exception {
        try {
            Validate.checkID(id);
            Validate.checkName(fName, "first");
            Validate.checkName(lName, "last");
            Validate.checkGrade(grade);
            Validate.checkHour(hours);
            Validate.checkCSA(csaCat);
            String currentID;
            
            if (selectedRow == -1) {
                throw new Exception(NOROWERROR);
            }
            
            if (isInsert)
                currentID = "";
            else {
                currentID = Integer.toString(Refresh.getSelectedRowID(selectedRow));
            }
            Validate.checkUniqueID(id, currentID);
            
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    /* Changes the saved database file to the specified file. */
    private static void saveDBLocation(String selectedFile) {
        try (PrintWriter out = new PrintWriter(".\\src\\Database\\dbLocation.txt")) {
            if (!(selectedFile.endsWith("db"))) {
                throw new Exception ("Please select a database file.");
            }
            
            out.print(selectedFile);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
}
