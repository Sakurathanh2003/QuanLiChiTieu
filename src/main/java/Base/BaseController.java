/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Base;

import javax.swing.JFrame;

/**
 *
 * @author meimei
 */
public class BaseController {
    public JFrame view;
    public void start() {
        view.setVisible(true);
    }
    
    public void stop() {
        view.dispose();
        view = null;
    }
}
