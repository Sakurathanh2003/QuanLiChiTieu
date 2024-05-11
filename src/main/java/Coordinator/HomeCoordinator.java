/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Coordinator;

import Base.Coordinator;
import Database.GiaoDich;
import Screen.Dashboard;

public class HomeCoordinator extends Coordinator {
    private Dashboard view = null;
    AddGiaoDichCoordinator addGiaoDichCoordinator = null;
    UpdateGiaoDichCoordinator updateGiaoDichCoordinator = null;
    
    @Override public void start() {
        super.start();
        this.view = new Dashboard(this);
        this.view.setVisible(true);
    }
    
    @Override public void childDidStop(Coordinator child) {
        super.childDidStop(child);
        System.out.print("childDidStop " + child.name() + "\n");
        
        if (child instanceof AddGiaoDichCoordinator) {
            this.addGiaoDichCoordinator = null;
            this.view.reloadData();
        }
        
        if (child instanceof UpdateGiaoDichCoordinator) {
            this.updateGiaoDichCoordinator = null;
            this.view.reloadData();
        }
    }
    
    public void routeToAddGiaoDich(boolean isChiTieu) {
        this.addGiaoDichCoordinator = new AddGiaoDichCoordinator(isChiTieu);
        this.addChild(this.addGiaoDichCoordinator);
        this.addGiaoDichCoordinator.start();
    }
    
    public void routeToUpdateGiaoDich(GiaoDich gd) {
        this.updateGiaoDichCoordinator = new UpdateGiaoDichCoordinator(gd);
        this.addChild(this.updateGiaoDichCoordinator);
        this.updateGiaoDichCoordinator.start();
    }
}
