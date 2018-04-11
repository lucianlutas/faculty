package Presentation;

import Repository.ShowBLL;
import Repository.TicketBLL;
import Repository.UsersBLL;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class AdminFrame extends JFrame {

    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnShowCreate;
    private javax.swing.JButton btnShowDelete;
    private javax.swing.JButton btnShowUpdate;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnExport;
    private javax.swing.JTextField txtGenre;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblDistribution;
    private javax.swing.JLabel lblGenre;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblShowTitle;
    private javax.swing.JLabel lblTickets;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextArea txtDistribution;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtShowTitle;
    private javax.swing.JTextField txtTickets;
    private javax.swing.JTextField txtUsername;
    private LoginFrame login;
    private UsersBLL usersBLL;
    private ShowBLL showBLL;
    private TicketBLL ticketBLL;
    private String username;
    private String title;

    public AdminFrame(LoginFrame login) {
        this.login = login;
        usersBLL = new UsersBLL();
        showBLL = new ShowBLL();
        ticketBLL = new TicketBLL();
        initComponents();
    }

    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        lblTitle = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        lblUsername = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();
        btnCreate = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        lblShowTitle = new javax.swing.JLabel();
        txtShowTitle = new javax.swing.JTextField();
        lblDate = new javax.swing.JLabel();
        txtDate = new javax.swing.JTextField();
        lblDistribution = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtDistribution = new javax.swing.JTextArea();
        lblGenre = new javax.swing.JLabel();
        txtGenre = new javax.swing.JTextField();
        lblTickets = new javax.swing.JLabel();
        txtTickets = new javax.swing.JTextField();
        btnShowCreate = new javax.swing.JButton();
        btnShowUpdate = new javax.swing.JButton();
        btnShowDelete = new javax.swing.JButton();
        btnExport = new javax.swing.JButton();

        jTable3.getTableHeader().setReorderingAllowed(false);
        jTable4.getTableHeader().setReorderingAllowed(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitle.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTitle.setText("PseudoTheater - Admin");

        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        jTable3.setModel(usersBLL.populateCashiers());
        jScrollPane3.setViewportView(jTable3);
        if (jTable3.getColumnModel().getColumnCount() > 0) {
            jTable3.getColumnModel().getColumn(0).setResizable(false);
            jTable3.getColumnModel().getColumn(1).setResizable(false);
        }

        jTable3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                tblCashMouseClicked(evt);
            }
        });

        jTable4.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                tblShowMouseClicked(evt);
            }
        });
        lblUsername.setText("Username");

        lblPassword.setText("Password");

        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(btnCreate)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnUpdate)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnDelete))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblUsername)
                                                        .addComponent(lblPassword))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtUsername)
                                                        .addComponent(txtPassword))))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblUsername)
                                        .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblPassword)
                                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnCreate)
                                        .addComponent(btnUpdate)
                                        .addComponent(btnDelete))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cashiers", jPanel1);

        jTable4.setModel(showBLL.populateShows());
        jScrollPane4.setViewportView(jTable4);

        lblShowTitle.setText("Title");

        lblDate.setText("Date");

        lblDistribution.setText("Distribution");

        txtDistribution.setColumns(20);
        txtDistribution.setLineWrap(true);
        txtDistribution.setRows(5);
        jScrollPane5.setViewportView(txtDistribution);

        lblGenre.setText("Genre");

        lblTickets.setText("Tickets");

        btnShowCreate.setText("Create");
        btnShowCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowCreateActionPerformed(evt);
            }
        });

        btnShowUpdate.setText("Update");
        btnShowUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowUpdateActionPerformed(evt);
            }
        });

        btnShowDelete.setText("Delete");
        btnShowDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowDeleteActionPerformed(evt);
            }
        });

        btnExport.setText("Export");
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });



        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                                .addComponent(lblShowTitle)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(lblDate)
                                                                .addGap(11, 11, 11)))
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtDate)
                                                        .addComponent(txtShowTitle))
                                                .addGap(19, 19, 19))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(lblDistribution)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(lblGenre)
                                                                        .addComponent(lblTickets))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(txtGenre, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(txtTickets)))
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                        .addComponent(btnShowCreate, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                                                                        .addComponent(btnShowDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(btnShowUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                                                                        .addComponent(btnExport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblShowTitle)
                                        .addComponent(txtShowTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblDate)
                                        .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblDistribution)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblGenre)
                                        .addComponent(txtGenre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblTickets)
                                        .addComponent(txtTickets, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnShowCreate)
                                        .addComponent(btnShowUpdate))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnShowDelete)
                                        .addComponent(btnExport))
                                .addContainerGap(20, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Shows", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblTitle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnLogout)
                                .addContainerGap())
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 624, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblTitle)
                                        .addComponent(btnLogout))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, Short.MAX_VALUE))
        );

        pack();
        txtTickets.setText("100");
        txtTickets.setEnabled(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    private void tblShowMouseClicked(MouseEvent evt) {
        int i = jTable4.getSelectedRow();
        TableModel model = jTable4.getModel();
        txtShowTitle.setText(model.getValueAt(i,0).toString());
        txtGenre.setText(model.getValueAt(i,1).toString());
        txtDistribution.setText(model.getValueAt(i,2).toString());
        txtTickets.setText(model.getValueAt(i,3).toString());
        txtDate.setText(model.getValueAt(i,4).toString());
        title = model.getValueAt(i,0).toString();
    }

    private void btnDeleteActionPerformed(ActionEvent evt) {
        if(usersBLL.removeCashier(txtUsername.getText())){
            jTable3.setModel(usersBLL.populateCashiers());
        }
        else{
            JOptionPane.showMessageDialog(null, "One or more fields are empty!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnUpdateActionPerformed(ActionEvent evt) {

        if(usersBLL.updateCashier(username, txtUsername.getText(), txtPassword.getText())){
            jTable3.setModel(usersBLL.populateCashiers());
        }
        else{
            JOptionPane.showMessageDialog(null, "One or more fields are empty!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnCreateActionPerformed(ActionEvent evt) {
        if(usersBLL.addCashier(txtUsername.getText(), txtPassword.getText())){
            jTable3.setModel(usersBLL.populateCashiers());
        }
        else{
            JOptionPane.showMessageDialog(null, "Fields are empty or username already exists!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void tblCashMouseClicked(MouseEvent evt) {
        // TODO add your handling code here:
        int i = jTable3.getSelectedRow();
        TableModel model = jTable3.getModel();
        txtUsername.setText(model.getValueAt(i,0).toString());
        txtPassword.setText(model.getValueAt(i,1).toString());
        username = model.getValueAt(i,0).toString();
    }

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        this.dispose();
        login.setVisible(true);
    }

    private void btnShowCreateActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        if(showBLL.addShow(txtShowTitle.getText(), txtGenre.getText(), txtDistribution.getText(), Integer.parseInt(txtTickets.getText()), txtDate.getText())){
            jTable4.setModel(showBLL.populateShows());
        }
        else{
            JOptionPane.showMessageDialog(null, "Fields are empty or show already exists at that date!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnShowUpdateActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        if(showBLL.updateShow(title, txtShowTitle.getText(), txtGenre.getText(), txtDistribution.getText(), Integer.parseInt(txtTickets.getText()), txtDate.getText())){
            jTable4.setModel(showBLL.populateShows());
        }
        else{
            JOptionPane.showMessageDialog(null, "One or more fields are empty!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnShowDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        if(showBLL.removeShow(txtShowTitle.getText())){
            jTable4.setModel(showBLL.populateShows());
        }
        else{
            JOptionPane.showMessageDialog(null, "One or more fields are empty!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        ticketBLL.exportCsv(txtShowTitle.getText());
    }
}
