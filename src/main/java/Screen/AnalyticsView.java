/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Screen;

import Coordinator.AppCoordinator;
import DAO.*;
import Database.*;
import Helper.ExportPdfFile;
import com.raven.chart.*;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

enum AnalyticsType {
    category,
    budget
}

public class AnalyticsView extends javax.swing.JPanel {
    
    List<GiaoDich> giaoDichs = new ArrayList<>();
    List<DanhMuc> danhMucs = new ArrayList<>();
    List<NganSach> nganSachs = new ArrayList<>();
    AnalyticsType type;
    
    public AnalyticsView(AnalyticsType type) {
        this.type = type;
        
        initComponents();
        loadData();
        configTableView();
        configChartView();
        updateTitleLabel();
    }
    
    private void configChartView() {
        chartView.addLegend("Income", Color.yellow);
        chartView.addLegend("Expense", Color.red);
        chartView.addLegend("Total", Color.blue);
        
        if (this.type == AnalyticsType.category) {
            updateDataWithCategory();
        }
        
        if (this.type == AnalyticsType.budget) {
            updateDataWithBudget();
        }
    }
    
    private void updateDataWithBudget() {
        for (var budget: nganSachs) {
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableView.getModel();
            double incomeMoney = 0, expenseMoney = 0, totalMoney = 0;
            
            for (var giaoDich: giaoDichs) {
                if (giaoDich.nganSachID == budget.getID()) {
                    if (giaoDich.money > 0) {
                        incomeMoney += giaoDich.money;
                    } else {
                        expenseMoney -= giaoDich.money;
                    }
                }
            }
            
            totalMoney = incomeMoney - expenseMoney;
            chartView.addData(new ModelChart(budget.getName(), new double[]{incomeMoney, expenseMoney, totalMoney}));
            
            Object[] data = new Object[4];
            data[0] = budget.getName();
            data[1] = incomeMoney;
            data[2] = expenseMoney;
            data[3] = totalMoney;
            
            try {
                  String currency = AppCoordinator.getCurrency();
        
                if (currency.equalsIgnoreCase("VND")) {
                    data[1] += "đ";
                    data[2] += "đ";
                    data[3] += "đ";
                } else {
                    data[1] = "$" + data[1];
                    data[2] = "$" + data[2];
                    data[3] = "$" + data[3];

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        
            
            defaultTableModel.addRow(data);
        }
    }   
    
    private void updateDataWithCategory() {
        for (var category: danhMucs) {
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableView.getModel();
            double incomeMoney = 0, expenseMoney = 0, totalMoney = 0;
            
            for (var giaoDich: giaoDichs) {
                if (giaoDich.danhMucID == category.getID()) {
                    if (giaoDich.money > 0) {
                        incomeMoney += giaoDich.money;
                    } else {
                        expenseMoney -= giaoDich.money;
                    }
                }
            }
            
            totalMoney = incomeMoney - expenseMoney;
            chartView.addData(new ModelChart(category.getName(), new double[]{incomeMoney, expenseMoney, totalMoney}));
            
            Object[] data = new Object[4];
            data[0] = category.getName();
            data[1] = incomeMoney;
            data[2] = expenseMoney;
            data[3] = totalMoney;
            
            try {
                  String currency = AppCoordinator.getCurrency();
        
                if (currency.equalsIgnoreCase("VND")) {
                    data[1] += "đ";
                    data[2] += "đ";
                    data[3] += "đ";
                } else {
                    data[1] = "$" + data[1];
                    data[2] = "$" + data[2];
                    data[3] = "$" + data[3];

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            defaultTableModel.addRow(data);
        }
    }
    
    private void loadData() {
        try {
            giaoDichs = GiaoDichDAO.getAll();
            danhMucs = DanhMucDAO.getAll();
            nganSachs = NganSachDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void configTableView() {
        DefaultTableModel defaultTableModel = (DefaultTableModel) tableView.getModel();
        
        if (this.type == AnalyticsType.category) {
            defaultTableModel.addColumn("Category");
        }
        
        if (this.type == AnalyticsType.budget) {
            defaultTableModel.addColumn("Budget");
        } 
        
        defaultTableModel.addColumn("Income");
        defaultTableModel.addColumn("Expenses");
        defaultTableModel.addColumn("Total");
    }
    
    private void updateTitleLabel() {
        if (this.type == AnalyticsType.budget) {
            titleLabel.setText("ANALYTICS BY WALLET");
        } 
        
        if (this.type == AnalyticsType.category) {
            titleLabel.setText("ANALYTICS BY CATEGORY");
        } 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chartView = new com.raven.chart.Chart();
        titleLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableView = new Components.Table();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        titleLabel.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        titleLabel.setText("ANALYTICS");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("DATA");

        tableView.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tableView);

        jButton1.setText("Export");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chartView, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(titleLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1)))
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleLabel)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(chartView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFrame parentFrame = new JFrame();
 
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to save");   
        fileChooser.setFileFilter(new FileNameExtensionFilter("*.pdf", "pdf"));

        int userSelection = fileChooser.showSaveDialog(parentFrame);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            System.out.println("Save as file: " + fileToSave.getAbsolutePath());
            
            ExportPdfFile helper = new ExportPdfFile();
            
            try {
                String[] headers = {this.type == AnalyticsType.category ? "Category" : "Budget", "Income", "Expenses", "Total"};
        
                if (this.type == AnalyticsType.category) {
                    String[] data = new String[danhMucs.size() * 4];
                    int index = 0;
                     for (var category: danhMucs) {
                        DefaultTableModel defaultTableModel = (DefaultTableModel) tableView.getModel();
                        double incomeMoney = 0, expenseMoney = 0, totalMoney = 0;

                        for (var giaoDich: giaoDichs) {
                            if (giaoDich.danhMucID == category.getID()) {
                                if (giaoDich.money > 0) {
                                    incomeMoney += giaoDich.money;
                                } else {
                                    expenseMoney -= giaoDich.money;
                                }
                            }
                        }

                        totalMoney = incomeMoney - expenseMoney;
                        data[index] = category.getName();
                        data[index + 1] = Double.toString(incomeMoney);
                        data[index + 2] = Double.toString(expenseMoney);
                        data[index + 3] = Double.toString(totalMoney);
                        
                        try {
                            String currency = AppCoordinator.getCurrency();

                            if (currency.equalsIgnoreCase("VND")) {
                                data[index + 1] += "đ";
                                data[index + 2] += "đ";
                                data[index + 3] += "đ";
                            } else {
                                data[index + 1] = "$" + data[index + 1];
                                data[index + 2] = "$" + data[index + 2];
                                data[index + 3] = "$" + data[index + 3];

                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        index += 4;
                    }
                    
                    helper.exportFile(fileToSave.getAbsolutePath() + ".pdf", headers, 4, data);
                } else {
                    String[] data = new String[nganSachs.size() * 4];
                    int index = 0;
                    for (var budget: nganSachs) {
                        double incomeMoney = 0, expenseMoney = 0, totalMoney = 0;
            
                        for (var giaoDich: giaoDichs) {
                            if (giaoDich.nganSachID == budget.getID()) {
                                if (giaoDich.money > 0) {
                                    incomeMoney += giaoDich.money;
                                } else {
                                    expenseMoney -= giaoDich.money;
                                }
                            }
                        }
            
                        totalMoney = incomeMoney - expenseMoney;
                        data[index] = budget.getName();
                        data[index + 1] = Double.toString(incomeMoney);
                        data[index + 2] = Double.toString(expenseMoney);
                        data[index + 3] = Double.toString(totalMoney);
                        
                        try {
                            String currency = AppCoordinator.getCurrency();

                            if (currency.equalsIgnoreCase("VND")) {
                                data[index + 1] += "đ";
                                data[index + 2] += "đ";
                                data[index + 3] += "đ";
                            } else {
                                data[index + 1] = "$" + data[index + 1];
                                data[index + 2] = "$" + data[index + 2];
                                data[index + 3] = "$" + data[index + 3];

                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        index += 4;
                    }
                    
                    helper.exportFile(fileToSave.getAbsolutePath() + ".pdf", headers, 4, data);
                }
                
                JOptionPane.showMessageDialog(null, "Export sucessfully!");
            } catch (FileNotFoundException e) {
                System.out.print(e);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.chart.Chart chartView;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private Components.Table tableView;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
