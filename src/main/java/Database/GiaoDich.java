/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import Coordinator.AppCoordinator;
import DAO.DanhMucDAO;
import DAO.NganSachDAO;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author meimei
 */
public class GiaoDich {
    public int id;
    public int danhMucID;
    public int nganSachID;
    public String note;
    public double money;
    public Date createdDay;
    
    public GiaoDich(int id, int danhMucID, int nganSachID, String note, double money, Date createdDay) {
        this.id = id;
        this.danhMucID = danhMucID;
        this.nganSachID = nganSachID;
        this.note = note;
        this.money = money;
        this.createdDay = createdDay;
    }
    
    public GiaoDich() {
        
    }
    
    public Object[] toObjectArrayData() throws IOException {
        Object[] answer = new Object[5];
        answer[0] = id;
        answer[1] = money;
        answer[2] = note;
        answer[3] = createdDay;
        
        try {
            answer[4] = DanhMucDAO.getByID(danhMucID).getName();
        } catch (SQLException ex) {
            Logger.getLogger(GiaoDich.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String currency = AppCoordinator.getCurrency();
        
        if (currency.equalsIgnoreCase("VND")) {
            answer[1] += "đ";
        } else {
            answer[1] = "$" + answer[1];
        }
              
        return answer;
    }
}
