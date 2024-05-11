/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Coordinator;

import Base.Coordinator;
import Dialog.*;

public class AddGiaoDichCoordinator extends Coordinator {
    private CreateGiaoDichView view = null;
    boolean isChiTieu;
    
    public AddGiaoDichCoordinator(boolean isChiTieu) {
        this.isChiTieu = isChiTieu;
    }
    
    @Override public void start() {
        super.start();
        this.view = new CreateGiaoDichView(isChiTieu, this);
        this.view.setVisible(true);
    }
    
    @Override public void stop() {
        view.setVisible(false);
        view = null;
        super.stop();
    }
    
    @Override public String name() {
        return "AddGiaoDichCoordinator";
    }
}
