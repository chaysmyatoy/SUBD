package Orders;

import Entities.Orders;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class OrdersModel extends AbstractTableModel {
    
        final static String selectStr="SELECT * FROM orders";
        static final String selectByIdStr = "SELECT * FROM orders WHERE idorders =?;";
        final String insertStr = "insert into orders (idorders,servicesid,suppliersid,dod,personid) values (nextval('seqorders'::regclass),?,?,?,?)";
        final String deleteStr = "delete from orders where idorders=?";          
        final String updateStr = "update orders set servicesid =?,suppliersid =?,dod =?,personid =? where idorders=?";
        
    List<Orders> list = new ArrayList<>();

    Connection c;
    
    public OrdersModel(Connection c) throws SQLException {
        super();
        this.c = c;
        list = selectOrders(c);
        rowsCount = list.size();
    }

    public void updateData() throws SQLException {
        list = new ArrayList<>();
        list = selectOrders(c);
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
                return list.get(rowIndex).getIdorders();
            case 1:
                return list.get(rowIndex).getdod();
            case 2:
                return list.get(rowIndex).getservicesid();
            case 3:
                return list.get(rowIndex).getsuppliersid();
            case 4:
                return list.get(rowIndex).getpersonid();
        }
        return null;
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Idorders";
            case 1:
                return "services id";
            case 2:
                return "suppliers id";
            case 3:
                return "date of ...";
            case 4:
                return "personal id";
        }
        return null;
    }

    public Orders getSelectesItem(int row) {
        return list.get(row);
    }

    public static List<Orders> selectOrders(Connection c) throws SQLException{
         PreparedStatement statement = c.prepareStatement(selectStr);
        ResultSet rs = statement.executeQuery();
        List<Orders> orders = new ArrayList<>(); 
        while (rs.next()) {
            Orders item = new Orders(rs.getInt("idorders"), rs.getInt("servicesid"), 
                        rs.getInt("suppliersid"),rs.getString("dod"), rs.getInt("personid"));
             orders.add(item);
            }
        return orders;
    }
    
    public static Orders selectOrdersById(Connection c, int id) throws SQLException{
   PreparedStatement statement = c.prepareStatement(selectByIdStr);
        statement.setInt(1, id);
        ResultSet rs = statement.executeQuery();
        Orders orders = null;
            while (rs.next()) {
            orders = new Orders(rs.getInt("idorders"), rs.getInt("servicesid"), 
                        rs.getInt("suppliersid"),rs.getString("dod"), rs.getInt("personid"));
            }
        return orders;
    }
    public void insertOrUpdate(Orders editItem, int servicesid, int suppliersid, String dod, int personid) {
       try {
            if (editItem == null) {
                PreparedStatement statement = c.prepareStatement(insertStr);
                statement.setInt(1, servicesid);
                statement.setInt(2, suppliersid);
                statement.setDate(3, Date.valueOf(dod));
                statement.setInt(4, personid);
                statement.execute();    
            } else {
                PreparedStatement statement = c.prepareStatement(updateStr);
                statement.setInt(1, servicesid);
                statement.setInt(2, suppliersid);
                statement.setDate(3, Date.valueOf(dod));
                statement.setInt(4, personid);
                statement.setInt(5, editItem.getIdorders());
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
