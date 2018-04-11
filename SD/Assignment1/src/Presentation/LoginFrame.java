package Presentation;
import Repository.UsersBLL;

import javax.swing.*;

public class LoginFrame extends JFrame{

    private JButton btnLogin;
    private JLabel lblPassword;
    private JLabel lblTitle;
    private JLabel lblUsername;
    private JPasswordField txtPassword;
    private JTextField txtUsername;

    public LoginFrame() {
        initComponents();
    }

    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitle.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTitle.setText("PseudoTheater");

        lblUsername.setText("Username");

        lblPassword.setText("Password");

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblTitle)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(btnLogin)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(lblPassword)
                                                                .addComponent(lblUsername))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(txtUsername)
                                                                .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)))))
                                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblTitle)
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblUsername)
                                        .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblPassword)
                                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(btnLogin)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();

        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.getRootPane().setDefaultButton(btnLogin);
    }
    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {
        UsersBLL usersBLL = new UsersBLL();
        int type = 0;

        type = usersBLL.checkLogin(txtUsername.getText(), String.valueOf(txtPassword.getPassword()));

        if(type == 0){
            // Error, non-existent account
            JOptionPane.showMessageDialog(null, "Account does not exist!", "Error", JOptionPane.ERROR_MESSAGE);
            txtPassword.setText("");
        }
        else if(type == 1){
            // Cashier
            this.setVisible(false);
            CashierFrame cashierFrameFrame = new CashierFrame(this);
            txtPassword.setText("");
        }
        else if(type == 2){
            // Admin
            this.setVisible(false);
            AdminFrame adminFrame = new AdminFrame(this);
            txtPassword.setText("");
        }
    }
}
