package Action;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sumit Kumar
 */

import Helper.javaConnect;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Issue_Book extends javax.swing.JFrame {

    Connection conn;
    ResultSet rs;
    PreparedStatement pst;
    
    String issueDate;       // storing Date Of Issue field's data
    
    /**
     * Creates new form Issue_Book
     */
    public Issue_Book() {
        super("Issue Book");
        initComponents();
    }
    
            // check bookId, StudentId and issueDate are filled or not
    boolean validateData()
    {
        boolean b = false;
        
        issueDate = ((JTextField)jDateChooser1.getDateEditor().getUiComponent()).getText();
        
            // check book Id and Student id filled or not
            
            //if click on search button and the book id or student id correct then all the inforation automatically field 
            //but if enter anything book id or student id and not click on search button then... 
            // jTextField2 or jTextField7 is empty so also check it..
            
        if(jTextField1.getText().trim().isEmpty() || jTextField2.getText().isEmpty())
            JOptionPane.showMessageDialog(null, "Plese Enter Valid Book Id");
        else if(jTextField6.getText().trim().isEmpty() || jTextField7.getText().isEmpty())
            JOptionPane.showMessageDialog(null, "Plese Enter Valid Student Id");
        else if(issueDate.isEmpty())
            JOptionPane.showMessageDialog(null, "Plese Fill Date Of Issue Field");
        else
            b = true;
        
        return b;
    }
    
     // if previous data store in textfields and user want to issue one more book
     // user enter bookId but not click on search button and submit directly
     // this method checks all the text are valid or not for this new BookId
    boolean crossCheckBookDetails()    
    {
        boolean b = false;
        
        try
        {
            conn = javaConnect.ConnectDb();
            
            String sql = "select * from Book where Book_Id = ?";
            
            pst = conn.prepareStatement(sql);
            pst.setString(1, jTextField1.getText());
            rs = pst.executeQuery();
            if(rs.next())
            {
                if(!jTextField2.getText().equals(rs.getString("Name")))
                    JOptionPane.showMessageDialog(null, "Book Name Not Match With Given Book Id");
                else if(!jTextField3.getText().equals(rs.getString("Edition")))
                    JOptionPane.showMessageDialog(null, "Book Edition Not Match With Given Book Id");
                else if(!jTextField4.getText().equals(rs.getString("Publisher")))
                    JOptionPane.showMessageDialog(null, "Book Publisher Not Match With Given Book Id");
                if(!jTextField5.getText().equals(rs.getString("Price")))
                    JOptionPane.showMessageDialog(null, "Book Name Not Match With Given Book Id");
                else
                    b = true;
                
                rs.close();
                pst.close();
                conn.close();
                
            }
            else
                JOptionPane.showMessageDialog(null, "Book Id Does Not Match From Any Library Book");
            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        
        return b;
    }
    
    
     // if previous data store in textfields and user want to issue one more book
     // user enter StudentId but not click on search button and submit directly
     // this method checks all the text are valid or not for this new StudentId
    boolean crossCheckStudentDetails()
    {
        boolean b = false;
        
        try
        {
            conn = javaConnect.ConnectDb();
            
            String sql = "select * from Student where Student_Id = ?";
            
            pst = conn.prepareStatement(sql);
            pst.setString(1, jTextField6.getText());
            rs = pst.executeQuery();
            if(rs.next())
            {
                if(!jTextField7.getText().equals(rs.getString("Name")))
                    JOptionPane.showMessageDialog(null, "Student Name Not Match With Given Student Id");
                if(!jTextField8.getText().equals(rs.getString("Father_Name")))
                    JOptionPane.showMessageDialog(null, "Father Name Not Match With Given Student Id");
                if(!jTextField9.getText().equals(rs.getString("Course")))
                    JOptionPane.showMessageDialog(null, "Course Not Match With Given Student Id");
                if(!jTextField10.getText().equals(rs.getString("Branch")))
                    JOptionPane.showMessageDialog(null, "Branch Not Match With Given Student Id");
                if(!jTextField11.getText().equals(rs.getString("Year")))
                    JOptionPane.showMessageDialog(null, "Year Not Match With Given Student Id");
                if(!jTextField12.getText().equals(rs.getString("Semester")))
                    JOptionPane.showMessageDialog(null, "Semester Not Match With Given Student Id");
                else
                    b = true;
                
                rs.close();
                pst.close();
                conn.close();
                
            }
            else
                JOptionPane.showMessageDialog(null, "Student Id Does Not Match From Any Student Record");
            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        
        return b;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        search_book = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        search_student = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        issue = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)), "Book Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Monotype Corsiva", 0, 24), new java.awt.Color(0, 51, 204))); // NOI18N

        jTextField2.setEditable(false);

        jTextField5.setEditable(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Name");

        search_book.setText("Search");
        search_book.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_bookActionPerformed(evt);
            }
        });

        jTextField3.setEditable(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Edition");

        jTextField4.setEditable(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Publisher");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Book Id");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Price");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGap(93, 93, 93)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(search_book)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search_book))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)), "Student Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Monotype Corsiva", 0, 24), new java.awt.Color(0, 51, 204))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Student Id");

        jTextField9.setEditable(false);

        jTextField12.setEditable(false);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Semester");

        jTextField8.setEditable(false);

        jTextField11.setEditable(false);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Course");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Branch");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Year");

        jTextField7.setEditable(false);

        jTextField10.setEditable(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Name");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Father Name");

        search_student.setText("Search");
        search_student.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_studentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField12, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                    .addComponent(jTextField11)
                    .addComponent(jTextField10)
                    .addComponent(jTextField9)
                    .addComponent(jTextField8)
                    .addComponent(jTextField7)
                    .addComponent(jTextField6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(search_student, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(search_student)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Date Of Issue  :");

        back.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        issue.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        issue.setText("Issue");
        issue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                issueActionPerformed(evt);
            }
        });

        jDateChooser1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 33, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(issue, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(170, 170, 170))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(back))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(issue)
                .addGap(28, 28, 28))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        Home ob = new Home();
        ob.setVisible(true);
    }//GEN-LAST:event_backActionPerformed

    private void search_bookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_bookActionPerformed
        // TODO add your handling code here:
        
        if(jTextField1.getText().trim().isEmpty())  // check bookId entered or not before click on search button
            JOptionPane.showMessageDialog(null, "Plese Enter BookId");
        else
        {
            String sql = "select * from Book where Book_Id=?";      // tabel 'Book' primary key 'Book_Id'
            try
            {
                conn = javaConnect.ConnectDb();
                pst = conn.prepareStatement(sql);
                pst.setString(1, jTextField1.getText());
                rs = pst.executeQuery();
                if(rs.next())
                {
                    String add1 = rs.getString("Name");
                    jTextField2.setText(add1);
                    String add2 = rs.getString("Edition");
                    jTextField3.setText(add2);
                    String add3 = rs.getString("Publisher");
                    jTextField4.setText(add3);
                    String add4 = rs.getString("Price");
                    jTextField5.setText(add4);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Book_Id Not Found !!! \nPlese Enter Valid Book_Id...");
                    
                    // if user want issue more than one book
                    // he/she type new BookId and click on search button
                    // if bookId not exist so all previous text must be clear from textfields
                    jTextField2.setText("");
                    jTextField3.setText("");
                    jTextField4.setText("");
                    jTextField5.setText("");
                }
            }catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
            finally
            {
                try{
                    rs.close();
                    pst.close();
                    conn.close();
                }catch(Exception e){JOptionPane.showMessageDialog(null, e);}
            }
        }
    }//GEN-LAST:event_search_bookActionPerformed

    private void search_studentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_studentActionPerformed
        // TODO add your handling code here:
        
        if(jTextField6.getText().trim().isEmpty())  // check studentId entered or not before click on search button
            JOptionPane.showMessageDialog(null, "Plese Enter BookId");
        else
        {
            String sql = "select * from Student where Student_Id=?";
            try
            {
                conn = javaConnect.ConnectDb();
                pst = conn.prepareStatement(sql);
                pst.setString(1, jTextField6.getText());
                rs = pst.executeQuery();
                if(rs.next())
                {
                    String add1 = rs.getString("Name");
                    jTextField7.setText(add1);
                    String add2 = rs.getString("Father_Name");
                    jTextField8.setText(add2);
                    String add3 = rs.getString("Course");
                    jTextField9.setText(add3);
                    String add4 = rs.getString("Branch");
                    jTextField10.setText(add4);
                    String add5 = rs.getString("Year");
                    jTextField11.setText(add5);
                    String add6 = rs.getString("Semester");
                    jTextField12.setText(add6);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Student_Id Not Found!!! Enter Valid Student_Id");
                    
                    // if user want issue more than one book
                    // he/she type new StudentId and click on search button
                    // if StudentId not exist so all previous text must be clear from textfields
                    jTextField7.setText("");
                    jTextField8.setText("");
                    jTextField9.setText("");
                    jTextField10.setText("");
                    jTextField11.setText("");
                    jTextField12.setText("");
                }
            }catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
            finally
            {
                try
                {
                    rs.close();
                    pst.close();
                    conn.close();
                }catch(Exception e) { JOptionPane.showMessageDialog(null, e); }
            }
        }
    }//GEN-LAST:event_search_studentActionPerformed

    private void issueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_issueActionPerformed
        // TODO add your handling code here:
        
        if(validateData())
        {
            // check textFields data's are filled properly with according to bookId and studentId
            if(crossCheckBookDetails() && crossCheckStudentDetails())   
            {
                String sql = "insert into Issue_book(Book_Id, Name, Edition, Publisher, Price, Student_Id, S_Name, Father_Name, Course, Branch, Year, Semester, Issue_Date) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
                try
                {
                    conn = javaConnect.ConnectDb();
                    pst = conn.prepareStatement(sql);
                    pst.setString(1, jTextField1.getText());
                    pst.setString(2, jTextField2.getText());
                    pst.setString(3, jTextField3.getText());
                    pst.setString(4, jTextField4.getText());
                    pst.setString(5, jTextField5.getText());
                    pst.setString(6, jTextField6.getText());
                    pst.setString(7, jTextField7.getText());
                    pst.setString(8, jTextField8.getText());
                    pst.setString(9, jTextField9.getText());
                    pst.setString(10, jTextField10.getText());
                    pst.setString(11, jTextField11.getText());
                    pst.setString(12, jTextField12.getText());
                    pst.setString(13, issueDate);

                    pst.execute();
                    JOptionPane.showMessageDialog(null, "Book Issued");

                    pst.close();
                    conn.close();
                }catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
            else  // it means, previos data are present in textfields so... message for user to click on search button, for checking BookId Or StudentId Exist Or Not
                JOptionPane.showMessageDialog(null, "Plese Click On Search Button For Checking BookId Or StudentId Exist Or Not");
        }
    }//GEN-LAST:event_issueActionPerformed

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
            java.util.logging.Logger.getLogger(Issue_Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Issue_Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Issue_Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Issue_Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Issue_Book().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton issue;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JButton search_book;
    private javax.swing.JButton search_student;
    // End of variables declaration//GEN-END:variables
}
