package Personal_information;

import Entities.Personal_information;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class Personal_informationModel extends AbstractTableModel {
    
    List<Personal_information> list = new ArrayList<>();

    Connection c;
    
    public Personal_informationModel(Connection c) throws SQLException {
        super();
        this.c = c;
        list = selectPersonal_information(c);
        rowsCount = list.size();
    }

    public void updateData() throws SQLException {
        list = new ArrayList<>();
        list = selectPersonal_information(c);
        rowsCount = list.size();
    }
    
    int rowsCount = 5;
    int colCount = 7;
    
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
                return list.get(rowIndex).getidperson();
            case 1:
                return list.get(rowIndex).getname();
            case 2:
                return list.get(rowIndex).getsurname();
            case 3:
                return list.get(rowIndex).getpatronymic();   
            case 4:
                return list.get(rowIndex).getaddress();
            case 5:
                return list.get(rowIndex).getnumber();
            case 6:
                return list.get(rowIndex).getdob();
        }
        return null;
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "idperson";
            case 1:
                return "name";
            case 2:
                return "surname";
            case 3:
                return "patronymic";
            case 4:
                return "address";
            case 5:
                return "number";
            case 6:
                return "dob";
        }
        return null;
    }

    public Personal_information getSelectesItem(int row) {
        return list.get(row);
    }

    public static List<Personal_information> selectPersonal_information(Connection c) throws SQLException{
        Statement statement = c.createStatement();
        List<Personal_information> personal_information = new ArrayList<>();
            ResultSet rs = statement.executeQuery("SELECT * FROM personal_information");
            while (rs.next()) {
                Personal_information item = new Personal_information(rs.getInt("idperson"), rs.getString("name"), 
                        rs.getString("surname"), rs.getString("patronymic"), 
                        rs.getString("address"), rs.getString("number"), rs.getString("dob"));

                personal_information.add(item);
            }
            return personal_information;
    }
    
    public static Personal_information selectPartnerById(Connection c, int id) throws SQLException{
    Statement statement = c.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM personal_information WHERE idperson = "+id );
        Personal_information personal_information = null;
        while (rs.next()) {
           personal_information = new Personal_information(rs.getInt("idperson"), rs.getString("name"), 
                        rs.getString("surname"), rs.getString("patronymic"), 
                        rs.getString("address"), rs.getString("number"), rs.getString("dob"));
        }
        return personal_information;
    }
    public void insertOrUpdate(Personal_information editItem,String name,String surname,String patronymic,String address,String number,String dob) {
        try {
            Statement statement = c.createStatement();
            if (editItem == null) {
                statement.executeUpdate("insert into personal_information "
                    + "(name,surname,patronymic,address,number, dob) "
                    + "values ('"
                    + name + "','" + surname
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                    + "','" + patronymic + "','"
                    + address+ "','" + number + "','" + dob + "');");
            } else {
                statement.executeUpdate("update personal_information set name='"
                    + name + "',surname='"
                    + surname +
                    "',patronymic='" + patronymic + "',address='"
                    + address +"',number='" + number +"',dob='" + dob + "' where idperson="
                    + editItem.getidperson() + ";");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
    } 
    
    public void delete(int id){
        try {
                Statement statement = c.createStatement();
                statement.executeUpdate("delete from personal_information where idperson="
                    + id + ";");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
            }
    }
}
