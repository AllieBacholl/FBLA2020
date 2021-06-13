package gui;

import data.Convert;
import data.Refresh;
import database.DatabaseConnection;
import java.text.MessageFormat;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.OrientationRequested;
import operation.Database;
import operation.Help;
import operation.Report;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 * Creates and controls the hour tracker GUI.
 * @author Allie Bacholl
 */
public final class HourTracker extends javax.swing.JFrame{

    // ******************************
    // Constants
    // ******************************
    private final int IDCOLUMN = 0;
    private final int FNAMECOLUMN = 1;
    private final int LNAMECOLUMN = 2;
    private final int GRADECOLUMN = 3;
    private final int HOURSCOLUMN = 4;
    private final int CSACATCOLUMN = 5;
    
    private final String DATATAB = "Select the Students' Data Tab on\nthe top of the window. If you need\naddional help, press the Help Button\nin the upper right conner";
    
    // ******************************
    // Constructor
    // ******************************
    /**
     * Creates a new Hour Tracker UI and populates the student and report table.
     */
    public HourTracker() {  
        /* Instantiates and sets the properties of all the GUI components. */
        initComponents();
        
        /* Refreshes all the data in the tables based off the connected database. */
        refreshAll();
        
        /* Removes the user's ability to move the table columns. */
        studentsTbl.getTableHeader().setReorderingAllowed(false);
        reportTbl.getTableHeader().setReorderingAllowed(false); 
        printTbl.getTableHeader().setReorderingAllowed(false);
        
        /* Sets the print table equal the the report table. */
        printTbl.setModel(Refresh.getReportModel());
        printTbl.setRowHeight(30);
        printTbl.setVisible(false);
        
        /* Removes the borders from the text areas on the welcome pages. */
        introScrollPn.setBorder(null);
        selectionScrollPn.setBorder(null);
        
    }

