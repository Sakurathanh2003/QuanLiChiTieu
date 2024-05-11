/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Coordinator;

import Base.Coordinator;
import Screen.LoginView;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class LoginCoordinator extends Coordinator {
    private LoginView view = null;
    
    @Override public void start() {
        super.start();
        this.view = new LoginView(this);
        this.view.setVisible(true);
    }
    
    @Override public void stop() {
        view.setVisible(false);
        view = null;
        super.stop();
    }
    
    @Override public String name() {
        return "LoginCoordinator";
    }
}
