
package Orders;


import Services.ServicesModel;
import Personal_information.Personal_informationModel;
import Suppliers.SuppliersModel;
import Entities.Services;
import Entities.Personal_information;
import Entities.Suppliers;
import Entities.Orders;
import Help.JTextFieldLimit;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;

public class NewOrders extends javax.swing.JDialog {

    Connection c;
    Orders editItem;
    List<Services> list;
    List<Personal_information> list2;
    List<Suppliers> list1;
    
    public NewOrders(java.awt.Frame parent, boolean modal, Connection c) throws SQLException {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.c = c;
        
        ((AbstractDocument) dodtxtfield.getDocument()).setDocumentFilter(new JTextFieldLimit(30));
        list = new ArrayList<>();
        serviceid.setModel(new DefaultComboBoxModel(ServicesModel.selectServices(c).toArray()));
        list1 = new ArrayList<>();
        suppliersid.setModel(new DefaultComboBoxModel(SuppliersModel.selectSuppliers(c).toArray()));
         list2 = new ArrayList<>();
        personid.setModel(new DefaultComboBoxModel(Personal_informationModel.selectPersonal_information(c).toArray()));
        
        //((AbstractDocument) servicesidtxtfield.getDocument()).setDocumentFilter(new JTextFieldLimit(30));
        //((AbstractDocument) personidtxtfield.getDocument()).setDocumentFilter(new JTextFieldLimit(30));
        //((AbstractDocument) supplieridtxtfield.getDocument()).setDocumentFilter(new JTextFieldLimit(30));
    }

    public NewOrders(java.awt.Frame parent, boolean modal, Connection c, Orders u) throws SQLException {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.c = c;
        editItem = u;

        ((AbstractDocument) dodtxtfield.getDocument()).setDocumentFilter(new JTextFieldLimit(30));
        list = new ArrayList<>();
        serviceid.setModel(new DefaultComboBoxModel(ServicesModel.selectServices(c).toArray()));
        list1 = new ArrayList<>();
        suppliersid.setModel(new DefaultComboBoxModel(SuppliersModel.selectSuppliers(c).toArray()));
         list2 = new ArrayList<>();
        personid.setModel(new DefaultComboBoxModel(Personal_informationModel.selectPersonal_information(c).toArray()));
        //((AbstractDocument) servicesidtxtfield.getDocument()).setDocumentFilter(new JTextFieldLimit(30)); 
        //((AbstractDocument) personidtxtfield.getDocument()).setDocumentFilter(new JTextFieldLimit(30));
        //((AbstractDocument) supplieridtxtfield.getDocument()).setDocumentFilter(new JTextFieldLimit(30));
        fillFields();
    }

    private void fillFields() {
        dodtxtfield.setText(editItem.getdod());
         for (Services s : list) {
            if (s.getidservices() == editItem.getservicesid()) {
                serviceid.setSelectedItem((s));
            }
        }
        for (Suppliers s : list1) {
            if (s.getidsuppliers() == editItem.getsuppliersid()) {
                suppliersid.setSelectedItem((s));
            }
        }
         for (Personal_information s : list2) {
            if (s.getidperson() == editItem.getpersonid()) {
                personid.setSelectedItem((s));
            }
        //servicesidtxtfield.setText(String.valueOf(editItem.getservicesid()));
      //  personidtxtfield.setText(String.valueOf(editItem.getpersonid()));
       //supplieridtxtfield.setText(String.valueOf(editItem.getsuppliersid()));
    }}


    public boolean check() {
        if ("".equals(dodtxtfield.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "dod cannot be empty");
            return false;
        }
        return true;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonOk = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        dodtxtfield = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        serviceid = new javax.swing.JComboBox<>();
        suppliersid = new javax.swing.JComboBox<>();
        personid = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButtonOk.setText("OK");
        jButtonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOkActionPerformed(evt);
            }
        });

        jLabel1.setText("dod");

        dodtxtfield.setToolTipText("");
        dodtxtfield.setName(""); // NOI18N

        jLabel2.setText("servicesid");

        jLabel3.setText("suppliersid");

        jLabel4.setText("personid");

        serviceid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        suppliersid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        personid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jButtonOk))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(dodtxtfield, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(personid, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(suppliersid, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(serviceid, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(serviceid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(suppliersid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dodtxtfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(personid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonOk)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOkActionPerformed

       if (!check()) {
            return;
        }
        try {
            OrdersModel wm = new OrdersModel(c);
            wm.insertOrUpdate(editItem, 
                ((Services) serviceid.getSelectedItem()).getidservices(),
                ((Suppliers) suppliersid.getSelectedItem()).getidsuppliers(),
                dodtxtfield.getText(),
                ((Personal_information) personid.getSelectedItem()).getidperson());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
            return;
        }
        dispose();
    }//GEN-LAST:event_jButtonOkActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField dodtxtfield;
    private javax.swing.JButton jButtonOk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JComboBox<String> personid;
    private javax.swing.JComboBox<String> serviceid;
    private javax.swing.JComboBox<String> suppliersid;
    // End of variables declaration//GEN-END:variables
}
