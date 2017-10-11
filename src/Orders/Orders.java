package Orders;
import Help.SizeSetter;
import java.awt.Frame;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class Orders extends javax.swing.JDialog {

    Connection connection;
    OrdersModel model;
    SizeSetter columnWidth;
    
    public Orders(java.awt.Frame parent, boolean modal, Connection c) throws SQLException {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        connection = c;

        model = new OrdersModel(connection);
        jTable1.setModel(model);
        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        columnWidth = new SizeSetter();
        columnWidth.resizeColumnWidth(jTable1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonADD = new javax.swing.JButton();
        jButtonALTER = new javax.swing.JButton();
        jButtonDELETE = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButtonADD.setText("ADD");
        jButtonADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonADDActionPerformed(evt);
            }
        });

        jButtonALTER.setText("ATLER");
        jButtonALTER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonALTERActionPerformed(evt);
            }
        });

        jButtonDELETE.setText("DELETE");
        jButtonDELETE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDELETEActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonADD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonALTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonDELETE, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonADD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonALTER)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDELETE)))
                .addContainerGap(116, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonADDActionPerformed
        NewOrders np = new NewOrders((Frame) this.getParent(), true, connection);
        np.setVisible(true);
        try {
            model.updateData();
        } catch (SQLException ex) {
            Logger.getLogger(Orders.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((AbstractTableModel) jTable1.getModel()).fireTableDataChanged();
    }//GEN-LAST:event_jButtonADDActionPerformed

    private void jButtonALTERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonALTERActionPerformed
        if (jTable1.getSelectedRow() >= 0) {
            NewOrders np = new NewOrders((Frame) this.getParent(), true, 
                    connection, model.getSelectesItem(jTable1.getSelectedRow()));
            np.setVisible(true);
            try {
                model.updateData();
            } catch (SQLException ex) {
                Logger.getLogger(Orders.class.getName()).log(Level.SEVERE, null, ex);
            }
            ((AbstractTableModel) jTable1.getModel()).fireTableDataChanged();
        }
    }//GEN-LAST:event_jButtonALTERActionPerformed

    private void jButtonDELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDELETEActionPerformed
        if (jTable1.getSelectedRow() >= 0) {
            model.delete(model.getSelectesItem(jTable1.getSelectedRow()).getIdorders());
        }
        try {
            model.updateData();
        } catch (SQLException ex) {
            Logger.getLogger(Orders.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((AbstractTableModel) jTable1.getModel()).fireTableDataChanged();
    }//GEN-LAST:event_jButtonDELETEActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonADD;
    private javax.swing.JButton jButtonALTER;
    private javax.swing.JButton jButtonDELETE;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
