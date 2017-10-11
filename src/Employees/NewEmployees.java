
package Employees;

import Entities.Employees;
import Entities.Personal_information;
import Entities.Data;
import Personal_information.Personal_informationModel;
import Help.JTextFieldLimit;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;

public class NewEmployees extends javax.swing.JDialog {

    Connection c;
    Employees editItem;
    List<Personal_information> list;
    
    public NewEmployees(java.awt.Frame parent, boolean modal, Connection c) throws SQLException {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.c = c;
        list = new ArrayList<>();
        personid.setModel(new DefaultComboBoxModel(Personal_informationModel.selectPersonal_information(c).toArray()));
        
        //((AbstractDocument) personidtxtfield.getDocument()).setDocumentFilter(new JTextFieldLimit(30));
        ((AbstractDocument) positiontxtfield.getDocument()).setDocumentFilter(new JTextFieldLimit(30));
       
    }

    public NewEmployees(java.awt.Frame parent, boolean modal, Connection c, Employees u) throws SQLException {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.c = c;
        editItem = u;
        list = new ArrayList<>();
        personid.setModel(new DefaultComboBoxModel(Personal_informationModel.selectPersonal_information(c).toArray()));
        
        //((AbstractDocument) personidtxtfield.getDocument()).setDocumentFilter(new JTextFieldLimit(30));
        ((AbstractDocument) positiontxtfield.getDocument()).setDocumentFilter(new JTextFieldLimit(30));
        
        fillFields();
    }

    private void fillFields() {
        personidtxtfield.setText(String.valueOf(editItem.getpersonid()));
        positiontxtfield.setText(editItem.getposition());
        for (Personal_information s : list) {
            if (s.getidperson() == editItem.getpersonid()) {
                personid.setSelectedItem((s));
            }
        }
    }

    public boolean check() {
       
        if ("".equals(positiontxtfield.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "position has wrong format");
            return false;
        }
       
        return true;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jButtonOk = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        personidtxtfield = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        positiontxtfield = new javax.swing.JTextField();
        personid = new javax.swing.JComboBox<>();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButtonOk.setText("OK");
        jButtonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOkActionPerformed(evt);
            }
        });

        jLabel1.setText("Person id");

        personidtxtfield.setToolTipText("");
        personidtxtfield.setName(""); // NOI18N

        jLabel2.setText("Position");

        positiontxtfield.setToolTipText("");
        positiontxtfield.setName(""); // NOI18N

        personid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jButtonOk)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(positiontxtfield, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(personidtxtfield, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(personid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(personidtxtfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(personid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(positiontxtfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(74, 74, 74)
                .addComponent(jButtonOk)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOkActionPerformed

       if (!check()) {
            return;
        }
        try {
            EmployeesModel wm = new EmployeesModel(c);
            wm.insertOrUpdate(editItem, ((Personal_information) personid.getSelectedItem()).getidperson(), positiontxtfield.getText());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
            return;
        }
        dispose();
    }//GEN-LAST:event_jButtonOkActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonOk;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JComboBox<String> personid;
    private javax.swing.JTextField personidtxtfield;
    private javax.swing.JTextField positiontxtfield;
    // End of variables declaration//GEN-END:variables
}