    // ******************************
    // Private Methods
    // ******************************
    /**
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabSelectionBtnGrp = new javax.swing.ButtonGroup();
        serviceHoursPnl = new javax.swing.JTabbedPane();
        welcomePnl = new javax.swing.JPanel();
        wlcmPicLbl = new javax.swing.JLabel();
        titleLbl = new javax.swing.JLabel();
        introScrollPn = new javax.swing.JScrollPane();
        introTxtArea = new javax.swing.JTextArea();
        tabSelectionLbl = new javax.swing.JLabel();
        studentDataRdBtn = new javax.swing.JRadioButton();
        printRdBtn = new javax.swing.JRadioButton();
        copyDatabaseRdBtn = new javax.swing.JRadioButton();
        changeDatabaseBtn = new javax.swing.JRadioButton();
        questionRdBtn = new javax.swing.JRadioButton();
        whatToUseLbl = new javax.swing.JLabel();
        selectionScrollPn = new javax.swing.JScrollPane();
        selectionTxtArea = new javax.swing.JTextArea();
        recentPrintRdBtn = new javax.swing.JRadioButton();
        citeLbl = new javax.swing.JLabel();
        databasePnl = new javax.swing.JPanel();
        dbHelpBtn = new javax.swing.JButton();
        idLbl = new javax.swing.JLabel();
        idTxtFld = new javax.swing.JTextField();
        gradeLbl = new javax.swing.JLabel();
        fNameLbl = new javax.swing.JLabel();
        lNameLbl = new javax.swing.JLabel();
        fNameTxtFld = new javax.swing.JTextField();
        lNameTxtFld = new javax.swing.JTextField();
        dbGradeBox = new javax.swing.JComboBox<>();
        csaLbl = new javax.swing.JLabel();
        dbCSABox = new javax.swing.JComboBox<>();
        hoursPnl = new javax.swing.JPanel();
        hoursLbl = new javax.swing.JLabel();
        hoursTxtFld = new javax.swing.JTextField();
        hoursAddBtn = new javax.swing.JButton();
        hoursSubBtn = new javax.swing.JButton();
        hoursSetBtn = new javax.swing.JButton();
        dbInsertBtn = new javax.swing.JButton();
        dbDelBtn = new javax.swing.JButton();
        dbUpdateBtn = new javax.swing.JButton();
        dbClearBtn = new javax.swing.JButton();
        dbScrollPn = new javax.swing.JScrollPane();
        studentsTbl = new javax.swing.JTable();
        dbCopyBtn = new javax.swing.JButton();
        dbSetLocationBtn = new javax.swing.JButton();
        dbDatabaseLocationTitleLbl = new javax.swing.JLabel();
        dbDatabaseLocationLbl = new javax.swing.JLabel();
        reportsPnl = new javax.swing.JPanel();
        rptHelpBtn = new javax.swing.JButton();
        rptScrollPn = new javax.swing.JScrollPane();
        reportTbl = new javax.swing.JTable();
        freshmanChBox = new javax.swing.JCheckBox();
        noneChBox = new javax.swing.JCheckBox();
        gradeSortLbl = new javax.swing.JLabel();
        csaCatSortLbl = new javax.swing.JLabel();
        sophomoreChBox = new javax.swing.JCheckBox();
        communityChBox = new javax.swing.JCheckBox();
        juniorChBox = new javax.swing.JCheckBox();
        serviceChBox = new javax.swing.JCheckBox();
        seniorChBox = new javax.swing.JCheckBox();
        achievementChBox = new javax.swing.JCheckBox();
        rptClearBtn = new javax.swing.JButton();
        rptAllBtn = new javax.swing.JButton();
        rptPrintBtn = new javax.swing.JButton();
        printLbl = new javax.swing.JLabel();
        idChBox = new javax.swing.JCheckBox();
        fNameChBox = new javax.swing.JCheckBox();
        lNameChBox = new javax.swing.JCheckBox();
        gradeChBox = new javax.swing.JCheckBox();
        hoursChBox = new javax.swing.JCheckBox();
        csaChBox = new javax.swing.JCheckBox();
        rptPicLbl = new javax.swing.JLabel();
        rptSelectionTypeComboBox = new javax.swing.JComboBox<>();
        rptSelectBtn = new javax.swing.JButton();
        printPnl = new javax.swing.JPanel();
        printScrollPn = new javax.swing.JScrollPane();
        printTbl = new javax.swing.JTable();
        printTblLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FBLA Coding and Programming");

        serviceHoursPnl.setName("serviceHoursPnl"); // NOI18N

        welcomePnl.setBackground(new java.awt.Color(255, 255, 255));

        wlcmPicLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/MHSLogo.png"))); // NOI18N

        titleLbl.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        titleLbl.setText("FBLA Community Service App");

        introScrollPn.setToolTipText("");

        introTxtArea.setEditable(false);
        introTxtArea.setColumns(20);
        introTxtArea.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        introTxtArea.setRows(5);
        introTxtArea.setText("The purpose of this app is to track service hours \nas well as the community service category of each member\nof Marshfield High School's FBLA members.\n\nSelect a tab on the top of the panal to continue. Below,\nyou can select a task you would like to preform and it\nwill display which tab you should use. \n\nAdditionally, on the Service Hours tab and the Reports tab, \nthere are help buttons to help guide you on how to use all \nthe functionalities.\n");
        introTxtArea.setWrapStyleWord(true);
        introTxtArea.setBorder(null);
        introTxtArea.setFocusable(false);
        introScrollPn.setViewportView(introTxtArea);

        tabSelectionLbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tabSelectionLbl.setText("Select What You Would Like to Do: ");

        tabSelectionBtnGrp.add(studentDataRdBtn);
        studentDataRdBtn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        studentDataRdBtn.setText("View/Edit students' data (Hours, Community Service Award (CSA), Name, etc.)");
        studentDataRdBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentDataRdBtnActionPerformed(evt);
            }
        });

        tabSelectionBtnGrp.add(printRdBtn);
        printRdBtn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        printRdBtn.setText("Print reports of the students' data");
        printRdBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printRdBtnActionPerformed(evt);
            }
        });

        tabSelectionBtnGrp.add(copyDatabaseRdBtn);
        copyDatabaseRdBtn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        copyDatabaseRdBtn.setText("Save a Copy of the Database");
        copyDatabaseRdBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyDatabaseRdBtnActionPerformed(evt);
            }
        });

        tabSelectionBtnGrp.add(changeDatabaseBtn);
        changeDatabaseBtn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        changeDatabaseBtn.setText("Change which Database is Being Edited");
        changeDatabaseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeDatabaseBtnActionPerformed(evt);
            }
        });

        tabSelectionBtnGrp.add(questionRdBtn);
        questionRdBtn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        questionRdBtn.setText("Express Questions/Concerns");
        questionRdBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                questionRdBtnActionPerformed(evt);
            }
        });

        whatToUseLbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        whatToUseLbl.setText("What You Should Use:");

        selectionTxtArea.setEditable(false);
        selectionTxtArea.setColumns(20);
        selectionTxtArea.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        selectionTxtArea.setRows(5);
        selectionTxtArea.setWrapStyleWord(true);
        selectionTxtArea.setFocusable(false);
        selectionScrollPn.setViewportView(selectionTxtArea);

        tabSelectionBtnGrp.add(recentPrintRdBtn);
        recentPrintRdBtn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        recentPrintRdBtn.setText("View the Most Recent Printed Table");
        recentPrintRdBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recentPrintRdBtnActionPerformed(evt);
            }
        });

        citeLbl.setText("Marshfield High School logo used with permission from the Unified School District of Marshfield.");

        javax.swing.GroupLayout welcomePnlLayout = new javax.swing.GroupLayout(welcomePnl);
        welcomePnl.setLayout(welcomePnlLayout);
        welcomePnlLayout.setHorizontalGroup(
            welcomePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(welcomePnlLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(welcomePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(welcomePnlLayout.createSequentialGroup()
                        .addComponent(citeLbl)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(welcomePnlLayout.createSequentialGroup()
                        .addGroup(welcomePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tabSelectionLbl)
                            .addComponent(titleLbl)
                            .addGroup(welcomePnlLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(welcomePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(printRdBtn)
                                    .addComponent(changeDatabaseBtn)
                                    .addComponent(copyDatabaseRdBtn)
                                    .addComponent(studentDataRdBtn)
                                    .addComponent(questionRdBtn)
                                    .addComponent(recentPrintRdBtn)))
                            .addComponent(introScrollPn, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(welcomePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(welcomePnlLayout.createSequentialGroup()
                                .addGroup(welcomePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(welcomePnlLayout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(whatToUseLbl))
                                    .addGroup(welcomePnlLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(selectionScrollPn, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(30, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, welcomePnlLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(wlcmPicLbl)
                                .addGap(60, 60, 60))))))
        );
        welcomePnlLayout.setVerticalGroup(
            welcomePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(welcomePnlLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(welcomePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(welcomePnlLayout.createSequentialGroup()
                        .addComponent(titleLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(introScrollPn, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, welcomePnlLayout.createSequentialGroup()
                        .addComponent(wlcmPicLbl)
                        .addGap(41, 41, 41)))
                .addGroup(welcomePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabSelectionLbl)
                    .addComponent(whatToUseLbl, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(welcomePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(welcomePnlLayout.createSequentialGroup()
                        .addComponent(studentDataRdBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(copyDatabaseRdBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(changeDatabaseBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(printRdBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(recentPrintRdBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(questionRdBtn))
                    .addComponent(selectionScrollPn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addComponent(citeLbl)
                .addGap(56, 56, 56))
        );

        serviceHoursPnl.addTab("Welcome", welcomePnl);

        databasePnl.setBackground(new java.awt.Color(255, 255, 255));
        databasePnl.setToolTipText("Shows the database with the students' and their hours.");
        databasePnl.setMaximumSize(new java.awt.Dimension(0, 0));
        databasePnl.setName("databasePnl"); // NOI18N

        dbHelpBtn.setBackground(new java.awt.Color(255, 153, 51));
        dbHelpBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        dbHelpBtn.setText("Help");
        dbHelpBtn.setToolTipText("Launches an interactive help dialog.");
        dbHelpBtn.setRequestFocusEnabled(false);
        dbHelpBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dbHelpBtnActionPerformed(evt);
            }
        });

        idLbl.setText("Student's ID: ");

        idTxtFld.setToolTipText("Enter the student's ID.");
        idTxtFld.setSelectionColor(new java.awt.Color(255, 153, 51));

        gradeLbl.setText("Grade:");

        fNameLbl.setText("First Name:");

        lNameLbl.setText("Last Name:");

        fNameTxtFld.setToolTipText("Enter students first name.");
        fNameTxtFld.setSelectionColor(new java.awt.Color(255, 153, 51));

        lNameTxtFld.setToolTipText("Enter student's last name.");
        lNameTxtFld.setSelectionColor(new java.awt.Color(255, 153, 51));

        dbGradeBox.setBackground(new java.awt.Color(204, 204, 204));
        dbGradeBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Freshman - 9th", "Sophomore - 10th", "Junior - 11th", "Senior - 12th" }));
        dbGradeBox.setToolTipText("Select the student's grade.");
        dbGradeBox.setName(""); // NOI18N

        csaLbl.setText("CSA Category:");

        dbCSABox.setBackground(new java.awt.Color(204, 204, 204));
        dbCSABox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "CSA Community - 50 hours", "CSA Service - 200 hours", "CSA Achievement - 500 hours" }));
        dbCSABox.setToolTipText("Select the student's CSA Category.");

        hoursPnl.setBackground(new java.awt.Color(255, 153, 51));

        hoursLbl.setText("Hours:");
        hoursLbl.setToolTipText("");

        hoursTxtFld.setToolTipText("Enter the student's community service hours.");
        hoursTxtFld.setPreferredSize(new java.awt.Dimension(63, 23));
        hoursTxtFld.setSelectionColor(new java.awt.Color(255, 153, 51));

        hoursAddBtn.setBackground(new java.awt.Color(204, 204, 204));
        hoursAddBtn.setText("Add");
        hoursAddBtn.setToolTipText("Adds the hours entered to the selected student's total hours.");
        hoursAddBtn.setAutoscrolls(true);
        hoursAddBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        hoursAddBtn.setRequestFocusEnabled(false);
        hoursAddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hoursAddBtnActionPerformed(evt);
            }
        });

        hoursSubBtn.setBackground(new java.awt.Color(204, 204, 204));
        hoursSubBtn.setText("Subtract");
        hoursSubBtn.setToolTipText("Subtracts the hours entered from the selected student's total hours.");
        hoursSubBtn.setRequestFocusEnabled(false);
        hoursSubBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hoursSubBtnActionPerformed(evt);
            }
        });

        hoursSetBtn.setBackground(new java.awt.Color(204, 204, 204));
        hoursSetBtn.setText("Set To");
        hoursSetBtn.setToolTipText("Set the student's total hours to the hours entered.");
        hoursSetBtn.setRequestFocusEnabled(false);
        hoursSetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hoursSetBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout hoursPnlLayout = new javax.swing.GroupLayout(hoursPnl);
        hoursPnl.setLayout(hoursPnlLayout);
        hoursPnlLayout.setHorizontalGroup(
            hoursPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hoursPnlLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(hoursPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(hoursSubBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(hoursPnlLayout.createSequentialGroup()
                        .addComponent(hoursAddBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(4, 4, 4)
                        .addComponent(hoursSetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(hoursPnlLayout.createSequentialGroup()
                        .addComponent(hoursLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hoursTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        hoursPnlLayout.setVerticalGroup(
            hoursPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hoursPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(hoursPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hoursLbl)
                    .addComponent(hoursTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(hoursPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hoursAddBtn)
                    .addComponent(hoursSetBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hoursSubBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        hoursTxtFld.getAccessibleContext().setAccessibleName("Hours Text Box");
        hoursAddBtn.getAccessibleContext().setAccessibleName("Add Button");
        hoursSubBtn.getAccessibleContext().setAccessibleName("Subtract Button");
        hoursSetBtn.getAccessibleContext().setAccessibleName("Set To Button");

        dbInsertBtn.setBackground(new java.awt.Color(204, 204, 204));
        dbInsertBtn.setText("Insert");
        dbInsertBtn.setToolTipText("Adds the information inputed into the table.");
        dbInsertBtn.setMaximumSize(new java.awt.Dimension(67, 23));
        dbInsertBtn.setMinimumSize(new java.awt.Dimension(67, 23));
        dbInsertBtn.setPreferredSize(new java.awt.Dimension(67, 23));
        dbInsertBtn.setRequestFocusEnabled(false);
        dbInsertBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dbInsertBtnActionPerformed(evt);
            }
        });

        dbDelBtn.setBackground(new java.awt.Color(204, 204, 204));
        dbDelBtn.setText("Delete");
        dbDelBtn.setToolTipText("Removes the selected student from the table.");
        dbDelBtn.setMaximumSize(new java.awt.Dimension(67, 23));
        dbDelBtn.setMinimumSize(new java.awt.Dimension(67, 23));
        dbDelBtn.setPreferredSize(new java.awt.Dimension(67, 23));
        dbDelBtn.setRequestFocusEnabled(false);
        dbDelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dbDelBtnActionPerformed(evt);
            }
        });

        dbUpdateBtn.setBackground(new java.awt.Color(204, 204, 204));
        dbUpdateBtn.setText("Update");
        dbUpdateBtn.setToolTipText("Updates the selected student's information to the entered text.");
        dbUpdateBtn.setRequestFocusEnabled(false);
        dbUpdateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dbUpdateBtnActionPerformed(evt);
            }
        });

        dbClearBtn.setBackground(new java.awt.Color(204, 204, 204));
        dbClearBtn.setText("Clear");
        dbClearBtn.setToolTipText("Clears the information in the text fields and resets the combo boxes to their default value.");
        dbClearBtn.setMaximumSize(new java.awt.Dimension(67, 23));
        dbClearBtn.setMinimumSize(new java.awt.Dimension(67, 23));
        dbClearBtn.setPreferredSize(new java.awt.Dimension(67, 23));
        dbClearBtn.setRequestFocusEnabled(false);
        dbClearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dbClearBtnActionPerformed(evt);
            }
        });

        studentsTbl.setInheritsPopupMenu(true);
        studentsTbl.setSelectionBackground(new java.awt.Color(255, 153, 51));
        studentsTbl.setSelectionForeground(new java.awt.Color(0, 0, 0));
        studentsTbl.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        studentsTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentsTblMouseClicked(evt);
            }
        });
        dbScrollPn.setViewportView(studentsTbl);
        studentsTbl.getAccessibleContext().setAccessibleName("");

        dbCopyBtn.setBackground(new java.awt.Color(204, 204, 204));
        dbCopyBtn.setText("Save Copy");
        dbCopyBtn.setToolTipText("Saves a copy of the database.");
        dbCopyBtn.setMaximumSize(new java.awt.Dimension(67, 23));
        dbCopyBtn.setMinimumSize(new java.awt.Dimension(67, 23));
        dbCopyBtn.setPreferredSize(new java.awt.Dimension(67, 23));
        dbCopyBtn.setRequestFocusEnabled(false);
        dbCopyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dbCopyBtnActionPerformed(evt);
            }
        });

        dbSetLocationBtn.setBackground(new java.awt.Color(204, 204, 204));
        dbSetLocationBtn.setText("Set Location");
        dbSetLocationBtn.setToolTipText("Sets the location of the database.");
        dbSetLocationBtn.setMaximumSize(new java.awt.Dimension(67, 23));
        dbSetLocationBtn.setMinimumSize(new java.awt.Dimension(67, 23));
        dbSetLocationBtn.setPreferredSize(new java.awt.Dimension(67, 23));
        dbSetLocationBtn.setRequestFocusEnabled(false);
        dbSetLocationBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dbSetLocationBtnActionPerformed(evt);
            }
        });

        dbDatabaseLocationTitleLbl.setText("Current Database Save Location:");

        dbDatabaseLocationLbl.setText("Database Location URL");

        javax.swing.GroupLayout databasePnlLayout = new javax.swing.GroupLayout(databasePnl);
        databasePnl.setLayout(databasePnlLayout);
        databasePnlLayout.setHorizontalGroup(
            databasePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(databasePnlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(databasePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(databasePnlLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(databasePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, databasePnlLayout.createSequentialGroup()
                                .addComponent(dbDatabaseLocationTitleLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dbDatabaseLocationLbl))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, databasePnlLayout.createSequentialGroup()
                                .addComponent(dbInsertBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(dbDelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(dbUpdateBtn)
                                .addGap(18, 18, 18)
                                .addComponent(dbClearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(dbCopyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(dbSetLocationBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(databasePnlLayout.createSequentialGroup()
                        .addGroup(databasePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idLbl, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(fNameLbl, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lNameLbl, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(databasePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(databasePnlLayout.createSequentialGroup()
                                .addGroup(databasePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(fNameTxtFld, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                                    .addComponent(lNameTxtFld))
                                .addGap(18, 18, 18)
                                .addGroup(databasePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(csaLbl, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(gradeLbl, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(databasePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(dbCSABox, 0, 211, Short.MAX_VALUE)
                                    .addComponent(dbGradeBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(idTxtFld))))
                .addGroup(databasePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(databasePnlLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(hoursPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(36, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, databasePnlLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dbHelpBtn)
                        .addContainerGap())))
            .addComponent(dbScrollPn)
        );
        databasePnlLayout.setVerticalGroup(
            databasePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(databasePnlLayout.createSequentialGroup()
                .addGroup(databasePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(databasePnlLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(databasePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idLbl))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(databasePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fNameLbl)
                            .addComponent(fNameTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gradeLbl)
                            .addComponent(dbGradeBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(databasePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(databasePnlLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(databasePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(csaLbl)
                                    .addComponent(dbCSABox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(databasePnlLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(databasePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lNameTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lNameLbl))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(databasePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dbSetLocationBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                            .addComponent(dbInsertBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dbUpdateBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dbClearBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dbCopyBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dbDelBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(databasePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dbDatabaseLocationLbl)
                            .addComponent(dbDatabaseLocationTitleLbl))
                        .addGap(14, 14, 14))
                    .addGroup(databasePnlLayout.createSequentialGroup()
                        .addComponent(dbHelpBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hoursPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)))
                .addComponent(dbScrollPn, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        idLbl.getAccessibleContext().setAccessibleName("Student's ID:");
        idTxtFld.getAccessibleContext().setAccessibleName("ID Text Field");
        fNameTxtFld.getAccessibleContext().setAccessibleName("First Name Text Field");
        lNameTxtFld.getAccessibleContext().setAccessibleName("Last Name Text Field");
        dbGradeBox.getAccessibleContext().setAccessibleName("Grade Combo Box");
        dbCSABox.getAccessibleContext().setAccessibleName("CSA Category Combo Box");
        hoursPnl.getAccessibleContext().setAccessibleName("");
        dbInsertBtn.getAccessibleContext().setAccessibleName("Insert Button");
        dbDelBtn.getAccessibleContext().setAccessibleName("Delete Button");
        dbUpdateBtn.getAccessibleContext().setAccessibleName("Update Button");
        dbClearBtn.getAccessibleContext().setAccessibleName("Clear Button");

        serviceHoursPnl.addTab("Students' Data", databasePnl);
        databasePnl.getAccessibleContext().setAccessibleDescription("");

        reportsPnl.setBackground(new java.awt.Color(255, 255, 255));

        rptHelpBtn.setBackground(new java.awt.Color(255, 153, 51));
        rptHelpBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rptHelpBtn.setText("Help");
        rptHelpBtn.setToolTipText("Launches an interactive help dialog.");
        rptHelpBtn.setRequestFocusEnabled(false);
        rptHelpBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rptHelpBtnActionPerformed(evt);
            }
        });

        reportTbl.setInheritsPopupMenu(true);
        reportTbl.setSelectionBackground(new java.awt.Color(255, 153, 51));
        reportTbl.setSelectionForeground(new java.awt.Color(0, 0, 0));
        reportTbl.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        rptScrollPn.setViewportView(reportTbl);

        freshmanChBox.setBackground(new java.awt.Color(255, 153, 51));
        freshmanChBox.setText("Freshman - 9th");
        freshmanChBox.setToolTipText("Selects all the students who are in grade 9.");

        noneChBox.setBackground(new java.awt.Color(255, 153, 51));
        noneChBox.setText("None");
        noneChBox.setToolTipText("Selects all the students who are in the none CSA category.");

        gradeSortLbl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        gradeSortLbl.setText("Sort By Grade:");

        csaCatSortLbl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        csaCatSortLbl.setText("Sort By CSA Category:");

        sophomoreChBox.setBackground(new java.awt.Color(255, 153, 51));
        sophomoreChBox.setText("Sophomore - 10th");
        sophomoreChBox.setToolTipText("Selects all the students who are in grade 10.");

        communityChBox.setBackground(new java.awt.Color(255, 153, 51));
        communityChBox.setText("CSA Community - 50 hours");
        communityChBox.setToolTipText("Selects all the students who are in the community CSA category.");

        juniorChBox.setBackground(new java.awt.Color(255, 153, 51));
        juniorChBox.setText("Junior - 11th");
        juniorChBox.setToolTipText("Selects all the students who are in grade 11.");

        serviceChBox.setBackground(new java.awt.Color(255, 153, 51));
        serviceChBox.setText("CSA Service - 200 hours");
        serviceChBox.setToolTipText("Selects all the students who are in the service CSA category.");

        seniorChBox.setBackground(new java.awt.Color(255, 153, 51));
        seniorChBox.setText("Senior - 12th");
        seniorChBox.setToolTipText("Selects all the students who are in grade 12.");

        achievementChBox.setBackground(new java.awt.Color(255, 153, 51));
        achievementChBox.setText("CSA Achievement - 500 hours");
        achievementChBox.setToolTipText("Selects all the students who are in the achievement CSA category.");

        rptClearBtn.setBackground(new java.awt.Color(204, 204, 204));
        rptClearBtn.setText("Clear Selection");
        rptClearBtn.setToolTipText("Deselects all rows.");
        rptClearBtn.setRequestFocusEnabled(false);
        rptClearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rptClearBtnActionPerformed(evt);
            }
        });

        rptAllBtn.setBackground(new java.awt.Color(204, 204, 204));
        rptAllBtn.setText("Select All");
        rptAllBtn.setToolTipText("Selects all rows.");
        rptAllBtn.setRequestFocusEnabled(false);
        rptAllBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rptAllBtnActionPerformed(evt);
            }
        });

        rptPrintBtn.setBackground(new java.awt.Color(204, 204, 204));
        rptPrintBtn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rptPrintBtn.setText("Print Report");
        rptPrintBtn.setToolTipText("Prints all selected rows.");
        rptPrintBtn.setRequestFocusEnabled(false);
        rptPrintBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rptPrintBtnActionPerformed(evt);
            }
        });

        printLbl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        printLbl.setText("Print Columns: ");

        idChBox.setBackground(new java.awt.Color(255, 153, 51));
        idChBox.setText("ID");
        idChBox.setToolTipText("Prints the ID column.");

        fNameChBox.setBackground(new java.awt.Color(255, 153, 51));
        fNameChBox.setText("First Name");
        fNameChBox.setToolTipText("Prints the first name column.");

        lNameChBox.setBackground(new java.awt.Color(255, 153, 51));
        lNameChBox.setText("Last Name");
        lNameChBox.setToolTipText("Prints the last name column.");

        gradeChBox.setBackground(new java.awt.Color(255, 153, 51));
        gradeChBox.setText("Grade");
        gradeChBox.setToolTipText("Prints the grade column.");

        hoursChBox.setBackground(new java.awt.Color(255, 153, 51));
        hoursChBox.setText("Total Hours");
        hoursChBox.setToolTipText("Prints the total hourscolumn.");

        csaChBox.setBackground(new java.awt.Color(255, 153, 51));
        csaChBox.setText("CSA Category");
        csaChBox.setToolTipText("Prints the CSA category column.");

        rptPicLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/MHSLogo.png"))); // NOI18N

        rptSelectionTypeComboBox.setBackground(new java.awt.Color(204, 204, 204));
        rptSelectionTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "One", "Both" }));

        rptSelectBtn.setBackground(new java.awt.Color(204, 204, 204));
        rptSelectBtn.setText("Select");
        rptSelectBtn.setToolTipText("Selects students based off of the selected check boxes.");
        rptSelectBtn.setRequestFocusEnabled(false);
        rptSelectBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rptSelectBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout reportsPnlLayout = new javax.swing.GroupLayout(reportsPnl);
        reportsPnl.setLayout(reportsPnlLayout);
        reportsPnlLayout.setHorizontalGroup(
            reportsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reportsPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(reportsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(reportsPnlLayout.createSequentialGroup()
                        .addGroup(reportsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(reportsPnlLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(reportsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(freshmanChBox, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(reportsPnlLayout.createSequentialGroup()
                                        .addGroup(reportsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(juniorChBox, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(sophomoreChBox, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(seniorChBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(reportsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                            .addComponent(rptSelectionTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(rptSelectBtn))))
                                .addGap(13, 13, 13))
                            .addGroup(reportsPnlLayout.createSequentialGroup()
                                .addComponent(gradeSortLbl)
                                .addGap(129, 129, 129)))
                        .addGroup(reportsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(csaCatSortLbl)
                            .addGroup(reportsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(achievementChBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(serviceChBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(communityChBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(noneChBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, reportsPnlLayout.createSequentialGroup()
                        .addComponent(rptAllBtn)
                        .addGap(18, 18, 18)
                        .addComponent(rptClearBtn)
                        .addGap(18, 18, 18)
                        .addComponent(rptPrintBtn)
                        .addGap(18, 18, 18)
                        .addComponent(rptHelpBtn)
                        .addGap(13, 13, 13)))
                .addGroup(reportsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(reportsPnlLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(reportsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hoursChBox, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(reportsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(idChBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(gradeChBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(csaChBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lNameChBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(fNameChBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, reportsPnlLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(printLbl)
                        .addGap(18, 18, 18)))
                .addComponent(rptPicLbl)
                .addContainerGap())
            .addComponent(rptScrollPn)
        );
        reportsPnlLayout.setVerticalGroup(
            reportsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reportsPnlLayout.createSequentialGroup()
                .addGroup(reportsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(reportsPnlLayout.createSequentialGroup()
                        .addGroup(reportsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(reportsPnlLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(reportsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(csaCatSortLbl)
                                    .addComponent(printLbl)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, reportsPnlLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(gradeSortLbl)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(reportsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(reportsPnlLayout.createSequentialGroup()
                                .addGroup(reportsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(freshmanChBox)
                                    .addComponent(noneChBox))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(reportsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(reportsPnlLayout.createSequentialGroup()
                                        .addComponent(communityChBox)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(serviceChBox)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(achievementChBox)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(reportsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(rptHelpBtn)
                                            .addComponent(rptPrintBtn)
                                            .addComponent(rptClearBtn)
                                            .addComponent(rptAllBtn))
                                        .addGap(37, 37, 37))
                                    .addGroup(reportsPnlLayout.createSequentialGroup()
                                        .addComponent(sophomoreChBox)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(juniorChBox)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(seniorChBox))))
                            .addGroup(reportsPnlLayout.createSequentialGroup()
                                .addComponent(idChBox, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fNameChBox)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lNameChBox)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(gradeChBox)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hoursChBox)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(csaChBox)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(reportsPnlLayout.createSequentialGroup()
                        .addGroup(reportsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rptPicLbl)
                            .addGroup(reportsPnlLayout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(rptSelectionTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rptSelectBtn)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(rptScrollPn, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE))
        );

        serviceHoursPnl.addTab("Reports", reportsPnl);

        printPnl.setBackground(new java.awt.Color(255, 255, 255));

        printTbl.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        printTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        printTbl.setSelectionBackground(new java.awt.Color(255, 153, 51));
        printTbl.setSelectionForeground(new java.awt.Color(0, 0, 0));
        printScrollPn.setViewportView(printTbl);

        printTblLbl.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        printTblLbl.setText("Displays the Last Printed Table");

        javax.swing.GroupLayout printPnlLayout = new javax.swing.GroupLayout(printPnl);
        printPnl.setLayout(printPnlLayout);
        printPnlLayout.setHorizontalGroup(
            printPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(printPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(printTblLbl)
                .addContainerGap(471, Short.MAX_VALUE))
            .addComponent(printScrollPn)
        );
        printPnlLayout.setVerticalGroup(
            printPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, printPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(printTblLbl)
                .addGap(18, 18, 18)
                .addComponent(printScrollPn, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE))
        );

        serviceHoursPnl.addTab("Recent Report", printPnl);

        getContentPane().add(serviceHoursPnl, java.awt.BorderLayout.CENTER);
        serviceHoursPnl.getAccessibleContext().setAccessibleName("Students' Hours");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /* Selects the rows in the report table when the select button is pressed based off of the selected check boxes and combo box.*/
    private void rptSelectBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rptSelectBtnActionPerformed
        boolean freshmanBox = freshmanChBox.isSelected();
        boolean sophmoreBox = sophomoreChBox.isSelected();
        boolean juniorBox = juniorChBox.isSelected();
        boolean seniorBox = seniorChBox.isSelected();

