package Suppliers;

import Entities.Suppliers;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class SuppliersModel extends AbstractTableModel {
    
    final static String selectStr="SELECT * FROM suppliers";
        static final String selectByIdStr = "SELECT * FROM suppliers WHERE idsuppliers =?;";
        final String insertStr = "insert into suppliers (idsuppliers,name,representative,address,number) values (nextval('seqorders'::regclass),?,?,?,?)";
        final String deleteStr = "delete from suppliers where idsuppliers=?";          
        final String updateStr = "update suppliers set name =?,representative =?,address =?,number =? where idsuppliers=?";
    
    List<Suppliers> list = new ArrayList<>();

    Connection c;
    
    public SuppliersModel(Connection c) throws SQLException {
        super();
        this.c = c;
        list = selectSuppliers(c);
        rowsCount = list.size();
    }

    public void updateData() throws SQLException {
        list = new ArrayList<>();
        list = selectSuppliers(c);
        rowsCount = list.size();
    }
    
    int rowsCount = 5;
    int colCount = 5;
    
    @Override
    public int getRowCount() {
        return rowsCount;
    }

    @Override
    public int getColumnCount() {
        return colCount;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getidsuppliers();
            case 1:
                return list.get(rowIndex).getname();
            case 2:
                return list.get(rowIndex).getrepresentative();
            case 3:
                return list.get(rowIndex).getaddress();
            case 4:
                return list.get(rowIndex).getnumber();
        }
        return null;
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "idsuppliers";
            case 1:
                return "name";
            case 2:
                return "representative";
            case 3:
                return "address";
            case 4:
                return "number";
        }
        return null;
    }

    public Suppliers getSelectesItem(int row) {
        return list.get(row);
    }

    public static List<Suppliers> selectSuppliers(Connection c) throws SQLException{
         PreparedStatement statement = c.prepareStatement(selectStr);
        ResultSet rs = statement.executeQuery();
        List<Suppliers> suppliers = new ArrayList<>(); 
        while (rs.next()) {
            Suppliers item = new Suppliers(rs.getInt("idsuppliers"), rs.getString("name"), 
                    rs.getString("representative"), rs.getString("address"), 
                    rs.getString("number"));
             suppliers.add(item);
            }
        return suppliers;
    }
    
    public static Suppliers selectSuppliersById(Connection c, int id) throws SQLException{
       PreparedStatement statement = c.prepareStatement(selectByIdStr);
        statement.setInt(1, id);
        ResultSet rs = statement.executeQuery();
        Suppliers suppliers = null;
            while (rs.next()) {
           suppliers = new Suppliers(rs.getInt("idsuppliers"), rs.getString("name"), 
                    rs.getString("representative"), rs.getString("address"), 
                    rs.getString("number"));
        }
        return suppliers;
    }
    public void insertOrUpdate(Suppliers editItem, String name, String representative, String address, String number) {
        try {
            if (editItem == null) {
                PreparedStatement statement = c.prepareStatement(insertStr);
                statement.setString(1, name);
                statement.setString(2, representative);
                statement.setString(3, address);
                statement.setString(4, number);
                statement.execute();    
            } else {
                PreparedStatement statement = c.prepareStatement(updateStr);
                statement.setString(1, name);
                statement.setString(2, representative);
                statement.setString(3, address);
                statement.setString(4, number);
                statement.setInt(5, editItem.getidsuppliers());
                statement.execute();   
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
    } 
    
    public void delete(int id){
        try {   
            PreparedStatement statement = c.prepareStatement(deleteStr);
            statement.setInt(1, id);
            statement.execute();    
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
            }
    }
}
