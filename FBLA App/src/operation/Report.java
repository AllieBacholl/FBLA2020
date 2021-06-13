package operation;

import data.Refresh;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Preforms operations for the report tab.
 * @author Allie Bacholl
 */
public class Report {
	
    // ******************************
    // Fields
    // ******************************
    /* The table models used to build the report table and print table for the GUI. */
    private static DefaultTableModel rptModel;
    private static DefaultTableModel printModel = Refresh.getReportModel();
	
    /* The report model index of each column selected by the user. It is use to create the print model. */
    private static ArrayList<Integer> printColumns;
	
    // ******************************
    // Public Methods
    // ******************************
    /**
     * Returns the print table model which is used to create the print table.
     * @return The print table model
     */
    public static DefaultTableModel getPrintModel() {
        return printModel;
    }
    
    /**
     * Sets the print table model with selected columns and rows.
     * @param id If the ID column should be included in the print table model
     * @param fName If the first name column should be included in the print table model
     * @param lName If the last name column should be included in the print table model
     * @param grade If the grade column should be included in the print table model
     * @param hours If the hours column should be included in the print table model
     * @param csaCat If the CSA column should be included in the print table model
     * @throws Exception If no column or row is selected
     */
    public static void setPrintModel(boolean id, boolean fName, boolean lName, boolean grade, boolean hours, boolean csaCat) throws Exception { 
        printModel = new DefaultTableModel();
        rptModel = Refresh.getReportModel();
        printColumns = new ArrayList<>();
        int selectionCount = 0;

        isRowSelected(); 
            
        if (id == true) {
            setPrintModelColumn("ID", 1);
            selectionCount++;
        }
        if (fName == true) {
            setPrintModelColumn("First Name", 2);
            selectionCount++;
        }
        if (lName == true) {
            setPrintModelColumn("Last Name", 3);
            selectionCount++;
        }
        if (grade == true) {
            setPrintModelColumn("Grade", 4);
            selectionCount++;
        }
        if (hours == true) {
            setPrintModelColumn("Hours", 5);
            selectionCount++;
        }
        if (csaCat == true) {
            setPrintModelColumn("CSA", 6);
            selectionCount++;
        }
           
        if (selectionCount == 0) {
            throw new Exception("Please select a check box for which columns to print.");
        }
            
        setPrintModelRows();
    }
    
    /**
     * Selects or deselects all rows of the report table.
     * @param toSelect If true, all rows will be selected. If false, all rows will be deselected 
     */
    public static void selectAll(boolean toSelect) {
        rptModel = Refresh.getReportModel();
        
        for (int i = 0; i < rptModel.getRowCount(); i++) {
            rptModel.setValueAt(toSelect, i, 0);
        }
        
        Refresh.setReportModel(rptModel);
    }
    
