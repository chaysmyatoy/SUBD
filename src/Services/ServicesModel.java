package Services;

import Entities.Services;
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

public class ServicesModel extends AbstractTableModel {
    
    
    
    final static String selectStr="SELECT * FROM services";
        static final String selectByIdStr = "SELECT * FROM services WHERE idservices =?;";
        final String insertStr = "insert into services (idservices,name,description,value) values (nextval('seqorders'::regclass),?,?,?)";
        final String deleteStr = "delete from services where idservices=?";          
        final String updateStr = "update services set name =?,description =?,value =? where idservices = ?";
        
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
          PreparedStatement statement = c.prepareStatement(selectStr);
        ResultSet rs = statement.executeQuery();
        List<Services> services = new ArrayList<>(); 
        while (rs.next()) {
            Services item = new Services(rs.getInt("idservices"), rs.getString("name"), 
                        rs.getString("description"), rs.getString("value"));
             services.add(item);
            }
        return services;
    }
    
    public static Services selectServicesById(Connection c, int id) throws SQLException{
        
         PreparedStatement statement = c.prepareStatement(selectByIdStr);
        statement.setInt(1, id);
        ResultSet rs = statement.executeQuery();
        Services services = null;
            while (rs.next()) {
           services = new Services(rs.getInt("idservices"), rs.getString("name"), 
                        rs.getString("description"), rs.getString("value"));
        }
        return services;
        

    }
    public void insertOrUpdate(Services editItem, String name, String description, String value) {
       try {
            if (editItem == null) {
                PreparedStatement statement = c.prepareStatement(insertStr);
                statement.setString(1, name);
                statement.setString(2, description);
                statement.setString(3, value);

                statement.execute();    
            } else {
                PreparedStatement statement = c.prepareStatement(updateStr);
                statement.setString(1, name);
                statement.setString(2, description);
                statement.setString(3, value);
                statement.setInt(4, editItem.getidservices());
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
