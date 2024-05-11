/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Coordinator;

import Base.Coordinator;
import Database.GiaoDich;
import Dialog.*;

/**
 *
 * @author meimei
 */
public class UpdateGiaoDichCoordinator extends Coordinator {
    private UpdateGiaoDichView view = null;
    GiaoDich gd;
    
    public UpdateGiaoDichCoordinator(GiaoDich gd) {
        this.gd = gd;
    }
    
    @Override public void start() {
        super.start();
        this.view = new UpdateGiaoDichView(this.gd, this);
        this.view.setVisible(true);
    }
    
    @Override public void stop() {
        view.dispose();
        view = null;
        super.stop();
    }
    
    @Override public String name() {
        return "AddGiaoDichCoordinator";
    }
}
