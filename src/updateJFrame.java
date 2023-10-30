/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.ComboBoxModel;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement; 
import java.sql.ResultSet;
import java.sql.ResultSetMetaData; 
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List; 
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
public class updateJFrame extends javax.swing.JFrame {
    
    
    
    /**
     * Creates new form updateJFrame
     */
    private NewJFrame1 njf1;
    private NewJFrame2 njf2;
    private NewJFrame njf;
    private String admissionNumber;
    public updateJFrame() {
        initComponents();
        Connect();
        //Fetch_Student_Info(); 
        //Fetch_School_Info();
        //Fetch_Guardian_Info();
        Fetch();
        njf1 = new NewJFrame1(con,admissionNumber);
    }
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs; 
    
    public void Connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/normalization", "root", "Paologab@030802");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Fetch(){
        try {
            int q;
            pst = con.prepareStatement("SELECT * FROM student_info as stud, school_info as school, guardian_info as guard WHERE stud.Admission_Number = school.Admission_Number AND stud.Admission_Number = guard.Admission_Number ORDER BY stud.Admission_Number");
            rs = pst.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            q = rss.getColumnCount();
            
            DefaultTableModel RecordTable = (DefaultTableModel)StudAdTable.getModel();
            RecordTable.setRowCount(0); 
            while (rs.next()){
                Vector v2 = new Vector(); 
                for (int a= 1 ; a<=q ; a++){
                    v2.add(rs.getString("Admission_Number"));
                    v2.add(rs.getString("Name"));
                    v2.add(rs.getString("Campus"));
                    v2.add(rs.getString("Program"));
                    v2.add(rs.getString("Sex"));
                    v2.add(rs.getString("Birthday"));
                    v2.add(rs.getString("Birthplace"));
                    v2.add(rs.getString("Religion"));
                    v2.add(rs.getString("Nationality"));
                    v2.add(rs.getString("Permanent_Address"));
                    v2.add(rs.getString("City"));
                    v2.add(rs.getString("Postal_Code"));
                    v2.add(rs.getString("Contact_Number"));
                    v2.add(rs.getString("Email_Address")); 
                    v2.add(rs.getString("School_ID"));
                    v2.add(rs.getString("Name_of_Previous_School"));
                    v2.add(rs.getString("School_Address"));
                    v2.add(rs.getString("Start_Date"));
                    v2.add(rs.getString("End_Date"));
                    v2.add(rs.getString("Class_Standing"));
                    v2.add(rs.getString("Philsys_ID"));
                    v2.add(rs.getString("Guardian_Name"));
                    v2.add(rs.getString("Relationship"));
                    v2.add(rs.getString("Occupation"));
                    v2.add(rs.getString("G_Address"));
                    v2.add(rs.getString("G_Postal_Code"));
                    v2.add(rs.getString("G_City"));
                    v2.add(rs.getString("G_Contact_Number"));
                    v2.add(rs.getString("G_Email_Address"));
                }
                RecordTable.addRow(v2);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(updateJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SexGroup = new javax.swing.ButtonGroup();
        jScrollPane5 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Admission_Number = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Birthday = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        M = new javax.swing.JRadioButton();
        F = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        City = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Email_Address = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Campus = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        Religion = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        Nationality = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        Postal_Code = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        Program = new javax.swing.JTextField();
        Birthplace = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        Permanent_Address = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        Contact_Number = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        Name = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        Start_Date = new javax.swing.JTextField();
        End_Date = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        Class_standing = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        School_address = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        School_ID = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        Philsys_ID = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        Occupation = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        Relationship = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        G_address = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        G_city = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        G_Postal_code = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        G_Contact_Number = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        G_Email_address = new javax.swing.JTextField();
        Update_student_info = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        StudAdTable = new javax.swing.JTable();
        Delete_btn = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        Name_of_previous_school = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        Guardian_Name = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Admission Number: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 810, -1, -1));

        Admission_Number.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Admission_NumberActionPerformed(evt);
            }
        });
        jPanel1.add(Admission_Number, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 810, 170, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Birthday: ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 1080, -1, -1));
        jPanel1.add(Birthday, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 1080, 214, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Sex: ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 1110, -1, -1));

        SexGroup.add(M);
        M.setText("M");
        jPanel1.add(M, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 1110, -1, -1));

        SexGroup.add(F);
        F.setText("F");
        jPanel1.add(F, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 1110, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("City: ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 1140, -1, -1));
        jPanel1.add(City, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 1140, 214, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Email Address:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 1170, -1, -1));
        jPanel1.add(Email_Address, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 1170, 180, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Campus: ");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 1050, -1, -1));
        jPanel1.add(Campus, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 1050, 181, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Religion: ");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 1080, -1, -1));
        jPanel1.add(Religion, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 1080, 181, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Nationality:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 1110, -1, -1));
        jPanel1.add(Nationality, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 1110, 181, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Postal Code: ");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 1140, -1, -1));
        jPanel1.add(Postal_Code, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 1140, 181, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Place of Birth: ");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 1050, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Program:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 1170, -1, -1));
        jPanel1.add(Program, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 1170, 181, -1));

        Birthplace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BirthplaceActionPerformed(evt);
            }
        });
        jPanel1.add(Birthplace, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 1050, 181, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Permanent Address:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 1080, -1, -1));

        Permanent_Address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Permanent_AddressActionPerformed(evt);
            }
        });
        jPanel1.add(Permanent_Address, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 1080, 181, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Contact Number:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 1110, -1, -1));

        Contact_Number.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Contact_NumberActionPerformed(evt);
            }
        });
        jPanel1.add(Contact_Number, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 1110, 205, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Student Name: ");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 1050, -1, -1));

        Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameActionPerformed(evt);
            }
        });
        jPanel1.add(Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 1050, 190, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("From: ");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 1330, -1, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("To: ");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 1360, -1, -1));
        jPanel1.add(Start_Date, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 1330, 181, -1));

        End_Date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                End_DateActionPerformed(evt);
            }
        });
        jPanel1.add(End_Date, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 1360, 181, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("School ID: ");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 1330, -1, -1));

        Class_standing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Class_standingActionPerformed(evt);
            }
        });
        jPanel1.add(Class_standing, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 1390, 181, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("School Address: ");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 1390, -1, -1));

        School_address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                School_addressActionPerformed(evt);
            }
        });
        jPanel1.add(School_address, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 1390, 205, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Class Standing: ");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 1390, -1, -1));

        School_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                School_IDActionPerformed(evt);
            }
        });
        jPanel1.add(School_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 1330, 214, -1));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("PhilSys ID: ");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 1570, -1, -1));

        Philsys_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Philsys_IDActionPerformed(evt);
            }
        });
        jPanel1.add(Philsys_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 1570, 214, -1));

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Relationship: ");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 1630, -1, -1));

        Occupation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OccupationActionPerformed(evt);
            }
        });
        jPanel1.add(Occupation, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 1660, 214, -1));

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Occupation: ");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 1660, -1, -1));

        Relationship.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelationshipActionPerformed(evt);
            }
        });
        jPanel1.add(Relationship, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 1630, 214, -1));

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Address:");
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 1690, -1, -1));

        G_address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                G_addressActionPerformed(evt);
            }
        });
        jPanel1.add(G_address, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 1690, 214, -1));

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("City: ");
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 1570, -1, -1));

        G_city.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                G_cityActionPerformed(evt);
            }
        });
        jPanel1.add(G_city, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 1570, 214, -1));

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Postal Code: ");
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 1600, -1, -1));

        G_Postal_code.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                G_Postal_codeActionPerformed(evt);
            }
        });
        jPanel1.add(G_Postal_code, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 1600, 214, -1));

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Contact Number: ");
        jPanel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 1630, -1, -1));

        G_Contact_Number.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                G_Contact_NumberActionPerformed(evt);
            }
        });
        jPanel1.add(G_Contact_Number, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 1630, 214, -1));

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Email Address: ");
        jPanel1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 1660, -1, -1));

        G_Email_address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                G_Email_addressActionPerformed(evt);
            }
        });
        jPanel1.add(G_Email_address, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 1660, 214, -1));

        Update_student_info.setText("UPDATE");
        Update_student_info.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Update_student_infoActionPerformed(evt);
            }
        });
        jPanel1.add(Update_student_info, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 1860, -1, -1));

        StudAdTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Admission Number", "Name", "Campus", "Program", "Sex", "Birthday", "Birthplace", "Religion", "Nationality", "Permanent Address", "City", "Postal Code", "Contact Number", "Email Addresss", "School ID", "Name of Previous School", "School Address", "Start ", "End", "Class Standing", "Philsys ID", "Guardian Name", "Relationship", "Occupation", "Guardian Address", "Guardian Postal Code", "Guardian City", "Guardian Contact Number", "Guardian Email Address"
            }
        ));
        StudAdTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        StudAdTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                StudAdTableMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(StudAdTable);

        jPanel1.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 430, 1020, 340));

        Delete_btn.setText("DELETE");
        Delete_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Delete_btnActionPerformed(evt);
            }
        });
        jPanel1.add(Delete_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 1860, -1, -1));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Name of Previous School: ");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 1360, -1, -1));

        Name_of_previous_school.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Name_of_previous_schoolActionPerformed(evt);
            }
        });
        jPanel1.add(Name_of_previous_school, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 1360, 214, -1));

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Name of Guardian: ");
        jPanel1.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 1600, -1, -1));

        Guardian_Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Guardian_NameActionPerformed(evt);
            }
        });
        jPanel1.add(Guardian_Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 1600, 214, -1));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UpdateSectionInterface.png"))); // NOI18N
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1180, -1));

        jScrollPane5.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 1989, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void StudAdTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StudAdTableMouseClicked
        // TODO add your handling code here:
        DefaultTableModel RecordTable = (DefaultTableModel)StudAdTable.getModel();
        int SelectedRows = StudAdTable.getSelectedRow();

        Admission_Number.setText(RecordTable.getValueAt(SelectedRows, 0).toString());
        Name.setText(RecordTable.getValueAt(SelectedRows, 1).toString());
        Campus.setText(RecordTable.getValueAt(SelectedRows, 2).toString());
        Program.setText(RecordTable.getValueAt(SelectedRows, 3).toString());
        String sex = (RecordTable.getValueAt(SelectedRows, 4).toString());
        if (sex.equals("M")) {
            M.setSelected(true);
            F.setSelected(false);
        } else if (sex.equals("F")) {
            M.setSelected(false);
            F.setSelected(true);
        }
        Birthday.setText(RecordTable.getValueAt(SelectedRows, 5).toString());
        Birthplace.setText(RecordTable.getValueAt(SelectedRows, 6).toString());
        Religion.setText(RecordTable.getValueAt(SelectedRows, 7).toString());
        Nationality.setText(RecordTable.getValueAt(SelectedRows, 8).toString());
        Permanent_Address.setText(RecordTable.getValueAt(SelectedRows, 9).toString());
        City.setText(RecordTable.getValueAt(SelectedRows, 10).toString());
        Postal_Code.setText(RecordTable.getValueAt(SelectedRows, 11).toString());
        Contact_Number.setText(RecordTable.getValueAt(SelectedRows, 12).toString());
        Email_Address.setText(RecordTable.getValueAt(SelectedRows, 13).toString());
        School_ID.setText(RecordTable.getValueAt(SelectedRows, 14).toString());
        Name_of_previous_school.setText(RecordTable.getValueAt(SelectedRows, 15).toString());
        School_address.setText(RecordTable.getValueAt(SelectedRows, 16).toString());
        Start_Date.setText(RecordTable.getValueAt(SelectedRows, 17).toString());
        End_Date.setText(RecordTable.getValueAt(SelectedRows, 18).toString());
        Class_standing.setText(RecordTable.getValueAt(SelectedRows, 19).toString());
        Philsys_ID.setText(RecordTable.getValueAt(SelectedRows, 20).toString());
        Guardian_Name.setText(RecordTable.getValueAt(SelectedRows, 21).toString());
        Relationship.setText(RecordTable.getValueAt(SelectedRows, 22).toString());
        Occupation.setText(RecordTable.getValueAt(SelectedRows, 23).toString());
        G_address.setText(RecordTable.getValueAt(SelectedRows, 24).toString());
        G_Postal_code.setText(RecordTable.getValueAt(SelectedRows, 25).toString());
        G_city.setText(RecordTable.getValueAt(SelectedRows, 26).toString());
        G_Contact_Number.setText(RecordTable.getValueAt(SelectedRows, 27).toString());
        G_Email_address.setText(RecordTable.getValueAt(SelectedRows, 28).toString());  
  
    }//GEN-LAST:event_StudAdTableMouseClicked

    private void Update_student_infoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Update_student_infoActionPerformed
        try {
            
            if(con!=null){
                // TODO add your handling code here:
                String admissionNumber = Admission_Number.getText();
                String studentName = Name.getText();
                String birthday = Birthday.getText();
                String sex = "";
                if (M.isSelected()) {
                    sex = "M";
                } else if (F.isSelected()) {
                    sex = "F";
                }
                String city = City.getText();
                String emailAddress = Email_Address.getText();
                String campus = Campus.getText();
                String religion = Religion.getText();
                String nationality = Nationality.getText();
                String postalCode = Postal_Code.getText();
                String program = Program.getText();
                String birthplace = Birthplace.getText();
                String permanentAddress = Permanent_Address.getText();
                String contactNumber = Contact_Number.getText();

                pst = con.prepareStatement("UPDATE student_info SET Name=?, Birthday=?, Sex=?, City=?, Email_Address=?, Campus=?, Religion=?, Nationality=?, Postal_Code=?, Program=?, Birthplace=?, Permanent_Address=?, Contact_Number=? WHERE Admission_Number =?");
                
                pst.setString(1, studentName);
                pst.setString(2, birthday);
                pst.setString(3, sex);
                pst.setString(4, city);
                pst.setString(5, emailAddress);
                pst.setString(6, campus);
                pst.setString(7, religion);
                pst.setString(8, nationality);
                pst.setString(9, postalCode);
                pst.setString(10, program);
                pst.setString(11, birthplace);
                pst.setString(12, permanentAddress);
                pst.setString(13, contactNumber);
                pst.setString(14, admissionNumber);
                int studentRowsAffected = pst.executeUpdate();
  
                String schoolID = School_ID.getText();
                String startDate = Start_Date.getText();
                String endDate = End_Date.getText();
                String nameOfPreviousSchool = Name_of_previous_school.getText();
                String classStanding = Class_standing.getText();
                String schoolAddress = School_address.getText();

                // Execute update statement for school_info table
                pst = con.prepareStatement("UPDATE school_info SET Start_Date=?, End_Date=?, Name_of_previous_school=?, Class_standing=?, School_address=? WHERE School_ID=?");
                pst.setString(1, startDate);
                pst.setString(2, endDate);
                pst.setString(3, nameOfPreviousSchool);
                pst.setString(4, classStanding);
                pst.setString(5, schoolAddress);
                pst.setString(6, schoolID);
                int schoolRowsAffected = pst.executeUpdate();

                // Retrieve data for guardian_info
                String philsysID = Philsys_ID.getText();
                String guardianName = Guardian_Name.getText();
                String relationship = Relationship.getText();
                String occupation = Occupation.getText();
                String gAddress = G_address.getText();
                String gCity = G_city.getText();
                String gPostalCode = G_Postal_code.getText();
                String gContactNumber = G_Contact_Number.getText();
                String gEmailAddress = G_Email_address.getText();

                // Execute update statement for guardian_info table
                pst = con.prepareStatement("UPDATE guardian_info SET Guardian_Name=?, Relationship=?, Occupation=?, G_Address=?, G_Postal_Code=?, G_City=?, G_Contact_Number=?, G_Email_Address=? WHERE Philsys_ID =?");
                pst.setString(1, guardianName);
                pst.setString(2, relationship);
                pst.setString(3, occupation);
                pst.setString(4, gAddress);
                pst.setString(5, gPostalCode);
                pst.setString(6, gCity);
                pst.setString(7, gContactNumber);
                pst.setString(8, gEmailAddress);
                pst.setString(9, philsysID);
                int guardianRowsAffected = pst.executeUpdate();
                
                if (studentRowsAffected == 1 && schoolRowsAffected == 1 && guardianRowsAffected== 1) {
                    JOptionPane.showMessageDialog(this, "Record Updated");
                    
                    Admission_Number.setText("");
                    Name.setText("");
                    Birthday.setText("");
                    SexGroup.clearSelection();
                    City.setText("");
                    Email_Address.setText("");
                    Campus.setText("");
                    Religion.setText("");
                    Nationality.setText("");
                    Postal_Code.setText("");
                    Program.setText("");
                    Birthplace.setText("");
                    Permanent_Address.setText("");
                    Contact_Number.setText("");
                    School_ID.setText("");
                    Start_Date.setText("");
                    End_Date.setText("");
                    Name_of_previous_school.setText("");
                    Class_standing.setText("");
                    School_address.setText("");
                    Philsys_ID.setText("");
                    Guardian_Name.setText("");
                    Relationship.setText("");
                    Occupation.setText("");
                    G_address.setText("");
                    G_city.setText("");
                    G_Postal_code.setText("");
                    G_Contact_Number.setText("");
                    G_Email_address.setText("");

                }
            }

            else {
                JOptionPane.showMessageDialog(this, "Record Not Updated");
            }

        } catch (SQLException ex) {
            Logger.getLogger(updateJFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }

    }//GEN-LAST:event_Update_student_infoActionPerformed

    private void G_Email_addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_G_Email_addressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_G_Email_addressActionPerformed

    private void G_Contact_NumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_G_Contact_NumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_G_Contact_NumberActionPerformed

    private void G_Postal_codeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_G_Postal_codeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_G_Postal_codeActionPerformed

    private void G_cityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_G_cityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_G_cityActionPerformed

    private void G_addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_G_addressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_G_addressActionPerformed

    private void RelationshipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelationshipActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RelationshipActionPerformed

    private void OccupationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OccupationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OccupationActionPerformed

    private void Philsys_IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Philsys_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Philsys_IDActionPerformed

    private void School_IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_School_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_School_IDActionPerformed

    private void School_addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_School_addressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_School_addressActionPerformed

    private void Class_standingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Class_standingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Class_standingActionPerformed

    private void End_DateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_End_DateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_End_DateActionPerformed

    private void NameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameActionPerformed

    private void Contact_NumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Contact_NumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Contact_NumberActionPerformed

    private void Permanent_AddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Permanent_AddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Permanent_AddressActionPerformed

    private void BirthplaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BirthplaceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BirthplaceActionPerformed

    private void Admission_NumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Admission_NumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Admission_NumberActionPerformed

    private void Name_of_previous_schoolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Name_of_previous_schoolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Name_of_previous_schoolActionPerformed

    private void Guardian_NameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Guardian_NameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Guardian_NameActionPerformed

    private void Delete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Delete_btnActionPerformed
        // TODO add your handling code here:
        int selectedRow = StudAdTable.getSelectedRow();
    
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "No record selected for deletion.");
    } else {
        int confirmation = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this record?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
        
        if (confirmation == JOptionPane.YES_OPTION) {
            String admissionNumber = StudAdTable.getValueAt(selectedRow, 0).toString();
            try {
                // Delete record from the database
                pst = con.prepareStatement("DELETE FROM student_info WHERE Admission_Number = ?");
                pst.setString(1, admissionNumber);
                int rowsAffected = pst.executeUpdate();
                
                if (rowsAffected == 1) {
                    JOptionPane.showMessageDialog(this, "Record deleted successfully.");
                    DefaultTableModel model = (DefaultTableModel) StudAdTable.getModel();
                    model.removeRow(selectedRow);
                    
                    // Clear the form fields
                    Admission_Number.setText("");
                    Name.setText("");
                    Birthday.setText("");
                    SexGroup.clearSelection();
                    City.setText("");
                    Email_Address.setText("");
                    Campus.setText("");
                    Religion.setText("");
                    Nationality.setText("");
                    Postal_Code.setText("");
                    Program.setText("");
                    Birthplace.setText("");
                    Permanent_Address.setText("");
                    Contact_Number.setText("");
                    School_ID.setText("");
                    Start_Date.setText("");
                    End_Date.setText("");
                    Name_of_previous_school.setText("");
                    Class_standing.setText("");
                    School_address.setText("");
                    Philsys_ID.setText("");
                    Guardian_Name.setText("");
                    Relationship.setText("");
                    Occupation.setText("");
                    G_address.setText("");
                    G_city.setText("");
                    G_Postal_code.setText("");
                    G_Contact_Number.setText("");
                    G_Email_address.setText("");
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to delete record.");
                }
            } catch (SQLException ex) {
                Logger.getLogger(updateJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
        
    }//GEN-LAST:event_Delete_btnActionPerformed
    
    /**
     * @param args the command line arguments
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(updateJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(updateJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(updateJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(updateJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new updateJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Admission_Number;
    private javax.swing.JTextField Birthday;
    private javax.swing.JTextField Birthplace;
    private javax.swing.JTextField Campus;
    private javax.swing.JTextField City;
    private javax.swing.JTextField Class_standing;
    private javax.swing.JTextField Contact_Number;
    private javax.swing.JButton Delete_btn;
    private javax.swing.JTextField Email_Address;
    private javax.swing.JTextField End_Date;
    private javax.swing.JRadioButton F;
    private javax.swing.JTextField G_Contact_Number;
    private javax.swing.JTextField G_Email_address;
    private javax.swing.JTextField G_Postal_code;
    private javax.swing.JTextField G_address;
    private javax.swing.JTextField G_city;
    private javax.swing.JTextField Guardian_Name;
    private javax.swing.JRadioButton M;
    private javax.swing.JTextField Name;
    private javax.swing.JTextField Name_of_previous_school;
    private javax.swing.JTextField Nationality;
    private javax.swing.JTextField Occupation;
    private javax.swing.JTextField Permanent_Address;
    private javax.swing.JTextField Philsys_ID;
    private javax.swing.JTextField Postal_Code;
    private javax.swing.JTextField Program;
    private javax.swing.JTextField Relationship;
    private javax.swing.JTextField Religion;
    private javax.swing.JTextField School_ID;
    private javax.swing.JTextField School_address;
    private javax.swing.ButtonGroup SexGroup;
    private javax.swing.JTextField Start_Date;
    private javax.swing.JTable StudAdTable;
    private javax.swing.JButton Update_student_info;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    // End of variables declaration//GEN-END:variables
}
