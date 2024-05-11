/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Database.*;
import java.util.Date;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author meimei
 */
public class GiaoDichDAO {
    private static final String SELECT_ALL = "select * from GiaoDich where danhMucID != -1 order by id desc";
    private static final String INSERT_NEW = "insert into GiaoDich(danhMucID,nganSachID, note, money, createdDay) values (?, ?, ?, ?, ?);";
    private static final String DELETE = "delete from GiaoDich where id = ?";
    
    private static final String DELETEFROMNGANSACH = "delete from GiaoDich where nganSachID = ?";
    private static final String UPDATE = "update GiaoDich set danhMucID = ?, nganSachID = ?, note = ?, money = ?, createdDay = ? where id = ?";
    private static final String MONEYBYNGANSACHID = "select sum(money) from GiaoDich where nganSachID = ?";
    
    public static ArrayList<GiaoDich> filter(int danhMucID, int nganSachID, int thang, int nam) throws SQLException {
        String query = "select * from GiaoDich where danhMucID != -1";
        String condition = "";
        int count = 0;
        
        if (thang != -1) {
            condition = condition + " and MONTH(createdDay) = ?" ;
            count++;
        }
        
        if (nam != -1) {
            condition = condition + " and YEAR(createdDay) = ?";
            count++;
        }
        
        if (danhMucID != -1) {
            condition = condition + " and danhMucID = ?";
            count++;
        }
        
        if (nganSachID != -1) {
            condition = condition + " and nganSachID = ?";
            count++;
        }
        
        if (!condition.isEmpty()) {
            query = query + condition;
        }
        
        query = query + " order by id desc;";
        
        Connection connection = null; 
        
                        System.out.println(query);

        try {
            connection = ConnectDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            for (int i = 1; i <= count; i++) {
                if (thang != -1) {
                    preparedStatement.setInt(i, thang);
                    thang = -1;
                    continue;
                }
                
                if (nam != -1) {
                    preparedStatement.setInt(i, nam);
                    nam = -1;
                    continue;
                }
                
                if (danhMucID != -1) {
                    preparedStatement.setInt(i, danhMucID);
                    danhMucID = -1;
                    continue;
                }
                
                if (nganSachID != -1) {
                    preparedStatement.setInt(i, nganSachID);
                    nganSachID = -1;
                    continue;
                }
            }
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            ArrayList<GiaoDich> answer= new ArrayList<>();
            
            while(resultSet.next()){
                GiaoDich instance = new GiaoDich(
                        resultSet.getInt("id"),
                        resultSet.getInt("danhMucID"),
                        resultSet.getInt("nganSachID"),
                        resultSet.getString("note"),
                        resultSet.getDouble("money"),
                        resultSet.getDate("createdDay")
                );
                
                
                answer.add(instance);
            }
        
           return answer;
        } catch (Exception e) {
            e.printStackTrace();
        } 
        finally{
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        
        return null;
    }
    
    public static void removeGiaoDichByNganSach(int nganSachID) throws SQLException {
        Connection connection = null;
        try {
            connection = ConnectDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETEFROMNGANSACH);
            preparedStatement.setInt(1, nganSachID);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(connection != null){
                connection.close();
            }
        }
    }
    
    public static void delete(int id) throws SQLException {
        Connection connection = null;
        try {
            connection = ConnectDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(connection != null){
                connection.close();
            }
        }
    }
    
    public static double getAllMoney(int nganSachID) {
        double money = 0;
        Connection connection = null;
        try {
            connection = ConnectDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(MONEYBYNGANSACHID);
            preparedStatement.setInt(1, nganSachID);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                money = resultSet.getDouble(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return money;
    }
    
    public static void insert(GiaoDich gd) throws SQLException {
        Connection connection = null;
        try {
            connection = ConnectDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW);
            preparedStatement.setInt(1, gd.danhMucID);
            preparedStatement.setInt(2, gd.nganSachID);
            preparedStatement.setString(3, gd.note);
            preparedStatement.setDouble(4, gd.money);
            
            Date currentDate = new Date();

            java.sql.Date date;
            date = new java.sql.Date(currentDate.getTime());
            preparedStatement.setDate(5, date);
            
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(connection != null){
                connection.close();
            }
        }
    }
    
    public static void insertWithAnotherDate(GiaoDich gd) throws SQLException {
        Connection connection = null;
        try {
            connection = ConnectDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW);
            preparedStatement.setInt(1, gd.danhMucID);
            preparedStatement.setInt(2, gd.nganSachID);
            preparedStatement.setString(3, gd.note);
            preparedStatement.setDouble(4, gd.money);
            preparedStatement.setDate(5, gd.createdDay);
            
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(connection != null){
                connection.close();
            }
        }
    }
    
    public static void update(GiaoDich gd) throws SQLException {
        Connection connection = null;
        try {
            connection = ConnectDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            
            if (gd.danhMucID == -1) {
                preparedStatement.setNull(1, Types.INTEGER);

            } else {
                preparedStatement.setInt(1, gd.danhMucID);
            }

            preparedStatement.setInt(2, gd.nganSachID);
            preparedStatement.setString(3, gd.note);
            preparedStatement.setDouble(4, gd.money);
            
            java.sql.Date date;
            date = new java.sql.Date(gd.createdDay.getTime());
            preparedStatement.setDate(5, date);
            preparedStatement.setInt(6, gd.id);
            
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(connection != null){
                connection.close();
            }
        }
    }
    
    public static GiaoDich getByID(int id) throws SQLException {
        try {
            ArrayList<GiaoDich> giaoDichs = GiaoDichDAO.getAll();
            
            for (var giaoDich: giaoDichs) {
                if (giaoDich.id == id) {
                    return giaoDich;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return new GiaoDich();
    }
    
    public static ArrayList<GiaoDich> getAll() throws SQLException {
        Connection connection = null; 
        try {
            connection = ConnectDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            ArrayList<GiaoDich> answer= new ArrayList<>();
            
            while(resultSet.next()){
                GiaoDich instance = new GiaoDich(
                        resultSet.getInt("id"),
                        resultSet.getInt("danhMucID"),
                        resultSet.getInt("nganSachID"),
                        resultSet.getString("note"),
                        resultSet.getDouble("money"),
                        resultSet.getDate("createdDay")
                );
                
                answer.add(instance);
            }
        
            return answer;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } 
        finally{
            if(connection != null){
                connection.close();
            }
        }
    }
}
