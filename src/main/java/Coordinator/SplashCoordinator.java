/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Coordinator;

import Base.*;
import Screen.SplashView;

public class SplashCoordinator extends Coordinator {
    private SplashView view = null;
    
    @Override public void start() {
        super.start();
        this.view = new SplashView(this);
        this.view.setVisible(true);
        this.view.runProgressBar();
    }
    
    @Override public void stop() {
        view.setVisible(false);
        view = null;
        super.stop();
    }
    
    @Override public String name() {
        return "SplashCoordinator";
    }
}