    /**
     * Filters data based on what categories are selected. If "One" is selected, at least one category needs to be selected. If "Both" is selected, only one grade and one CSA category can be selected.
     * @param selectionType "One" or "Both"
     * @param freshman If the grade freshman is selected for filtering
     * @param sophomore If the grade sophomore is selected for filtering
     * @param junior If the grade junior is selected for filtering
     * @param senior If the grade senior is selected for filtering
     * @param none If the CSA category none is selected for filtering
     * @param service If the CSA category service is selected for filtering
     * @param community If the CSA category community is selected for filtering
     * @param achievement If the CSA category achievement is selected for filtering
     */
    public static void selection(String selectionType, boolean freshman, boolean sophomore, boolean junior, boolean senior, boolean none, boolean service, boolean community, boolean achievement) {
        ArrayList<String> grade = new ArrayList<>();
	ArrayList<String> csaCat = new ArrayList<>();
        
        try {
            /* Adds selected grades to the grade array list. */
            if (freshman == true) {
                grade.add("9");
            }
            if (sophomore == true) {
                grade.add("10");
            }
            if (junior == true) {
                grade.add("11");
            }
            if (senior == true) {
                grade.add("12");
            }
			
            /* Adds selected csaCat to the scaCat array list. */          
            if (none == true) {
                csaCat.add("None");
            }
            if (service == true) {
                csaCat.add("Service");
            }
            if (community == true) {
                csaCat.add("Community");
            }
            if (achievement == true) {
                csaCat.add("Achievement");
            }
			
            switch (selectionType) {
            /* Selects all that were checked. */
                case "One":
                    if (grade.isEmpty() && csaCat.isEmpty()) {
                        throw new Exception("Please select a check box.");
                    }
					
                    for (int i = 0; i < grade.size(); i++) {
                        System.out.println("Here");
                        selectEqual(grade.get(i), 4);
                    }
					
                    for (int j = 0; j < csaCat.size(); j++) {
                        selectEqual(csaCat.get(j), 6);
                    }
				
                    break;
				
                /* Selects all that apply to both the checked grade and CSA Category. */
                case "Both":
                    if (grade.isEmpty()) {
                        throw new Exception("Please selected a grade check box.");
                    }
                    else if (csaCat.isEmpty()) {
                        throw new Exception("Please selected a CSA category check box.");
                    }
                    else if (grade.size() > 1) {
                        throw new Exception("Please select only one grade.");
                    }
                    else if (csaCat.size() > 1) {
                        throw new Exception("Please select only one CSA Category.");
                    }
					
                    selectEqualAnd(grade.get(0), csaCat.get(0));
                    break;
        }         
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
	
    // ******************************
    // Private Methods
    // ******************************
    /*
     * Adds specified column to the print table model.
     * @param columnName The name of the column to add.
     * @param columnIndex The index of the column in the report table model.
     */
    private static void setPrintModelColumn(String columnName, int columnIndex) {
         printModel.addColumn(columnName);
         printColumns.add(columnIndex);
    }
    
    /* Throws an exception if the user has not selected a row on the report table. */
    private static void isRowSelected() throws Exception {
        boolean isRowSelected = false;
		
        for (int row = 0; row < rptModel.getRowCount(); row++) {
            if (rptModel.getValueAt(row, 0) != null) {
                isRowSelected = true;
            }
        }
        
        if (isRowSelected == false) {
            throw new Exception("Please select the check box of the rows you wish to print.");
        }
    }         
    
    /* Adds rows to the print table model based off of which columns of the report table model were selected. */
    private static void setPrintModelRows() {
        String[] tblValue = new String[printColumns.size()];
        
        for (int row = 0; row < rptModel.getRowCount(); row++) {
            if (rptModel.getValueAt(row, 0) != null) {
                if ("true".equals(rptModel.getValueAt(row, 0).toString())) {
                    for (int i = 0; i < printColumns.size(); i++) {
                        int column = printColumns.get(i);
                        tblValue[i] = rptModel.getValueAt(row, column).toString();
                    }
                
                    printModel.addRow(tblValue);
                }
            }
        }
    }
    
    /*
     * Selects the rows of the report table model if the specified selection is found in the specified column.
     * @param selection The value that is check for in each row.
     * @param column The report model column to check for the specified selection.
     */
    private static void selectEqual(String selection, int column) {
        rptModel = Refresh.getReportModel();
        String tblValue;
        
        for (int i = 0; i < rptModel.getRowCount(); i++) {
            tblValue = rptModel.getValueAt(i, column).toString();
            if (selection.equalsIgnoreCase(tblValue)) {
                rptModel.setValueAt(true, i, 0);
            }
        }
        
        Refresh.setReportModel(rptModel);
    }
    
    /*
     * Selects the rows of the report table model if both specified selection are found.
     * @param gradeSlection The value that is check for in the report table model grade column.
     * @param csaSelection The report model column to check for in the report table model CSA Category column.
     */
    private static void selectEqualAnd(String gradeSelection, String csaSelection) {
        rptModel = Refresh.getReportModel();
        String tblGradeValue;
        String tblCSAValue;
        
        for (int i = 0; i < rptModel.getRowCount(); i++) {
            tblGradeValue = rptModel.getValueAt(i, 4).toString();
            tblCSAValue = rptModel.getValueAt(i, 6).toString();
            
            if (gradeSelection.equalsIgnoreCase(tblGradeValue) && csaSelection.equalsIgnoreCase(tblCSAValue)) {
                rptModel.setValueAt(true, i, 0);
            }
        }
        
        Refresh.setReportModel(rptModel);
    }
}
