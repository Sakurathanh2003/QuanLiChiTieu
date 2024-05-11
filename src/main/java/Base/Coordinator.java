/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Base;

import java.util.ArrayList;
import java.util.List;

public class Coordinator {
    public boolean started = false;
    public List<Coordinator> children = new ArrayList<>();
    public Coordinator parent = null;
    
    public void start() {
        if (this.started) {
            return;
        }
        
        this.started = true;
    }
    
    public void stop() {
        if (!this.started) {
            return;
        }
        
        this.children.forEach((child) -> {
            child.stop();
        });
        
        this.started = false;
        this.parent.childDidStop(this);
        this.parent.removeChild(this);
    }
    
    public void removeChild(Coordinator coordinator) {
        coordinator.parent = null;
        
        int index = this.children.indexOf(coordinator);
        
        if (index != -1) {
            this.children.remove(index);
        }
    }
    
    public boolean handle(CoordinatorEvent event) {
        return false;
    }
    
    public void send(CoordinatorEvent event) {
        if (!this.handle(event)) {
            this.parent.send(event);
        }
    }
    
    public void addChild(Coordinator coordinator) {
        coordinator.parent = this;
        this.children.add(coordinator);
    }
    
    public void childDidStop(Coordinator child) {
    }
    
    public String name() {
        return "coordinator";
    }
}
