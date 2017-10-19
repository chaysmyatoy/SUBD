package Employees;

import Entities.Employees;
import Employees.NewEmployees;
import Entities.Data;

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

public class EmployeesModel extends AbstractTableModel {
    
    
     
        final static String selectStr="SELECT * FROM employees";
        static final String selectByIdStr = "SELECT * FROM employees WHERE personid =?;";
        final String insertStr = "insert into employees (position,personid) values (?,?)";
        final String deleteStr = "delete from employees where personid=?";          
        final String updateStr = "update employees set position=? where personid=? ";
        
    List<Employees> list = new ArrayList<>();

    Connection c;
    
    public EmployeesModel(Connection c) throws SQLException {
        super();
        this.c = c;
        list = selectEmployees(c);
        rowsCount = list.size();
    }

    public void updateData() throws SQLException {
        list = new ArrayList<>();
        list = selectEmployees(c);
        rowsCount = list.size();
    }
    
    int rowsCount = 2;
    int colCount = 2;
    
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
                return list.get(rowIndex).getpersonid();
            case 1:
                return list.get(rowIndex).getposition();
            
        }
        return null;
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "personid";
            case 1:
                return "position";

        }
        return null;
    }

    public Employees getSelectesItem(int row) {
        return list.get(row);
    }

    public static List<Employees> selectEmployees(Connection c) throws SQLException{
       PreparedStatement statement = c.prepareStatement(selectStr);
        ResultSet rs = statement.executeQuery();
        List<Employees> employees = new ArrayList<>(); 
        while (rs.next()) {
            Employees item = new Employees(rs.getInt("personid"), rs.getString("position"));
            employees.add(item);
            }
        return employees;
    }
    
    public static Employees selectEmployeesById(Connection c, int id) throws SQLException{
    PreparedStatement statement = c.prepareStatement(selectByIdStr);
        statement.setInt(1, id);
        ResultSet rs = statement.executeQuery();
        Employees employees = null;
            while (rs.next()) {
            employees = new Employees( rs.getInt("personid"), rs.getString("position"));
            }
        return employees;
    }
    
    public void insertOrUpdate(Employees editItem,int personid,String position) {
       try {
            if (editItem == null) {
                PreparedStatement statement = c.prepareStatement(insertStr);
                statement.setString(1, position);
                statement.setInt(2, personid);
                statement.execute();    
            } else {
                PreparedStatement statement = c.prepareStatement(updateStr);
                statement.setString(1, position);
                statement.setInt(2, personid);
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
