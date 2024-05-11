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
public class NganSachDAO {
    private static final String SELECT_ALL = "select * from NganSach";
    private static final String INSERT_NEW = "insert into NganSach(name) values (?)";
    private static final String UPDATE = "update NganSach set name = ? where id = ?";
    private static final String DELETE = "delete from NganSach where id = ?";
    private static final String NEWINSTANCE = "select * from NganSach order by id desc limit 1";
    
    private static final String NUMBEROFRECORD = "select count(id) from NganSach";
    
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
    
    public static NganSach getByID(int id) throws SQLException {
        try {
            ArrayList<NganSach> nganSachs = NganSachDAO.getAll();
            
            for (var nganSach: nganSachs) {
                if (nganSach.getID() == id) {
                    return nganSach;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return new NganSach();
    }
    
    public static NganSach latestRecord() throws SQLException {
        Connection connection = null; 
        try {
            connection = ConnectDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(NEWINSTANCE);
            ResultSet resultSet = preparedStatement.executeQuery();
                        
            while(resultSet.next()){
                double money = GiaoDichDAO.getAllMoney(resultSet.getInt("id"));
                NganSach instance = new NganSach(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                    money
                );
                
                return instance;
            }
        
            return null;
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
    
    public static boolean isExits(String name) throws SQLException {
        try {
            ArrayList<NganSach> nganSachs = NganSachDAO.getAll();
            
            for (var nganSach: nganSachs) {
                if (nganSach.getName().equals(name)) {
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
            
            GiaoDichDAO.removeGiaoDichByNganSach(id);
            
            if (NganSachDAO.numberOfRecords() == 0) {
                NganSach instance = new NganSach();
                instance.setName("Tiền mặt");
                NganSachDAO.insert(instance, 0.0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(connection != null){
                connection.close();
            }
        }
    }
            
    public static void insert(NganSach nganSach, double money) throws SQLException {
        Connection connection = null;
        try {
            connection = ConnectDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW);
            preparedStatement.setString(1, nganSach.getName());
            preparedStatement.executeUpdate();
            NganSach newVer = NganSachDAO.latestRecord();
            
            GiaoDich gd = new GiaoDich();
            gd.money = money;
            gd.nganSachID = newVer.getID();
            gd.note = "Them ngan sach " + newVer.getID();
            gd.danhMucID = -1;
            GiaoDichDAO.insert(gd);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(connection != null){
                connection.close();
            }
        }
    }
    
    public static void update(NganSach nganSach, double money) throws SQLException {
        Connection connection = null;
        try {
            connection = ConnectDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setInt(2, nganSach.getID());
            preparedStatement.setString(1, nganSach.getName());
            preparedStatement.executeUpdate();
            
            double oldMoney = GiaoDichDAO.getAllMoney(nganSach.getID());
            GiaoDich gd = new GiaoDich();
            gd.money = money - oldMoney;
            gd.nganSachID = nganSach.getID();
            gd.note = "Sua ngan sach " + nganSach.getID();
            gd.danhMucID = -1;
            GiaoDichDAO.insert(gd);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(connection != null){
                connection.close();
            }
        }
    }
    
    public static ArrayList<NganSach> getAll() throws SQLException {
        Connection connection = null; 
        try {
            connection = ConnectDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            ArrayList<NganSach> answer= new ArrayList<>();
            
            while(resultSet.next()){
                double money = GiaoDichDAO.getAllMoney(resultSet.getInt("id"));
                NganSach instance = new NganSach(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                    money
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
