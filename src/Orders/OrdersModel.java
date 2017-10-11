package Orders;

import Entities.Orders;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class OrdersModel extends AbstractTableModel {
    
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
                return "date of ...";
            case 2:
                return "services id";
            case 3:
                return "suppliers id";
            case 4:
                return "personal id";
        }
        return null;
    }

    public Orders getSelectesItem(int row) {
        return list.get(row);
    }

    public static List<Orders> selectOrders(Connection c) throws SQLException{
        Statement statement = c.createStatement();
        List<Orders> partners = new ArrayList<>();
            ResultSet rs = statement.executeQuery("SELECT * FROM orders");
            while (rs.next()) {
                Orders item = new Orders(rs.getInt("idorders"), rs.getInt("servicesid"), 
                        rs.getInt("suppliersid"),rs.getString("dod"), rs.getInt("personid"));
                partners.add(item);
            }
            return partners;
    }
    
    public static Orders selectOrdersById(Connection c, int id) throws SQLException{
    Statement statement = c.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM orders WHERE idorders = "+id );
        Orders orders = null;
        while (rs.next()) {
           orders = new Orders(rs.getInt("idorders"), rs.getInt("servicesid"), 
                        rs.getInt("suppliersid"),rs.getString("dod"), rs.getInt("personid"));
        }
        return orders;
    }
    public void insertOrUpdate(Orders editItem, String servicesid, String suppliersid, String dod, String personid) {
        try {
            Statement statement = c.createStatement();
            if (editItem == null) {
                statement.executeUpdate("insert into orders "
                    + "(servicesid,suppliersid,dod,personid) "
                    + "values ('"
                    + servicesid + "','" + suppliersid
                    + "','" + dod + "','"
                    + personid + "');");
            } else {
                statement.executeUpdate("update orders set servicesid='"
                    + servicesid + "',suppliersid='"
                    + suppliersid +
                    "',dod='" + dod + "',personid='"
                    + personid + " where idorders="
                    + editItem.getIdorders() + ";");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
    } 
    
    public void delete(int id){
        try {
                Statement statement = c.createStatement();
                statement.executeUpdate("delete from orders where idorders="
                    + id + ";");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
            }
    }
}