        boolean noneBox = noneChBox.isSelected();
        boolean communityBox = communityChBox.isSelected();
        boolean serviceBox = serviceChBox.isSelected();
        boolean achievementBox = achievementChBox.isSelected();

        String selectionType = rptSelectionTypeComboBox.getSelectedItem().toString();

        Report.selection(selectionType, freshmanBox, sophmoreBox, juniorBox, seniorBox, noneBox, serviceBox, communityBox, achievementBox);
        reportTbl.setModel(Refresh.getReportModel());
    }//GEN-LAST:event_rptSelectBtnActionPerformed

    /* Prints the report table when the print report button is pressed based off of the selected check boxes. */
    private void rptPrintBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rptPrintBtnActionPerformed
        boolean idBox = idChBox.isSelected();
        boolean fNameBox = fNameChBox.isSelected();
        boolean lNameBox = lNameChBox.isSelected();
        boolean gradeBox = gradeChBox.isSelected();
        boolean hoursBox = hoursChBox.isSelected();
        boolean csaCatBox = csaChBox.isSelected();

        Refresh.setReportModel((DefaultTableModel) reportTbl.getModel());

        try {    
            Report.setPrintModel(idBox, fNameBox, lNameBox, gradeBox, hoursBox, csaCatBox);
            printPrintTbl();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_rptPrintBtnActionPerformed

    /* Selects all of the rows in the report table when the select all button is pressed. */
    private void rptAllBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rptAllBtnActionPerformed
        Report.selectAll(true);
        reportTbl.setModel(Refresh.getReportModel());
    }//GEN-LAST:event_rptAllBtnActionPerformed

    /* Deselects all of the rows in the report table when the clear selection button is pressed. */
    private void rptClearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rptClearBtnActionPerformed
        Report.selectAll(false);
        reportTbl.setModel(Refresh.getReportModel());
    }//GEN-LAST:event_rptClearBtnActionPerformed

    /* Saves a copy of the database based on where the user choses when the save copy button is pressed. */
    private void dbCopyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dbCopyBtnActionPerformed
        Database.copyDB();
        refreshAll();
    }//GEN-LAST:event_dbCopyBtnActionPerformed

    /* Fills in the text boxes and combo boxes on the top of the students' data when a row of the students table is selected. */
    private void studentsTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentsTblMouseClicked
        idTxtFld.setText(studentsTbl.getValueAt(studentsTbl.getSelectedRow(), IDCOLUMN).toString());
        fNameTxtFld.setText(studentsTbl.getValueAt(studentsTbl.getSelectedRow(), FNAMECOLUMN).toString());
        lNameTxtFld.setText(studentsTbl.getValueAt(studentsTbl.getSelectedRow(), LNAMECOLUMN).toString());
        dbGradeBox.setSelectedItem(Convert.getGradeTblToBox(studentsTbl.getValueAt(studentsTbl.getSelectedRow(), GRADECOLUMN).toString()));
        dbCSABox.setSelectedItem(Convert.getcsaTblToBox(studentsTbl.getValueAt(studentsTbl.getSelectedRow(), CSACATCOLUMN).toString()));
    }//GEN-LAST:event_studentsTblMouseClicked

    /* Clears all of the text fields and resets the combo boxes on the top of the students' data tab when the clear button is pressed. */
    private void dbClearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dbClearBtnActionPerformed
        clearSelection();
        refreshAll();
    }//GEN-LAST:event_dbClearBtnActionPerformed

    /* Updates the selected row when the update button is pressed based of the data enterred in the text boxes and combo boxes. */
    private void dbUpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dbUpdateBtnActionPerformed
        String newID = idTxtFld.getText();
        String fName = fNameTxtFld.getText();
        String lName = lNameTxtFld.getText();
        String gradeStr = Convert.getGradeBoxToTbl(dbGradeBox.getSelectedItem().toString());
        String hoursStr = studentsTbl.getValueAt(studentsTbl.getSelectedRow(), HOURSCOLUMN).toString();
        String csaCat = Convert.getcsaBoxToTbl(dbCSABox.getSelectedItem().toString());

        Database.updateDB(newID, fName, lName, gradeStr, hoursStr, csaCat, studentsTbl.getSelectedRow());
        refreshAll();
    }//GEN-LAST:event_dbUpdateBtnActionPerformed

    /* Deletes the selected row when the delete button is pressed. */
    private void dbDelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dbDelBtnActionPerformed
        Database.deleteSQL(studentsTbl.getSelectedRow());
        refreshAll();
    }//GEN-LAST:event_dbDelBtnActionPerformed

    /* Inserts a new row when the insert button is pressed based off the data entered in the text fields and combo boxes. */
    private void dbInsertBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dbInsertBtnActionPerformed
        String idStr = idTxtFld.getText();
        String fName = fNameTxtFld.getText();
        String lName = lNameTxtFld.getText();
        String gradeStr = Convert.getGradeBoxToTbl(dbGradeBox.getSelectedItem().toString());
        String csaCat = Convert.getcsaBoxToTbl(dbCSABox.getSelectedItem().toString());

        Database.insertDB(idStr, fName, lName, gradeStr, "0", csaCat);
        refreshAll();
    }//GEN-LAST:event_dbInsertBtnActionPerformed

    /* Sets the selected student's hours when the set to button is pressed based of the number entered into the hours text field. */
    private void hoursSetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hoursSetBtnActionPerformed
        String hoursStr = hoursTxtFld.getText();

        Database.updateHours(hoursStr, studentsTbl.getSelectedRow(), "set");
        refreshAll();
    }//GEN-LAST:event_hoursSetBtnActionPerformed

    /* Subtracts the number entered into the hours text field from the selected studet's hours when the subtract button is pressed. */
    private void hoursSubBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hoursSubBtnActionPerformed
        String hoursStr = hoursTxtFld.getText();

        Database.updateHours(hoursStr, studentsTbl.getSelectedRow(), "-");
        refreshAll();
    }//GEN-LAST:event_hoursSubBtnActionPerformed

    /* Adds the number entered into the hours text field to the selected studet's hours when the add button is pressed. */
    private void hoursAddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hoursAddBtnActionPerformed
        String hoursStr = hoursTxtFld.getText();

        Database.updateHours(hoursStr, studentsTbl.getSelectedRow(), "+");
        refreshAll();
    }//GEN-LAST:event_hoursAddBtnActionPerformed

    /* Sets the currents connected database to the database the user selects. */
    private void dbSetLocationBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dbSetLocationBtnActionPerformed
        Database.setDBLocation();
        refreshAll();
    }//GEN-LAST:event_dbSetLocationBtnActionPerformed

    /* Tells the user to use the students' data tab when the view/edit studets' data radio button is pressed. */
    private void studentDataRdBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentDataRdBtnActionPerformed
        selectionTxtArea.setText(DATATAB);
    }//GEN-LAST:event_studentDataRdBtnActionPerformed

    /* Tells the user to use the students' data tab when the save a copy radio button is pressed. */
    private void copyDatabaseRdBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyDatabaseRdBtnActionPerformed
        selectionTxtArea.setText(DATATAB);
    }//GEN-LAST:event_copyDatabaseRdBtnActionPerformed

    /* Tells the user to use the students' data tab when the change current database radio button is pressed. */
    private void changeDatabaseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeDatabaseBtnActionPerformed
        selectionTxtArea.setText(DATATAB);
    }//GEN-LAST:event_changeDatabaseBtnActionPerformed

    /* Tells the user to use the reports tab when the print report radio button is pressed. */
    private void printRdBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printRdBtnActionPerformed
        selectionTxtArea.setText("Select the Reports Tab on the top\nof the window. If you need additional\nhelp, press the help Button above \nthe Table after selecting the\nReports Tab");
    }//GEN-LAST:event_printRdBtnActionPerformed

    /* Tells the user to use the recent report tab when the recent report radio button is pressed. */
    private void recentPrintRdBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recentPrintRdBtnActionPerformed
        selectionTxtArea.setText("Select the Recent Report Tab");
    }//GEN-LAST:event_recentPrintRdBtnActionPerformed

    /* Tells the user what email to contact if they have questions or concerns. */
    private void questionRdBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_questionRdBtnActionPerformed
        selectionTxtArea.setText("You can Contact me \nat albach6885@gmail.com");
    }//GEN-LAST:event_questionRdBtnActionPerformed

    /* Displays the reports tab help dialog when the report help button is pressed. */
    private void rptHelpBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rptHelpBtnActionPerformed
        Help.rptHelp();
    }//GEN-LAST:event_rptHelpBtnActionPerformed

    /* Displays the students' data help dialog when the database help button is pressed. */
    private void dbHelpBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dbHelpBtnActionPerformed
        Help.dataHelp();
    }//GEN-LAST:event_dbHelpBtnActionPerformed
        
    /* 
     * Refreshes the data in the report table and the students table based off the the data in the database.
     * Additionally, all the text fields and combo boxes are reset and the database location label is reset.
     */   
    private void refreshAll() { 
        Refresh.refreshAllData();
        reportTbl.setModel(Refresh.getReportModel());
        studentsTbl.setModel(Refresh.getStudentsModel());
        clearSelection();
        dbDatabaseLocationLbl.setText(DatabaseConnection.getDBLocation());
    }
    
    /* Prints the students data based off of the selected rows of the report table. */
    private void printPrintTbl() {
        printTbl.setModel(Report.getPrintModel());  
        TableColumnModel columnModel = printTbl.getColumnModel();
        
        printTbl.setVisible(true);
        
        int columnCount = printTbl.getColumnCount();
        for (int i = 0; i < columnCount; i++) {
            columnModel.getColumn(i).setPreferredWidth(125);
        }
       
        PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
        aset.add(OrientationRequested.LANDSCAPE);
        
        MessageFormat footerFormat = new MessageFormat("- {0} -");
        
        try {
            if (! printTbl.print(JTable.PrintMode.FIT_WIDTH, null, footerFormat, true, aset, true)) {
                JOptionPane.showMessageDialog(null, "User cancelled printing");
            }
        } catch (java.awt.print.PrinterException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } 
    }
    
    /* Resets the text boxes and the combo boexes on the top of the students' data tab. */
    private void clearSelection() {
        idTxtFld.setText("");
        fNameTxtFld.setText("");
        lNameTxtFld.setText("");
        hoursTxtFld.setText("");
        dbGradeBox.setSelectedItem("Freshman - 9th");
        dbCSABox.setSelectedItem("None");
        studentsTbl.getSelectionModel().clearSelection();
    }
    
    /**
     * @param args The command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HourTracker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new HourTracker().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox achievementChBox;
    private javax.swing.JRadioButton changeDatabaseBtn;
    private javax.swing.JLabel citeLbl;
    private javax.swing.JCheckBox communityChBox;
    private javax.swing.JRadioButton copyDatabaseRdBtn;
    private javax.swing.JLabel csaCatSortLbl;
    private javax.swing.JCheckBox csaChBox;
    private javax.swing.JLabel csaLbl;
    private javax.swing.JPanel databasePnl;
    private javax.swing.JComboBox<String> dbCSABox;
    private javax.swing.JButton dbClearBtn;
    private javax.swing.JButton dbCopyBtn;
    private javax.swing.JLabel dbDatabaseLocationLbl;
    private javax.swing.JLabel dbDatabaseLocationTitleLbl;
    private javax.swing.JButton dbDelBtn;
    private javax.swing.JComboBox<String> dbGradeBox;
    private javax.swing.JButton dbHelpBtn;
    private javax.swing.JButton dbInsertBtn;
    private javax.swing.JScrollPane dbScrollPn;
    private javax.swing.JButton dbSetLocationBtn;
    private javax.swing.JButton dbUpdateBtn;
    private javax.swing.JCheckBox fNameChBox;
    private javax.swing.JLabel fNameLbl;
    private javax.swing.JTextField fNameTxtFld;
    private javax.swing.JCheckBox freshmanChBox;
    private javax.swing.JCheckBox gradeChBox;
    private javax.swing.JLabel gradeLbl;
    private javax.swing.JLabel gradeSortLbl;
    private javax.swing.JButton hoursAddBtn;
    private javax.swing.JCheckBox hoursChBox;
    private javax.swing.JLabel hoursLbl;
    private javax.swing.JPanel hoursPnl;
    private javax.swing.JButton hoursSetBtn;
    private javax.swing.JButton hoursSubBtn;
    private javax.swing.JTextField hoursTxtFld;
    private javax.swing.JCheckBox idChBox;
    private javax.swing.JLabel idLbl;
    private javax.swing.JTextField idTxtFld;
    private javax.swing.JScrollPane introScrollPn;
    private javax.swing.JTextArea introTxtArea;
    private javax.swing.JCheckBox juniorChBox;
    private javax.swing.JCheckBox lNameChBox;
    private javax.swing.JLabel lNameLbl;
    private javax.swing.JTextField lNameTxtFld;
    private javax.swing.JCheckBox noneChBox;
    private javax.swing.JLabel printLbl;
    private javax.swing.JPanel printPnl;
    private javax.swing.JRadioButton printRdBtn;
    private javax.swing.JScrollPane printScrollPn;
    private javax.swing.JTable printTbl;
    private javax.swing.JLabel printTblLbl;
    private javax.swing.JRadioButton questionRdBtn;
    private javax.swing.JRadioButton recentPrintRdBtn;
    private javax.swing.JTable reportTbl;
    private javax.swing.JPanel reportsPnl;
    private javax.swing.JButton rptAllBtn;
    private javax.swing.JButton rptClearBtn;
    private javax.swing.JButton rptHelpBtn;
    private javax.swing.JLabel rptPicLbl;
    private javax.swing.JButton rptPrintBtn;
    private javax.swing.JScrollPane rptScrollPn;
    private javax.swing.JButton rptSelectBtn;
    private javax.swing.JComboBox<String> rptSelectionTypeComboBox;
    private javax.swing.JScrollPane selectionScrollPn;
    private javax.swing.JTextArea selectionTxtArea;
    private javax.swing.JCheckBox seniorChBox;
    private javax.swing.JCheckBox serviceChBox;
    private javax.swing.JTabbedPane serviceHoursPnl;
    private javax.swing.JCheckBox sophomoreChBox;
    private javax.swing.JRadioButton studentDataRdBtn;
    private javax.swing.JTable studentsTbl;
    private javax.swing.ButtonGroup tabSelectionBtnGrp;
    private javax.swing.JLabel tabSelectionLbl;
    private javax.swing.JLabel titleLbl;
    private javax.swing.JPanel welcomePnl;
    private javax.swing.JLabel whatToUseLbl;
    private javax.swing.JLabel wlcmPicLbl;
    // End of variables declaration//GEN-END:variables
}
