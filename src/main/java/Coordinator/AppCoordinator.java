/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Coordinator;

import Base.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class AppCoordinator extends Coordinator {
    public static final String DUONG_DAN_FILE = "username.txt";

    private SplashCoordinator splashCoordinator = null;
    private LoginCoordinator loginCoordinator = null;
    private HomeCoordinator homeCoordinator = null;
    
    @Override public void start() {
        super.start();
        this.routeToSplash();
    }
    
    @Override public void childDidStop(Coordinator child) {
        super.childDidStop(child);
        System.out.print("childDidStop " + child.name() + "\n");
        
        if (child instanceof SplashCoordinator) {
            this.splashCoordinator = null;
            
            if (this.shouldRouteToHome()) {
                this.routeToHome();
            } else {
                this.routeToLogin();
            }
        }
        
        if (child instanceof LoginCoordinator) {
            this.loginCoordinator = null;
            this.routeToHome();
        }
    }
    
    // MARK: - Change Screen
    private void routeToSplash() {
        this.splashCoordinator = new SplashCoordinator();
        this.addChild(this.splashCoordinator);
        this.splashCoordinator.start();
    }
    
    public void routeToLogin() {
        this.loginCoordinator = new LoginCoordinator();
        this.addChild(this.loginCoordinator);
        this.loginCoordinator.start();
    }
    
    public void routeToHome() {
        this.homeCoordinator = new HomeCoordinator();
        this.addChild(this.homeCoordinator);
        this.homeCoordinator.start();
    }
    
    // MARK: - Get
    public static String getUsername() throws IOException {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(DUONG_DAN_FILE))) {
            return (String) objectInputStream.readObject();
        } catch (Exception e) {
            return "";
        }
    }
    
    public static String getCurrency() throws IOException {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(DUONG_DAN_FILE))) {
            String username = (String) objectInputStream.readObject();
            String currency = (String) objectInputStream.readObject();
            return currency;
        } catch (Exception e) {
            return "";
        }
    }
    
    private boolean shouldRouteToHome() {
        try {
            String name = this.getUsername();
            return !name.isEmpty();
        } catch (Exception e) {
            return true;
        }
    }
}
