package data;

import database.DatabaseConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Refreshes the data in the student and report table model from the connected database.
 * @author Allie Bacholl
 */
public class Refresh {
	
    // ******************************
    // Fields
    // ******************************
    /* Holds values to create the student table and report table. */
    private static DefaultTableModel studentsModel;
    private static DefaultTableModel reportModel;
	
    /* Holds the values of each student object in the connected database. */
    private static ArrayList<Student> studentsArray;
	
    // ******************************
    // Public Methods
    // ******************************
    /**
     * Refreshes the data in the student array from the connected database which is used to refresh the data in the student and report table model.
     */
    public static void refreshAllData() {
        refreshArray();
        refreshModels();
    }
    
    /**
     * Returns the student ID of the specified row.
     * @param selectedRow The selected row from the student table.
     * @return The student ID of the student in the specified row.
     */
    public static int getSelectedRowID(int selectedRow) {
        Student student = studentsArray.get(selectedRow);
        int selectedRowID = Integer.parseInt(student.getID());
        return selectedRowID;
    }
    
    /**
     * Returns the student array list which contains the data of each student in the database.
     * @return The student array list
     */
    public static ArrayList<Student> getSudentsArray() {
        return studentsArray;
    }
    
    /**
     * Returns the student table model which is used to create the student table.
     * @return The student table model
     */
    public static DefaultTableModel getStudentsModel() {
        return studentsModel;
    }
    
    /**
     * Returns the report table model which is used to create the report table.
     * @return The report table model
     */
    public static DefaultTableModel getReportModel() {
        return reportModel;
    }
    
    /**
     * Sets the report table model to the specified table model.
     * @param model The table model to set the report table model to
     */
    public static void setReportModel(DefaultTableModel model) {
        reportModel = model;
    }
	
    // ******************************
    // Private Methods
    // ******************************
    /* Fills the studentsArray with the students in the connected database. */
    private static void refreshArray() {
        ResultSet rsAll = null;
        
        try {  
            DatabaseConnection.refreshConnection();
            String sqlAll = "SELECT * FROM students";
            rsAll = DatabaseConnection.createPreparedStatement(sqlAll).executeQuery();
            
            studentsArray = new ArrayList<>();
            String id;
            String fName;
            String lName;
            String grade;
            String hours;
            String csaCat;
            
            while (rsAll.next()) {
                id = rsAll.getObject(1).toString();
                fName = rsAll.getObject(2).toString();
                lName = rsAll.getObject(3).toString();
                grade = rsAll.getObject(4).toString();
                hours = rsAll.getObject(5).toString();
                csaCat = rsAll.getObject(6).toString();
                
                Student student = new Student(id, fName, lName, grade, hours, csaCat);
            
                studentsArray.add(student);
            } 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } 
        finally {
            try { if (rsAll != null) rsAll.close(); } catch (Exception e) {};
        }
    }
    
    /* Fills the students model and report model with the students in the students array. */
    private static void refreshModels() {
        int rows = studentsArray.size();
        
        Object[][] studentData = new Object[rows][6];
        for (int i = 0; i < rows; i++) {
            Student student = studentsArray.get(i);
            studentData[i][0] = Integer.parseInt(student.getID());
            studentData[i][1] = student.getFirstName();
            studentData[i][2] = student.getLastName();
            studentData[i][3] = Integer.parseInt(student.getGrade());
            studentData[i][4] = Double.valueOf(student.getHours());
            studentData[i][5] = student.getCSACat();
        }

        String[] studentCol = {"ID", "First Name", "Last Name", "Grade", "Total Hours", "CSA Category"};
        studentsModel = new DefaultTableModel(studentData, studentCol);
       
        Object[][] rptData = new Object[rows][7];
        for (int i = 0; i < rows; i++) {
            Student student = studentsArray.get(i);
            rptData[i][1] = Integer.parseInt(student.getID());
            rptData[i][2] = student.getFirstName();
            rptData[i][3] = student.getLastName();
            rptData[i][4] = Integer.parseInt(student.getGrade());
            rptData[i][5] = Double.valueOf(student.getHours());
            rptData[i][6] = student.getCSACat();
        }

        String[] rptCol = {"Print", "ID", "First Name", "Last Name", "Grade", "Total Hours", "CSA Category"};
        reportModel = new DefaultTableModel(rptData, rptCol) {
            /* Allows the user to edit the check box in the print column of the report table */
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 0;
            }
            /* Returns a boolean value for the first column, so that the first columns appears as check boxes. */
            @Override
            public Class<?> getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return Boolean.class;
                    default:
                        return String.class;
                }
            }
        } ;
    }
}
