/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author myoss
 */
public class LogIn extends javax.swing.JFrame {

    /**
     * Creates new form LogIn
     */
    public LogIn() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        CardNumber = new javax.swing.JTextField();
        signIn = new javax.swing.JButton();
        Clear = new javax.swing.JButton();
        signUp = new javax.swing.JButton();
        password = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(931, 621));
        setResizable(false);
        setSize(new java.awt.Dimension(930, 620));
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Card Number : ");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(180, 130, 190, 60);

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
        jLabel3.setText("Password : ");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(180, 270, 140, 60);

        CardNumber.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        CardNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CardNumberActionPerformed(evt);
            }
        });
        getContentPane().add(CardNumber);
        CardNumber.setBounds(420, 140, 250, 60);

        signIn.setBackground(new java.awt.Color(255, 102, 255));
        signIn.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        signIn.setText("Sign in");
        signIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signInActionPerformed(evt);
            }
        });
        getContentPane().add(signIn);
        signIn.setBounds(210, 400, 100, 40);

        Clear.setBackground(new java.awt.Color(255, 102, 255));
        Clear.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        Clear.setText("Clear");
        Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearActionPerformed(evt);
            }
        });
        getContentPane().add(Clear);
        Clear.setBounds(520, 400, 100, 40);

        signUp.setBackground(new java.awt.Color(255, 102, 255));
        signUp.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        signUp.setText("Sign up");
        signUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpActionPerformed(evt);
            }
        });
        getContentPane().add(signUp);
        signUp.setBounds(310, 480, 200, 40);

        password.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        getContentPane().add(password);
        password.setBounds(420, 280, 250, 60);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\myoss\\Downloads\\rsz_1test.jpg")); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 930, 620);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CardNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CardNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CardNumberActionPerformed

    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearActionPerformed
        // TODO add your handling code here:
        CardNumber.setText("");
        password.setText("");
    }//GEN-LAST:event_ClearActionPerformed

    private void signInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signInActionPerformed
        // TODO add your handling code here
        System s=new System();
        s.setUser_id(Integer.parseInt(CardNumber.getText()));
        s.setPassword(Integer.parseInt(password.getText()));
        try {
            s.login(Integer.parseInt(CardNumber.getText()),Integer.parseInt(password.getText()));
            this.dispose();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_signInActionPerformed

    private void signUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUpActionPerformed
        // TODO add your handling code here:
        signUp view =new signUp();
         view.setVisible(true);
         view.setLocation(300, 100);
         this.dispose();
    }//GEN-LAST:event_signUpActionPerformed

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
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LogIn view =new LogIn();
                view.setVisible(true);
                view.setLocation(300, 100);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField CardNumber;
    private javax.swing.JButton Clear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField password;
    private javax.swing.JButton signIn;
    private javax.swing.JButton signUp;
    // End of variables declaration//GEN-END:variables
}
