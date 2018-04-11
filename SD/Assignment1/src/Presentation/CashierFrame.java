package Presentation;

import Repository.ShowBLL;
import Repository.TicketBLL;
import com.mysql.jdbc.log.Log;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CashierFrame extends JFrame {

    private javax.swing.JButton btnAvFilter;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnSell;
    private javax.swing.JButton btnSoDelete;
    private javax.swing.JButton btnSoFilter;
    private javax.swing.JButton btnSoUpdate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JLabel lblAvColumn;
    private javax.swing.JLabel lblAvRow;
    private javax.swing.JLabel lblAvShow;
    private javax.swing.JLabel lblSoColumn;
    private javax.swing.JLabel lblSoRow;
    private javax.swing.JLabel lblSoShow;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField txtAvColumn;
    private javax.swing.JTextField txtAvRow;
    private javax.swing.JTextField txtAvShow;
    private javax.swing.JTextField txtSoColumn;
    private javax.swing.JTextField txtSoRow;
    private javax.swing.JTextField txtSoShow;
    private LoginFrame login;
    private String showTitle;
    private TicketBLL ticketBLL;
    private ShowBLL showBLL;
    private int col;
    private int row;

    public CashierFrame(LoginFrame login) {
        this.login = login;
        initComponents();

        ticketBLL = new TicketBLL();
        showBLL = new ShowBLL();
    }

    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        lblTitle = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        lblAvColumn = new javax.swing.JLabel();
        lblAvRow = new javax.swing.JLabel();
        txtAvColumn = new javax.swing.JTextField();
        txtAvRow = new javax.swing.JTextField();
        btnSell = new javax.swing.JButton();
        lblAvShow = new javax.swing.JLabel();
        txtAvShow = new javax.swing.JTextField();
        btnAvFilter = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        btnSoUpdate = new javax.swing.JButton();
        btnSoDelete = new javax.swing.JButton();
        lblSoColumn = new javax.swing.JLabel();
        lblSoRow = new javax.swing.JLabel();
        txtSoColumn = new javax.swing.JTextField();
        txtSoRow = new javax.swing.JTextField();
        lblSoShow = new javax.swing.JLabel();
        txtSoShow = new javax.swing.JTextField();
        btnSoFilter = new javax.swing.JButton();

        //jTable3.setModel(ticketBLL.populateTickets(showTitle,0));
        jTable3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                tblAvMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        //jTable4.setModel(ticketBLL.populateTickets(showTitle,1));
        jTable4.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                tblSoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitle.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTitle.setText("PseudoTheater - Cashier");

        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Seat Column", "Seat Row"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable3);
        if (jTable3.getColumnModel().getColumnCount() > 0) {
            jTable3.getColumnModel().getColumn(0).setResizable(false);
            jTable3.getColumnModel().getColumn(1).setResizable(false);
        }

        lblAvColumn.setText("Seat Column");

        lblAvRow.setText("Seat Row");

        btnSell.setText("Sell");
        btnSell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSellActionPerformed(evt);
            }
        });

        lblAvShow.setText("Show");

        btnAvFilter.setText("Filter");
        btnAvFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvFilterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnAvFilter)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                        .addComponent(lblAvShow)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(txtAvShow))
                                                .addComponent(btnSell, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(lblAvColumn)
                                                                .addComponent(lblAvRow))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(txtAvColumn, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                                                                .addComponent(txtAvRow)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblAvColumn)
                                        .addComponent(txtAvColumn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblAvRow)
                                        .addComponent(txtAvRow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSell)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblAvShow)
                                        .addComponent(txtAvShow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAvFilter)
                                .addContainerGap())
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Available", jPanel1);

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Seat Column", "Seat Row"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTable4);
        if (jTable4.getColumnModel().getColumnCount() > 0) {
            jTable4.getColumnModel().getColumn(0).setResizable(false);
            jTable4.getColumnModel().getColumn(1).setResizable(false);
        }

        btnSoUpdate.setText("Update");
        btnSoUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSoUpdateActionPerformed(evt);
            }
        });

        btnSoDelete.setText("Cancel");
        btnSoDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSoDeleteActionPerformed(evt);
            }
        });

        lblSoColumn.setText("Seat Column");

        lblSoRow.setText("Seat Row");

        lblSoShow.setText("Show");

        btnSoFilter.setText("Filter");
        btnSoFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSoFilterActionPerformed(evt);
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
                                                        .addComponent(lblSoColumn)
                                                        .addComponent(lblSoRow))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtSoRow)
                                                        .addComponent(txtSoColumn)))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(btnSoUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnSoDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(lblSoShow)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtSoShow, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(btnSoFilter)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblSoColumn)
                                        .addComponent(txtSoColumn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblSoRow)
                                        .addComponent(txtSoRow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnSoUpdate)
                                        .addComponent(btnSoDelete))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblSoShow)
                                        .addComponent(txtSoShow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSoFilter)
                                .addContainerGap())
        );

        jTabbedPane1.addTab("Sold", jPanel2);

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
                        .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblTitle)
                                        .addComponent(btnLogout))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTabbedPane1))
        );

        pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    private void tblSoMouseClicked(MouseEvent evt) {
        int i = jTable4.getSelectedRow();
        TableModel model = jTable4.getModel();
        txtSoColumn.setText(model.getValueAt(i,1).toString());
        txtSoRow.setText(model.getValueAt(i,0).toString());
        col = Integer.parseInt(txtSoColumn.getText());
        row = Integer.parseInt(txtSoRow.getText());
    }

    private void tblAvMouseClicked(MouseEvent evt) {
        int i = jTable3.getSelectedRow();
        TableModel model = jTable3.getModel();
        txtAvColumn.setText(model.getValueAt(i,1).toString());
        txtAvRow.setText(model.getValueAt(i,0).toString());
        System.out.println(i);
    }

    private void btnAvFilterActionPerformed(ActionEvent evt) {
        showTitle = txtAvShow.getText();
        txtSoShow.setText(showTitle);
        jTable3.setModel(ticketBLL.populateTickets(showTitle, 0));
        jTable4.setModel(ticketBLL.populateTickets(showTitle, 1));
    }

    private void btnSoFilterActionPerformed(ActionEvent evt) {
        showTitle = txtSoShow.getText();
        txtAvShow.setText(showTitle);
        jTable3.setModel(ticketBLL.populateTickets(showTitle, 0));
        jTable4.setModel(ticketBLL.populateTickets(showTitle, 1));
    }

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        this.dispose();
        login.setVisible(true);
    }

    private void btnSoUpdateActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        int resp = ticketBLL.updateReservation(Integer.parseInt(txtSoColumn.getText()), Integer.parseInt(txtSoRow.getText()), col, row, showTitle);
        if(resp == 1){
            jTable3.setModel(ticketBLL.populateTickets(showTitle, 0));
            jTable4.setModel(ticketBLL.populateTickets(showTitle, 1));
        } else if(resp == -1){
            JOptionPane.showMessageDialog(null, "One or more fields are empty!", "Error", JOptionPane.ERROR_MESSAGE);
        } else if(resp == 0){
            JOptionPane.showMessageDialog(null, "That ticket is already sold", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnSoDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        if(ticketBLL.cancelReservation(Integer.parseInt(txtSoColumn.getText()), Integer.parseInt(txtSoRow.getText()), showTitle)){
            jTable3.setModel(ticketBLL.populateTickets(showTitle,0));
            jTable4.setModel(ticketBLL.populateTickets(showTitle,1));
            txtSoRow.setText("");
            txtSoColumn.setText("");
        } else{
            JOptionPane.showMessageDialog(null, "One or more fields are empty!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnSellActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        if(ticketBLL.addReservation(Integer.parseInt(txtAvColumn.getText()), Integer.parseInt(txtAvRow.getText()), showTitle)){
            jTable3.setModel(ticketBLL.populateTickets(showTitle,0));
            jTable4.setModel(ticketBLL.populateTickets(showTitle,1));
            txtAvRow.setText("");
            txtAvColumn.setText("");
        } else{
            JOptionPane.showMessageDialog(null, "One or more fields are empty!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
