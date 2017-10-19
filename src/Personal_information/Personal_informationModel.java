package Personal_information;

import Entities.Personal_information;
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

public class Personal_informationModel extends AbstractTableModel {
    
    
    final static String selectStr="SELECT * FROM personal_information";
        static final String selectByIdStr = "SELECT * FROM personal_information WHERE idperson =?;";
        final String insertStr = "insert into personal_information (idperson,name,surname,patronymic,address,number,dob) values (nextval('seqorders'::regclass),?,?,?,?,?,?)";
        final String deleteStr = "delete from personal_information where idperson=?";          
        final String updateStr = "update personal_information set name =?,surname =?,patronymic =?,address =?,number =?,dob =? where idperson = ?";
        
        
        
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
         PreparedStatement statement = c.prepareStatement(selectStr);
        ResultSet rs = statement.executeQuery();
        List<Personal_information> personal_information = new ArrayList<>(); 
        while (rs.next()) {
            Personal_information item = new Personal_information(rs.getInt("idperson"), rs.getString("name"), 
                        rs.getString("surname"), rs.getString("patronymic"), 
                        rs.getString("address"), rs.getString("number"), rs.getString("dob"));
             personal_information.add(item);
            }
        return personal_information;

    }
    
    public static Personal_information selectPartnerById(Connection c, int id) throws SQLException{
        
         PreparedStatement statement = c.prepareStatement(selectByIdStr);
        statement.setInt(1, id);
        ResultSet rs = statement.executeQuery();
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
            if (editItem == null) {
                PreparedStatement statement = c.prepareStatement(insertStr);
                statement.setString(1, name);
                statement.setString(2, surname);
                statement.setString(3, patronymic);
                statement.setString(4, address);
                 statement.setString(5, number);
                statement.setDate(6, Date.valueOf(dob));
                statement.execute();    
            } else {
                PreparedStatement statement = c.prepareStatement(updateStr);
                
                statement.setString(1, name);
                statement.setString(2, surname);
                statement.setString(3, patronymic);
                statement.setString(4, address);
                statement.setString(5, number);
                statement.setDate(6, Date.valueOf(dob));
                statement.setInt(7, editItem.getidperson());

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
