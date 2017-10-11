package Services;

import Entities.Services;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class ServicesModel extends AbstractTableModel {
    
    List<Services> list = new ArrayList<>();

    Connection c;
    
    public ServicesModel(Connection c) throws SQLException {
        super();
        this.c = c;
        list = selectServices(c);
        rowsCount = list.size();
    }

    public void updateData() throws SQLException {
        list = new ArrayList<>();
        list = selectServices(c);
        rowsCount = list.size();
    }
    
    int rowsCount = 5;
    int colCount = 4;
    
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
                return list.get(rowIndex).getidservices();
            case 1:
                return list.get(rowIndex).getname();
            case 2:
                return list.get(rowIndex).getdescription();
            case 3:
                return list.get(rowIndex).getvalue();
            
        }
        return null;
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "idservices";
            case 1:
                return "name";
            case 2:
                return "description";
            case 3:
                return "value";
           
        }
        return null;
    }

    public Services getSelectesItem(int row) {
        return list.get(row);
    }

    public static List<Services> selectServices(Connection c) throws SQLException{
        Statement statement = c.createStatement();
        List<Services> services = new ArrayList<>();
            ResultSet rs = statement.executeQuery("SELECT * FROM services");
            while (rs.next()) {
                Services item = new Services(rs.getInt("idservices"), rs.getString("name"), 
                        rs.getString("description"), rs.getString("value"));

                services.add(item);
            }
            return services;
    }
    
    public static Services selectServicesById(Connection c, int id) throws SQLException{
    Statement statement = c.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM services WHERE idservices = "+id );
        Services services = null;
        while (rs.next()) {
           services = new Services(rs.getInt("idservices"), rs.getString("name"), 
                        rs.getString("description"), rs.getString("value"));
        }
        return services;
    }
    public void insertOrUpdate(Services editItem, String name, String description, String value) {
        try {
            Statement statement = c.createStatement();
            if (editItem == null) {
                statement.executeUpdate("insert into services "
                    + "(name,description,value) "
                    + "values ('"
                    + name + "','" + description
                    + "','" + value + "');");
            } else {
                statement.executeUpdate("update services set name='"
                    + name + "',description='"
                    + description +
                    "',value='" + value + ";");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
    } 
    
    public void delete(int id){
        try {
                Statement statement = c.createStatement();
                statement.executeUpdate("delete from services where idservices="
                    + id + ";");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
            }
    }
}
