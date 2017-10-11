package Employees;

import Entities.Employees;
import Employees.NewEmployees;
import Entities.Data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class EmployeesModel extends AbstractTableModel {
    
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
        Statement statement = c.createStatement();
        List<Employees> employees = new ArrayList<>();
            ResultSet rs = statement.executeQuery("SELECT * FROM employees");
            while (rs.next()) {
                Employees item = new Employees(rs.getInt("personid"), rs.getString("position"));

                employees.add(item);
            }
            return employees;
    }
    
    public static Employees selectEmployeesById(Connection c, int id) throws SQLException{
    Statement statement = c.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM employees WHERE personid = "+ id );
        Employees employees = null;
        while (rs.next()) {
           employees = new Employees(rs.getInt("personid"), rs.getString("position"));
        }
        return employees;
    }
    public void insertOrUpdate(Employees editItem,String personid,String position) {
        try {
            Statement statement = c.createStatement();
            if (editItem == null) {
                statement.executeUpdate("insert into employees "
                    + "(position,personid) "
                    + "values ('"
                    + position + "','" + personid + "');");
            } else {
                statement.executeUpdate("update employees set "
                    + "position='"
                    + position + "' where personid="
                    + editItem.getpersonid() + ";");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
    } 
    
    public void delete(int id){
        try {
                Statement statement = c.createStatement();
                statement.executeUpdate("delete from employees where personid="
                    + id + ";");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
            }
    }
}
