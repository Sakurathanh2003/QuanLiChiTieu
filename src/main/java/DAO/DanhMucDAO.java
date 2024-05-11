/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Database.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author meimei
 */
public class DanhMucDAO {
    private static final String SELECT_ALL = "select * from DanhMuc";
    private static final String INSERT_NEW = "insert into DanhMuc(name) values (?)";
    private static final String UPDATE = "update DanhMuc set name = ? where id = ?";
    private static final String DELETE = "delete from DanhMuc where id = ?";
    
    private static final String NUMBEROFRECORD = "select count(id) from DanhMuc";
    
    public static int numberOfRecords() throws SQLException {
        Connection connection = null; 
        int ans = 0;
        try {
            connection = ConnectDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(NUMBEROFRECORD);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                ans = resultSet.getInt(1);
            }
        
        } catch (Exception e) {
            e.printStackTrace();
        } 
        finally{
            if(connection != null){
                connection.close();
            }
        }
        
        return ans;
    }
    
    public static DanhMuc getByID(int id) throws SQLException {
        try {
            ArrayList<DanhMuc> danhMucs = DanhMucDAO.getAll();
            
            for (var danhMuc: danhMucs) {
                if (danhMuc.getID() == id) {
                    return danhMuc;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return new DanhMuc();
    }
    
    public static boolean isExits(String name) throws SQLException {
        try {
            ArrayList<DanhMuc> danhMucs = DanhMucDAO.getAll();
            
            for (var danhMuc: danhMucs) {
                if (danhMuc.getName().equals(name)) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
    public static void delete(int id) throws SQLException {
        Connection connection = null;
        try {
            connection = ConnectDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            
            if (DanhMucDAO.numberOfRecords() == 0) {
                DanhMuc instance = new DanhMuc();
                instance.setName("Ăn uống");
                DanhMucDAO.insert(instance);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(connection != null){
                connection.close();
            }
        }
    }
    
    public static void update(DanhMuc danhMuc) throws SQLException {
        Connection connection = null;
        try {
            connection = ConnectDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setInt(2, danhMuc.getID());
            preparedStatement.setString(1, danhMuc.getName());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(connection != null){
                connection.close();
            }
        }
    }
            
    public static void insert(DanhMuc danhMuc) throws SQLException {
        Connection connection = null;
        try {
            connection = ConnectDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW);
            preparedStatement.setString(1, danhMuc.getName());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(connection != null){
                connection.close();
            }
        }
    }
    
     public static ArrayList<DanhMuc> getAll() throws SQLException{
        Connection connection = null;
        try {
            connection = ConnectDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            ArrayList<DanhMuc> answer= new ArrayList<>();
            
            while(resultSet.next()){
                DanhMuc instance = new DanhMuc(
                resultSet.getInt("id"),
                resultSet.getString("name")
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
