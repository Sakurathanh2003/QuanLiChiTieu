/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

/**
 *
 * @author meimei
 */
public class DanhMuc {
    private int id;
    private String name;
    
    public DanhMuc(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public DanhMuc() {
        this.id = -1;
        this.name = "";
    }
    
    // MARK: - Get
    public int getID() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    // MARK: - Set
    public void setID(int id) {
        this.id = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Object[] toObjectArrayData() {
        Object[] answer = new Object[2];
        answer[0] = id;
        answer[1] = name;
        return answer;
    }
}
