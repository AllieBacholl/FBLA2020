/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operation;

import javax.swing.JOptionPane;

/**
 * Controls the help messages for the help buttons.
 * @author Allie Bacholl
 */
public class Help {
	
    // ******************************
    // Public Methods
    // ******************************
    /**
     * Displays help messages for the report tab based off of the user's choices.
     */
    public static void rptHelp() {
        Object[] options = {"Filter/Select which Rows Print",
                            "Select which Columns Print",
                            "Print Selected Data"};
        int answer = JOptionPane.showOptionDialog(null, "What would you like to do?", "Reports Tab Help",  JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);
        
        switch (answer) {
            case 0:
                selectHelp();
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "You can select which columns will print by selected the\n"
                                                    +"check boxes under the Print Columns title (i.e. ID, Firstname, Total Hours).\n"
                                                    +"At least one column must be selected for the data to print.");
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "You can print the data by pressing the Print Report button.\n"
                                                    +"This will display print options as well as allow you\n"
                                                    +"to select which printer to print to.\n\n"
                                                    +"Before printing, at least one row and column must be selected.");
                break;
        }
    }
    
    /**
     * Displays help messages for the students' data tab based off of the user's choices.
     */
    public static void dataHelp() {
        Object[] options = {"Edit Students' Data",
                            "Sava a Copy of the Database",
                            "Set the Location of the Database"};
        int answer = JOptionPane.showOptionDialog(null, "What would you like to do?", "Students' Data Tab Help",  JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);
        
        switch (answer) {
            case 0:
                editHelp();
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "You can save a copy by pressing the Save Copy button.\n"
                                                    +"This will bring up a dialog that lets you choose where to save\n"
                                                    +"the copy as well as what to name it. After this, the app will\n"
                                                    +"ask you if you would like to change the active database. If you\n"
                                                    +"pres yes, the database being currently edited and view by the app\n"
                                                    +"will be the new copy. Otherwise, if no is pressed, the active database\n"
                                                    +"will stay the same.");
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "By pressing the Set Location button, you can bring up a dialog that will\n"
                                                    +"allow to pick the location of whichever database you would like to use.\n"
                                                    +"If no database can be found at that location, or at a previously set location\n"
                                                    +"the app defaults to the students.db file found in the app's folder.\n\n"
                                                    +"The new database must be formatted like the students.db file. This can be done\n"
                                                    +"by using the Save Copy button in the Students' Data tab.");
                break;
        }
    }
    
    /* Displays the second set of questions and choices when the users wants to know how to edit the students' data. */
    private static void editHelp() {
        Object[] editOptions = {"Change Student Data",
                                "Add/Remove a Student",
                                "Edit Students' Service Hours"};
        int answer = JOptionPane.showOptionDialog(null, "What would you like to do?", "Students' Data Tab Help",  JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, editOptions, null);
        
        switch (answer) {
            case 0:
                JOptionPane.showMessageDialog(null, "There are two ways to edit data. One way is to select a row and then edit it\n"
                                                    +"will the text fields and drop down boxes near the top of the window.\n"
                                                    +"Once done editing the data this way, you must press the update button to save your changes.\n\n"
                                                    +"The other way to edit the data is by double clicking on the cell you would like\n"
                                                    +"to edit and then typing in the edit you would like to make.");
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "To remove a student, select the row that the student's data is in.\n"
                                                    +"Then, press the Delete button. To add a student to the table,\n"
                                                    +"you must fill out the student's data in the text fields and drop down boxes\n"
                                                    +"near the top of the window (you can press the Clear button to reset these boxes).\n"
                                                    +"Then, you press the Insert button to add the student.");
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "To edit a student's service hours, you can use the hours panel in\n"
                                                    +"the top right of the window. Select the row of the student whom you\n"
                                                    +"would like to edit. Then, type in an hour amount in the hours\n"
                                                    +"text field. Next, press the add/subtract button to add/subtract your\n"
                                                    +"entered hour amount to/from the selected students total hour or press\n"
                                                    +"the Set To button to set the selected student's hours the the entered hours.");
                break;
        }
    }
    
    /* Displays the second set of questions and choices when the users wants to know how to select rows. */
    private static void selectHelp() {
        Object[] selectOptions = {"Select/Deselect All Rows",
                                  "Pick Individual Rows to Print",
                                  "Filter which Rows to Print"};
        int answer = JOptionPane.showOptionDialog(null, "What would you like to do?", "Reports Tab Help",  JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, selectOptions, null);
        
        switch (answer) {
            case 0:
                JOptionPane.showMessageDialog(null, "Press the Select All button to select all rows to print.\nPress the Clear Selection button to deselect all rows to print.");
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "You can select the check box to the left of the row you would like to print.\nThis can also be used to deselect individual rows.");
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "From the drop down menu between the grades checklist and the\n"
                                                    +"CSA Category checkbox list, you can select 'One' or 'All.'\n\n"
                                                    +"When 'One' is selected, all students whose data matches\n"
                                                    +"at least ONE of the selected chekcboxes in either the grade checkbox list\n" 
                                                    +"or the CSA category checkbox list are selected (at least one checkbox must be selected).\n\n"
                                                    +"When 'Both' is selected, all students whose data matches\n"
                                                    +"the selected checkbox in BOTH the grade and CSA category checkbox list\n"
                                                    +"(ONE chekcbox from each checkbox list must be selected).\n\n"
                                                    +"Once done, press the Select button.");
                break;
        }
    }
}


