/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrumproject;

import java.awt.Checkbox;
import java.awt.event.ItemEvent;
import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author donniegebrail
 */
public class EmployeePageAdmin extends javax.swing.JFrame {
    
    private static InfDB idb;

    /**
     * Creates new form EmployeePage
     */
    public EmployeePageAdmin() {
        initComponents();
        
         try{
        //Connects to database with an absolute path
            Path path = Paths.get("ScrumProject.FDB").toRealPath(LinkOption.NOFOLLOW_LINKS);
            idb = new InfDB(path.toString());
        }catch(InfException | IOException e){
           JOptionPane.showMessageDialog(null, e);
        }
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        btnChangeInformation = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        chkRegAdmin = new javax.swing.JCheckBox();
        btnReg = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtRegName = new javax.swing.JTextField();
        txtRegPhone = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtRegEmail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtRegPw = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtAllNames = new javax.swing.JTextField();
        txtAllPhone = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtAllEmail = new javax.swing.JTextField();
        doAdmin = new javax.swing.JCheckBox();
        btnConfirmChange = new javax.swing.JButton();
        cbAllEmployees = new javax.swing.JComboBox<>();
        btnReturnToStartPage = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnChangeInformation.setText("Ändra kontaktuppgifter");
        btnChangeInformation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnChangeInformationMouseClicked(evt);
            }
        });

        jLabel1.setText("Namn:");

        jLabel2.setText("Telefon:");

        jLabel3.setText("Email:");

        txtName.setEditable(false);

        txtPhone.setEditable(false);

        txtEmail.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnChangeInformation)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(8, 8, 8))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                            .addComponent(txtPhone)
                            .addComponent(txtEmail))))
                .addContainerGap(255, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(btnChangeInformation)
                .addContainerGap(98, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Mina kontakuppgifter", jPanel1);

        chkRegAdmin.setText("Registrera som administratör");

        btnReg.setText("Registrera");
        btnReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegActionPerformed(evt);
            }
        });

        jLabel10.setText("Namn:");

        jLabel11.setText("Telefon:");

        jLabel12.setText("Email:");

        jLabel7.setText("Lösenord:");

        txtRegPw.setBackground(new java.awt.Color(240, 240, 240));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(chkRegAdmin)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnReg, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtRegPw, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel11)
                                        .addComponent(jLabel12))
                                    .addGap(8, 8, 8))
                                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGap(6, 6, 6)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtRegPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtRegEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtRegName, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 0, 0))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRegName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRegPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRegEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtRegPw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addComponent(chkRegAdmin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnReg)
                .addGap(52, 52, 52))
        );

        jTabbedPane1.addTab("Registrera", jPanel2);

        jLabel4.setText("Namn:");

        txtAllNames.setEditable(false);

        txtAllPhone.setEditable(false);

        jLabel5.setText("Telefon:");

        jLabel6.setText("Email:");

        txtAllEmail.setEditable(false);

        doAdmin.setText("Gör till administratör ");

        btnConfirmChange.setText("Bekräfta");
        btnConfirmChange.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConfirmChangeMouseClicked(evt);
            }
        });

        cbAllEmployees.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", " " }));
        cbAllEmployees.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbAllEmployeesItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(39, 39, 39)
                        .addComponent(txtAllNames, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(doAdmin)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addGap(42, 42, 42)
                            .addComponent(txtAllEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txtAllPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnConfirmChange)
                            .addComponent(cbAllEmployees, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(231, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbAllEmployees, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAllNames, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(txtAllPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAllEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(doAdmin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(btnConfirmChange)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Ändra anställd kontaktuppgifter", jPanel3);

        btnReturnToStartPage.setText("Tillbaka");
        btnReturnToStartPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnToStartPageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnReturnToStartPage)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnReturnToStartPage)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReturnToStartPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnToStartPageActionPerformed
        StartPage startPage = new StartPage(); 
        this.setVisible(false); 
        startPage.setVisible(true);
    }//GEN-LAST:event_btnReturnToStartPageActionPerformed

    private void btnRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegActionPerformed
        
        //if(Validation.checkIfTxtIsEmpty(txtRegName));
        //if(Validation.checkIfTxtIsEmpty(txtRegPhone));
        //if(Validation.checkIfTxtIsEmpty(txtRegEmail));
        //if(Validation.checkIfTxtIsEmpty(txtRegPw));
        //Check if the textfields is empty.
        try{
            
        String name = txtRegName.getText();
        String phone = txtRegPhone.getText();
        String pw = txtRegPw.getText();
        String email = txtRegEmail.getText();
        //Get values from the textfields to String.
        
        String admin = "1";
        String notAdmin = "0";
        
        String increment = idb.getAutoIncrement("EMPLOYEE", "EMPLOYEEID");
        //Automatic EmpleyeeID.
        
             if(chkRegAdmin.isSelected()==true) //If the checkbox for admin is checked.
                {
                  String sql = "INSERT INTO EMPLOYEE VALUES ('" + increment + "', '" + name + "', '" + email + "', " + admin + ", '" + pw + "', '" + phone + "')";
                  idb.insert(sql);
                  JOptionPane.showMessageDialog(null, "Anställd tillagd som admin!");
                }  
                  else { //If the checkbox isn't checked.
                          String sql1 = "INSERT INTO EMPLOYEE VALUES ('" + increment + "', '" + name + "', '" + email + "', " + notAdmin + ", '" + pw + "', '" + phone + "')";
                         idb.insert(sql1);  
                          JOptionPane.showMessageDialog(null, "Anställd tillagd!");
                       }
        
        txtRegName.setText("");
        txtRegPhone.setText("");
        txtRegEmail.setText("");
        txtRegPw.setText("");
        //Making the textfields empty again.
           }
           catch (InfException e){
        JOptionPane.showMessageDialog(null, "Fel!" + e);
                                 }    
    }//GEN-LAST:event_btnRegActionPerformed

    private void btnChangeInformationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChangeInformationMouseClicked
        String name = txtName.getText();
        String phone = txtPhone.getText();
        String email = txtEmail.getText();
        Validation validation = new Validation();
        
        try {
            if (validation.checkIfTxtIsEmpty(email) == true || validation.checkIfTxtIsEmpty(name) == true || validation.checkIfTxtIsEmpty(phone) == true) {
                JOptionPane.showMessageDialog(null, "Vänligen fyll i alla fält");
            } else if (validation.validateEmail(email) == false) {
                JOptionPane.showMessageDialog(null, "Vänligen fyll i en giltig email");
            } else if (validation.checkEmailExists(email) == true && !txtEmail.getText().equals(validation.getUserEmail(Validation.getIdInlogged() ))) {
                JOptionPane.showMessageDialog(null, "Emailen du angett existerar redan, välj en ny!");
            } else{
                String sql ="Update EMPLOYEE set NAME = '" + name + "', PHONE = '"+ phone +"', Email = '"+ email +"' where EMPLOYEEID = " + Validation.getIdInlogged();
                idb.update(sql);
                JOptionPane.showMessageDialog(null, "Du har uppdaterat dina kontaktuppgifter!");
            }
        } catch (Exception e) {
               JOptionPane.showMessageDialog(null, "Uppdatering Misslyckad!");
        }
    }//GEN-LAST:event_btnChangeInformationMouseClicked

    private void cbAllEmployeesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbAllEmployeesItemStateChanged
        Object item = evt.getItem();
        Validation val = new Validation();
        
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            String invited = item.toString();
            String [] splitt = invited.split(", ");
            String id = splitt[1];
            txtAllNames.setText(val.getUserName(id));
            txtAllPhone.setText(val.getUserTelefon(id));
            txtAllEmail.setText(val.getUserEmail(id));
            if(val.checkIfChosenIsAdmin(id) == false){
            doAdmin.setSelected(false);
            }else{
            doAdmin.setSelected(true);
            }
        }
        
    }//GEN-LAST:event_cbAllEmployeesItemStateChanged

    private void btnConfirmChangeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirmChangeMouseClicked
        String name = txtAllNames.getText();
        String phone = txtAllPhone.getText();
        String email = txtAllEmail.getText();
        Validation validation = new Validation();
        boolean checkbox = doAdmin.isSelected();
        String isAdmin = "";
        
        if(checkbox == false){
            isAdmin = "0";
        }else{
            isAdmin = "1";
        }
        Object item = cbAllEmployees.getSelectedItem();
        String invited = item.toString();
        String [] splitt = invited.split(", ");
        String id = splitt[1];
        
        try {
            if (validation.checkIfTxtIsEmpty(email) == true || validation.checkIfTxtIsEmpty(name) == true || validation.checkIfTxtIsEmpty(phone) == true) {
                JOptionPane.showMessageDialog(null, "Vänligen fyll i alla fält");
            } else if (validation.validateEmail(email) == false) {
                JOptionPane.showMessageDialog(null, "Vänligen fyll i en giltig email");
            } else if (validation.checkEmailExists(email) == true && !txtAllEmail.getText().equals(validation.getUserEmail(id))) {
                JOptionPane.showMessageDialog(null, "Emailen du angett existerar redan, välj en ny!");
            } else{
                String sql ="Update EMPLOYEE set NAME = '" + name + "', PHONE = '"+ phone +"', Email = '"+ email +"', isAdmin = " + isAdmin + " where EMPLOYEEID = " + id;
                idb.update(sql);
                JOptionPane.showMessageDialog(null, "Du har uppdaterat dina kontaktuppgifter!");
            }
        } catch (Exception e) {
               JOptionPane.showMessageDialog(null, "Uppdatering Misslyckad!");
        }
    }//GEN-LAST:event_btnConfirmChangeMouseClicked

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
            java.util.logging.Logger.getLogger(EmployeePageAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeePageAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeePageAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeePageAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeePageAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChangeInformation;
    private javax.swing.JButton btnConfirmChange;
    private javax.swing.JButton btnReg;
    private javax.swing.JButton btnReturnToStartPage;
    public javax.swing.JComboBox<String> cbAllEmployees;
    private javax.swing.JCheckBox chkRegAdmin;
    public javax.swing.JCheckBox doAdmin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    public javax.swing.JTextField txtAllEmail;
    public javax.swing.JTextField txtAllNames;
    public javax.swing.JTextField txtAllPhone;
    public javax.swing.JTextField txtEmail;
    public javax.swing.JTextField txtName;
    public javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtRegEmail;
    private javax.swing.JTextField txtRegName;
    private javax.swing.JTextField txtRegPhone;
    private javax.swing.JTextField txtRegPw;
    // End of variables declaration//GEN-END:variables
}
