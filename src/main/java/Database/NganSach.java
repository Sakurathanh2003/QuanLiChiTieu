/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import Coordinator.AppCoordinator;
import java.io.IOException;

/**
 *
 * @author meimei
 */
public class NganSach {
    private int id;
    private String name;
    private double money; 
    
    public NganSach(int id, String name, double money) {
        this.id = id;
        this.name = name;
        this.money = money; 
    }

    public NganSach() {
        
    }
    
    // MARK: - Get
    public int getID() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public double getMoney() {
        return money;
    }
    
    // MARK: - Set
    public void setID(int id) {
        this.id = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Object[] toObjectArrayData() {
        Object[] answer = new Object[3];
        answer[0] = id;
        answer[1] = name;
        answer[2] = money;
        
        try {
            String currency = AppCoordinator.getCurrency();

            if (currency.equalsIgnoreCase("VND")) {
                answer[2] = answer[2] + "đ";
            } else {
                answer[2] = "$" + answer[2];
            }
        } catch (IOException e) {
                e.printStackTrace();
        }
        
        return answer;
    }
}
