/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Screen;

import Base.EventMenuSelected;
import Coordinator.HomeCoordinator;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class Dashboard extends javax.swing.JFrame {
    
    private HomeView homeView;
    private BudgetView budgetView;
    private CategoryView categoryView;
    private UserManualView userManualView;
    HomeCoordinator coordinator;
    int currentMenu = -1;

    public Dashboard(HomeCoordinator coordinator) {
        this.coordinator = coordinator;
        initComponents();
        
        homeView = new HomeView(this);
        budgetView = new BudgetView();
        categoryView = new CategoryView();
        userManualView = new UserManualView();
        
        menu.addEventMenuSelected(new EventMenuSelected() {
             @Override
            public void selected(int index) {
                currentMenu = index;
                
                if (index == 0) {
                    homeView.reloadData();
                    setForm(homeView);
                }
                
                if (index == 1) {
                    setForm(budgetView);
                }
                
                if (index == 2) {
                    setForm(categoryView);
                }
                
                if (index == 4) {
                    AnalyticsView analyticsView = new AnalyticsView(AnalyticsType.category); 
                    setForm(analyticsView);
                }
                
                if (index == 5) {
                    AnalyticsView analyticsView = new AnalyticsView(AnalyticsType.budget); 
                    setForm(analyticsView);
                }
                
                if (index == 7) {
                    setForm(userManualView);
                }
                
                if (index == 8) {
                    dispose();
                }
             
            }
        });
        
        currentMenu = 0;
        menu.select(0);
        homeView.updateTable();
        setForm(homeView);
    }
    
    private void setForm(JComponent com) {
        mainPanel.removeAll();
        mainPanel.add(com);
        mainPanel.repaint();
        mainPanel.revalidate();
    }
    
    public void reloadData() {
        this.homeView.reloadData();
        this.menu.select(currentMenu);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu = new Components.Menu();
        jScrollPane2 = new javax.swing.JScrollPane();
        mainPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1031, 600));

        jScrollPane2.setOpaque(false);

        mainPanel.setOpaque(false);
        mainPanel.setLayout(new java.awt.BorderLayout());
        jScrollPane2.setViewportView(mainPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 844, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
            .addComponent(jScrollPane2)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel mainPanel;
    private Components.Menu menu;
    // End of variables declaration//GEN-END:variables
}
