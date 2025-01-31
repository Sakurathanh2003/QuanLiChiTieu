/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Screen;

import DAO.NganSachDAO;
import Database.NganSach;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author meimei
 */
public class BudgetView extends javax.swing.JPanel {

    /**
     * Creates new form BudgetView
     */
    public BudgetView() {
        initComponents();
        updateTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLabel = new java.awt.Label();
        jScrollPane2 = new javax.swing.JScrollPane();
        nganSachTableView = new rojeru_san.complementos.RSTableMetro();
        idTextField = new app.bolivia.swing.JCTextField();
        nameTextField = new app.bolivia.swing.JCTextField();
        moneyTextField = new app.bolivia.swing.JCTextField();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        addButton = new rojeru_san.complementos.RSButtonHover();
        updateButton = new rojeru_san.complementos.RSButtonHover();
        deleteButton = new rojeru_san.complementos.RSButtonHover();

        setBackground(new java.awt.Color(255, 255, 255));

        titleLabel.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(0, 0, 0));
        titleLabel.setText("WALLET MANAGER");

        nganSachTableView.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        nganSachTableView.setColorBackgoundHead(new java.awt.Color(255, 51, 102));
        nganSachTableView.setColorBordeFilas(new java.awt.Color(255, 0, 51));
        nganSachTableView.setColorBordeHead(new java.awt.Color(255, 255, 255));
        nganSachTableView.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        nganSachTableView.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        nganSachTableView.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        nganSachTableView.setColorSelBackgound(new java.awt.Color(0, 0, 0));
        nganSachTableView.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        nganSachTableView.setFuenteFilas(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        nganSachTableView.setFuenteFilasSelect(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        nganSachTableView.setFuenteHead(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        nganSachTableView.setRowHeight(40);
        nganSachTableView.setShowGrid(false);
        nganSachTableView.getTableHeader().setResizingAllowed(false);
        nganSachTableView.getTableHeader().setReorderingAllowed(false);
        nganSachTableView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nganSachTableViewMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(nganSachTableView);
        if (nganSachTableView.getColumnModel().getColumnCount() > 0) {
            nganSachTableView.getColumnModel().getColumn(0).setResizable(false);
            nganSachTableView.getColumnModel().getColumn(1).setResizable(false);
            nganSachTableView.getColumnModel().getColumn(2).setResizable(false);
        }

        idTextField.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ID", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 14))); // NOI18N
        idTextField.setEnabled(false);

        nameTextField.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Name", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 14))); // NOI18N

        moneyTextField.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Amount", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 14))); // NOI18N

        jLayeredPane1.setLayout(new java.awt.GridLayout(1, 0, 25, 0));

        addButton.setBackground(new java.awt.Color(153, 204, 255));
        addButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        jLayeredPane1.add(addButton);

        updateButton.setBackground(new java.awt.Color(255, 204, 0));
        updateButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        jLayeredPane1.add(updateButton);

        deleteButton.setBackground(new java.awt.Color(255, 0, 0));
        deleteButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        jLayeredPane1.add(deleteButton);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(moneyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {idTextField, moneyTextField, nameTextField});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(moneyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {idTextField, moneyTextField, nameTextField});

    }// </editor-fold>//GEN-END:initComponents

    private void nganSachTableViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nganSachTableViewMouseClicked
        int rowIndex = nganSachTableView.getSelectedRow();
        TableModel model = nganSachTableView.getModel();

        String id = model.getValueAt(rowIndex, 0).toString();
        String name = model.getValueAt(rowIndex, 1).toString();
        String money = model.getValueAt(rowIndex, 2).toString();
        
        money = money.replace("đ", "").replace("$", "");

        idTextField.setText(id);
        nameTextField.setText(name);
        moneyTextField.setText(money);        moneyTextField.setText(money);    }//GEN-LAST:event_nganSachTableViewMouseClicked

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        String name = nameTextField.getText();
        String money = moneyTextField.getText();
        double moneyValue;

        // Kiem tra co trong hay khong
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên ngân sách.");
            return;
        }

        if (money.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số tiền.");
            return;
        }

        try {
            moneyValue = Double.parseDouble(money);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng định dạng của số tiền.");
            return;
        }

        // Show Dialog confirm
        int response = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn thêm không?", "Xác Nhận", JOptionPane.YES_NO_OPTION);
        if (response == 1) {
            return;
        }

        // Them ngan sach
        try {
            if (NganSachDAO.isExits(name)) {
                JOptionPane.showMessageDialog(this, "Tên đã tồn tại, vui lòng nhập tên khác.");
                return;
            }

            NganSach ns = new NganSach();
            ns.setName(name);
            NganSachDAO.insert(ns, moneyValue);
            updateTable();
            // HomeController.instance.updateNganSachCB();
            clearTextField();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        String id = idTextField.getText();

        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn danh mục cần xoá.");
            return;
        }

        int response = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xoá không?", "Xác Nhận", JOptionPane.YES_NO_OPTION);
        if (response == 1) {
            return;
        }

        // Xoá danh muc
        try {
            int idValue = Integer.parseInt(id);
            NganSachDAO.delete(idValue);
            updateTable();
            //  HomeController.instance.updateNganSachCB();
            clearTextField();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        String name = nameTextField.getText();
        String money = moneyTextField.getText();
        String id = idTextField.getText();
        double moneyValue;

        // Kiem tra co trong hay khong
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn danh mục cần xoá.");
            return;
        }

        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên danh mục.");
            return;
        }

        if (money.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số tiền.");
            return;
        }

        try {
            moneyValue = Double.parseDouble(money);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng định dạng của số tiền.");
            return;
        }

        // Show Dialog confirm
        int response = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn sửa không?", "Xác Nhận", JOptionPane.YES_NO_OPTION);
        if (response == 1) {
            return;
        }

        // Sua danh muc
        try {
            NganSach ns = new NganSach();
            int idValue = Integer.parseInt(id);
            ns.setName(name);
            ns.setID(idValue);

            NganSachDAO.update(ns, moneyValue);
            updateTable();
            //  HomeController.instance.updateNganSachCB();
            clearTextField();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.complementos.RSButtonHover addButton;
    private rojeru_san.complementos.RSButtonHover deleteButton;
    private app.bolivia.swing.JCTextField idTextField;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private app.bolivia.swing.JCTextField moneyTextField;
    private app.bolivia.swing.JCTextField nameTextField;
    private rojeru_san.complementos.RSTableMetro nganSachTableView;
    private java.awt.Label titleLabel;
    private rojeru_san.complementos.RSButtonHover updateButton;
    // End of variables declaration//GEN-END:variables

    private void clearTextField() {
        idTextField.setText("");
        nameTextField.setText("");
        moneyTextField.setText("");
    }
    
    public void updateTable() {
        try {
            ArrayList<NganSach> nganSachs = NganSachDAO.getAll();

            DefaultTableModel defaultTableModel = (DefaultTableModel) nganSachTableView.getModel();

            while (defaultTableModel.getRowCount() > 0) {
               defaultTableModel.removeRow(0);
            }

            for (var nganSach : nganSachs) {
              defaultTableModel.addRow(nganSach.toObjectArrayData());
            }
        } catch (SQLException e) {
           e.printStackTrace();
        }
    }
}
