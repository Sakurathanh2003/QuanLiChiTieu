/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Screen;

import Coordinator.AppCoordinator;
import DAO.*;
import Database.*;

import Model.CardModel;
import Dialog.*;
import Helper.ExportPdfFile;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public final class HomeView extends javax.swing.JPanel {
    ArrayList<NganSach> nganSachs;
    ArrayList<DanhMuc> danhMucs;
    ArrayList<String> thangs;
    ArrayList<String> nams;
    ArrayList<GiaoDich> giaoDichs;
    
    Dashboard dashboard;

    public HomeView(Dashboard dashboard) {
        this.dashboard = dashboard;
        initComponents();
        
        updateNotification();
        updateTable();
    }

    public void updateTable() {
        int danhMucID = danhMucCB.getSelectedIndex();
        int nganSachID = nganSachCB.getSelectedIndex();
        int thang = thangCB.getSelectedIndex();
        int nam = namCB.getSelectedIndex();

        if (danhMucID != -1) {
            danhMucID = danhMucs.get(danhMucID).getID();
        }

        if (nganSachID != -1) {
            nganSachID = nganSachs.get(nganSachID).getID();
        }

        if (thang != -1) {
            thang = Integer.parseInt(thangs.get(thang));
        }

        if (nam != -1) {
            nam = Integer.parseInt(nams.get(nam));
        }
        
        try {
            double incomeMoney = 0, outcomeMoney = 0;
            this.giaoDichs = GiaoDichDAO.filter(danhMucID, nganSachID, thang, nam);
            

            DefaultTableModel defaultTableModel = (DefaultTableModel) giaoDichTableView.getModel();

             while (defaultTableModel.getRowCount() > 0) {
                 defaultTableModel.removeRow(0);
             }

            for (var giaoDich : giaoDichs) {
                try {
                    defaultTableModel.addRow(giaoDich.toObjectArrayData());

                 if (giaoDich.money > 0) {
                     incomeMoney += giaoDich.money;
                 } else {
                     outcomeMoney -= giaoDich.money;
                 }
                } catch (IOException e) {
                    e.printStackTrace();
                } 
             }

             updateOutcomeCard(outcomeMoney);
             updateIncomeCard(incomeMoney);
             updateTotalCard(-outcomeMoney + incomeMoney);
        } catch (SQLException e) {
           e.printStackTrace();
        }
    }
    
    private void updateOutcomeCard(double moneyTotal) {
        String money = Double.toString(moneyTotal);
        try {
            String currency = AppCoordinator.getCurrency();

            if (currency.equalsIgnoreCase("VND")) {
                money = money + "đ";
            } else {
                money = "$" + money;
            }
        } catch (IOException e) {
                e.printStackTrace();
        }
        
        expenseCard.setData(new CardModel(new ImageIcon(getClass().getResource("/icons/stock.png")), "Expenses", money));
    }
    
    private void updateIncomeCard(double moneyTotal) {
        String money = Double.toString(moneyTotal);
        try {
            String currency = AppCoordinator.getCurrency();

            if (currency.equalsIgnoreCase("VND")) {
                money = money + "đ";
            } else {
                money = "$" + money;
            }
        } catch (IOException e) {
                e.printStackTrace();
        }
        
        incomeCard.setData(new CardModel(new ImageIcon(getClass().getResource("/icons/stock.png")), "Income", money));
    }
    
    private void updateTotalCard(double moneyTotal) {
        String money = Double.toString(moneyTotal);
        try {
            String currency = AppCoordinator.getCurrency();

            if (currency.equalsIgnoreCase("VND")) {
                money = money + "đ";
            } else {
                money = "$" + money;
            }
        } catch (IOException e) {
                e.printStackTrace();
        }
        
        totalCard.setData(new CardModel(new ImageIcon(getClass().getResource("/icons/stock.png")), "Total", money));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        totalCard = new Components.Card();
        incomeCard = new Components.Card();
        expenseCard = new Components.Card();
        jLabel1 = new javax.swing.JLabel();
        addIncomeButton = new javax.swing.JButton();
        addExpenseButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        giaoDichTableView = new rojeru_san.complementos.RSTableMetro();
        jPanel1 = new javax.swing.JPanel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        namCB = new javax.swing.JComboBox<>();
        danhMucCB = new javax.swing.JComboBox<>();
        thangCB = new javax.swing.JComboBox<>();
        nganSachCB = new javax.swing.JComboBox<>();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        removeFilterButton = new rojeru_san.complementos.RSButtonHover();
        filterButton = new rojeru_san.complementos.RSButtonHover();
        exportButton = new rojeru_san.complementos.RSButtonHover();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        thongBaoLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(750, 32767));
        setPreferredSize(new java.awt.Dimension(750, 753));

        jLayeredPane1.setLayout(new java.awt.GridLayout(1, 0, 20, 0));

        totalCard.setColor1(new java.awt.Color(24, 155, 204));
        totalCard.setColor2(new java.awt.Color(24, 155, 204));
        jLayeredPane1.add(totalCard);

        incomeCard.setColor1(new java.awt.Color(255, 153, 0));
        incomeCard.setColor2(new java.awt.Color(255, 153, 0));
        jLayeredPane1.add(incomeCard);

        expenseCard.setColor1(new java.awt.Color(234, 33, 58));
        expenseCard.setColor2(new java.awt.Color(234, 33, 58));
        jLayeredPane1.add(expenseCard);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("DASHBOARD");

        addIncomeButton.setText("+ Add Income");
        addIncomeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addIncomeButtonActionPerformed(evt);
            }
        });

        addExpenseButton.setText("+ Add Expense");
        addExpenseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addExpenseButtonActionPerformed(evt);
            }
        });

        jScrollPane2.setBorder(null);
        jScrollPane2.setForeground(new java.awt.Color(255, 255, 255));

        giaoDichTableView.setForeground(new java.awt.Color(255, 255, 255));
        giaoDichTableView.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Amount", "Note", "CreatedDate", "Category"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        giaoDichTableView.setColorBackgoundHead(new java.awt.Color(255, 153, 0));
        giaoDichTableView.setColorBordeFilas(new java.awt.Color(255, 153, 0));
        giaoDichTableView.setColorBordeHead(new java.awt.Color(255, 255, 255));
        giaoDichTableView.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        giaoDichTableView.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        giaoDichTableView.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        giaoDichTableView.setColorSelBackgound(new java.awt.Color(0, 0, 0));
        giaoDichTableView.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        giaoDichTableView.setFuenteFilas(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        giaoDichTableView.setFuenteFilasSelect(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        giaoDichTableView.setFuenteHead(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        giaoDichTableView.setRowHeight(40);
        giaoDichTableView.setShowGrid(false);
        giaoDichTableView.getTableHeader().setResizingAllowed(false);
        giaoDichTableView.getTableHeader().setReorderingAllowed(false);
        giaoDichTableView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                giaoDichTableViewMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(giaoDichTableView);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filter", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 14))); // NOI18N

        jLayeredPane2.setLayout(new java.awt.GridLayout(2, 2, 20, 20));

        namCB.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "YEAR", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 14))); // NOI18N
        jLayeredPane2.add(namCB);

        danhMucCB.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CATEGORY", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 14))); // NOI18N
        jLayeredPane2.add(danhMucCB);

        thangCB.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "MONTH", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 14))); // NOI18N
        jLayeredPane2.add(thangCB);

        nganSachCB.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "WALLET", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 14))); // NOI18N
        jLayeredPane2.add(nganSachCB);

        jLayeredPane3.setLayout(new java.awt.GridLayout(3, 1, 20, 20));

        removeFilterButton.setBackground(new java.awt.Color(153, 204, 255));
        removeFilterButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        removeFilterButton.setText("Remove Filter");
        removeFilterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeFilterButtonActionPerformed(evt);
            }
        });
        jLayeredPane3.add(removeFilterButton);

        filterButton.setBackground(new java.awt.Color(255, 204, 0));
        filterButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        filterButton.setText("Filter");
        filterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterButtonActionPerformed(evt);
            }
        });
        jLayeredPane3.add(filterButton);

        exportButton.setBackground(new java.awt.Color(255, 0, 0));
        exportButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        exportButton.setText("Export");
        exportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportButtonActionPerformed(evt);
            }
        });
        jLayeredPane3.add(exportButton);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane2)
                .addGap(31, 31, 31)
                .addComponent(jLayeredPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLayeredPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                    .addComponent(jLayeredPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );

        label1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        label1.setForeground(new java.awt.Color(0, 0, 0));
        label1.setText("LIST TRANSACTION");

        label2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        label2.setForeground(new java.awt.Color(0, 0, 0));
        label2.setText("NOTIFICATION");

        thongBaoLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        thongBaoLabel.setText("Message");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(thongBaoLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(addExpenseButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addIncomeButton))
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2))
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addIncomeButton)
                            .addComponent(addExpenseButton)))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(thongBaoLabel)
                .addGap(25, 25, 25)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addIncomeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addIncomeButtonActionPerformed
        dashboard.coordinator.routeToAddGiaoDich(false);
    }//GEN-LAST:event_addIncomeButtonActionPerformed

    private void addExpenseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addExpenseButtonActionPerformed
        dashboard.coordinator.routeToAddGiaoDich(true);
    }//GEN-LAST:event_addExpenseButtonActionPerformed

    private void giaoDichTableViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_giaoDichTableViewMouseClicked
        int rowIndex = giaoDichTableView.getSelectedRow();
        TableModel model = giaoDichTableView.getModel();

        String id = model.getValueAt(rowIndex, 0).toString();
        int idValue = Integer.parseInt(id);

        try {
            GiaoDich giaoDich = GiaoDichDAO.getByID(idValue);
            this.dashboard.coordinator.routeToUpdateGiaoDich(giaoDich);
        } catch (SQLException ex) {
            Logger.getLogger(HomeView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_giaoDichTableViewMouseClicked

    private void filterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterButtonActionPerformed
        this.updateTable();
    }//GEN-LAST:event_filterButtonActionPerformed

    private void removeFilterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeFilterButtonActionPerformed
        danhMucCB.setSelectedIndex(-1);
        nganSachCB.setSelectedIndex(-1);
        thangCB.setSelectedIndex(-1);
        namCB.setSelectedIndex(-1);
        updateTable();
    }//GEN-LAST:event_removeFilterButtonActionPerformed

    private void exportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportButtonActionPerformed
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
                String[] headers = {"ID", "Amount", "Note", "CreatedDate", "Category"};
                double total = 0;
        
                String[] data = new String[giaoDichs.size() * 5 + 2];
                int index = 0;
                for (GiaoDich giaoDich: giaoDichs) {
                    try {
                        Object[] objects = giaoDich.toObjectArrayData();
                    
                    for (Object object: objects) {
                        data[index] = object.toString();
                        index += 1;
                        
                    }
                    
                    total += giaoDich.money;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
               
                data[index] = "Total";
                index++;
                
                try {
                    String currency = AppCoordinator.getCurrency();
                    
                    if (currency.equalsIgnoreCase("VND")) {
                        data[index] = Double.toString(total) + "đ";
                    } else {
                        data[index] = "$" + Double.toString(total);
                    }
                    
                } catch (IOException e) {
                        e.printStackTrace();
                }
                
                
                helper.exportFile(fileToSave.getAbsolutePath() + ".pdf", headers, 5, data);
                JOptionPane.showMessageDialog(null, "Export sucessfully!");
            } catch (FileNotFoundException e) {
                System.out.print(e);
            }
        }
    }//GEN-LAST:event_exportButtonActionPerformed

    private void clearFilter() {
        danhMucCB.setSelectedIndex(-1);
        nganSachCB.setSelectedIndex(-1);
        namCB.setSelectedIndex(-1);
        thangCB.setSelectedIndex(-1);
    }
    
    public void getDanhMucCB() {
        danhMucCB.removeAllItems();

        try {
            danhMucs = DanhMucDAO.getAll();
            for (DanhMuc danhMuc : danhMucs) {
                danhMucCB.addItem(danhMuc.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        danhMucCB.setSelectedIndex(-1);
    }
    
    
    public void getNganSachCB() {
        nganSachCB.removeAllItems();

        try {
            nganSachs = NganSachDAO.getAll();
            for (NganSach nganSach : nganSachs) {
                nganSachCB.addItem(nganSach.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        nganSachCB.setSelectedIndex(-1);
    }
    
    public void getThangNamCB() {
        thangs = new ArrayList();
        for(int i = 1 ; i <= 12 ; i++){
            thangs.add(String.valueOf(i));
        }
      
        nams = new ArrayList<>();
        
        LocalDate localDate = LocalDate.now();
        for (int i = localDate.getYear(); i >= 2012; i--) {
            nams.add(String.valueOf(i));
        }
        
        thangCB.setModel(new DefaultComboBoxModel<>(thangs.toArray(new String[thangs.size()])));
        thangCB.setSelectedIndex(-1);
        namCB.setModel(new DefaultComboBoxModel<>(nams.toArray(new String[nams.size()])));
        namCB.setSelectedIndex(-1);
    }  
    
    public void updateNotification() {    
        getDanhMucCB();
        getNganSachCB();
        getThangNamCB();
        
        // Duyet tung ngan sach mot de xem co cai nao co so tien am hay khong 
        for (NganSach nganSach : nganSachs) {
            if (nganSach.getMoney() < 0) {
                thongBaoLabel.setText("There are some budgets that are being exceeded, please review your income and expenditure!");
                thongBaoLabel.setForeground(Color.red);
                return;
            }
        }
        
        thongBaoLabel.setText("Empty");
        thongBaoLabel.setForeground(Color.GRAY);
    }
    
    public void reloadData() {
        updateNotification();
        updateTable();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addExpenseButton;
    private javax.swing.JButton addIncomeButton;
    private javax.swing.JComboBox<String> danhMucCB;
    private Components.Card expenseCard;
    private rojeru_san.complementos.RSButtonHover exportButton;
    private rojeru_san.complementos.RSButtonHover filterButton;
    private rojeru_san.complementos.RSTableMetro giaoDichTableView;
    private Components.Card incomeCard;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private javax.swing.JComboBox<String> namCB;
    private javax.swing.JComboBox<String> nganSachCB;
    private rojeru_san.complementos.RSButtonHover removeFilterButton;
    private javax.swing.JComboBox<String> thangCB;
    private javax.swing.JLabel thongBaoLabel;
    private Components.Card totalCard;
    // End of variables declaration//GEN-END:variables
}
