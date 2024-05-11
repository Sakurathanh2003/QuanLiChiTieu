package Screen;

import DAO.DanhMucDAO;
import Database.DanhMuc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class CategoryView extends javax.swing.JPanel {

    public CategoryView() {
        initComponents();
        updateTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCTextField1 = new app.bolivia.swing.JCTextField();
        label1 = new java.awt.Label();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        updateButton1 = new rojeru_san.complementos.RSButtonHover();
        addButton1 = new rojeru_san.complementos.RSButtonHover();
        deleteButton1 = new rojeru_san.complementos.RSButtonHover();
        idTextField = new app.bolivia.swing.JCTextField();
        nameTextField = new app.bolivia.swing.JCTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        danhMucTableView = new rojeru_san.complementos.RSTableMetro();

        jCTextField1.setText("jCTextField1");

        setBackground(new java.awt.Color(255, 255, 255));

        label1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        label1.setForeground(new java.awt.Color(0, 0, 0));
        label1.setText("CATEGORY MANAGER");

        jLayeredPane1.setLayout(new java.awt.GridLayout(1, 0, 25, 0));

        updateButton1.setBackground(new java.awt.Color(255, 204, 0));
        updateButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        updateButton1.setText("Update");
        updateButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButton1ActionPerformed(evt);
            }
        });
        jLayeredPane1.add(updateButton1);

        addButton1.setBackground(new java.awt.Color(153, 204, 255));
        addButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addButton1.setText("Add");
        addButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButton1ActionPerformed(evt);
            }
        });
        jLayeredPane1.add(addButton1);

        deleteButton1.setBackground(new java.awt.Color(255, 0, 0));
        deleteButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        deleteButton1.setText("Delete");
        deleteButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButton1ActionPerformed(evt);
            }
        });
        jLayeredPane1.add(deleteButton1);

        idTextField.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ID", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 14))); // NOI18N
        idTextField.setEnabled(false);

        nameTextField.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Name", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 14))); // NOI18N

        danhMucTableView.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        danhMucTableView.setColorBackgoundHead(new java.awt.Color(0, 153, 204));
        danhMucTableView.setColorBordeFilas(new java.awt.Color(0, 153, 204));
        danhMucTableView.setColorBordeHead(new java.awt.Color(255, 255, 255));
        danhMucTableView.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        danhMucTableView.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        danhMucTableView.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        danhMucTableView.setColorSelBackgound(new java.awt.Color(0, 0, 0));
        danhMucTableView.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        danhMucTableView.setFuenteFilas(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        danhMucTableView.setFuenteFilasSelect(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        danhMucTableView.setFuenteHead(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        danhMucTableView.setRowHeight(40);
        danhMucTableView.setShowGrid(false);
        danhMucTableView.getTableHeader().setResizingAllowed(false);
        danhMucTableView.getTableHeader().setReorderingAllowed(false);
        danhMucTableView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                danhMucTableViewMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(danhMucTableView);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(nameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(183, Short.MAX_VALUE))
            .addComponent(jScrollPane2)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButton1ActionPerformed
        String name = nameTextField.getText();

        // Kiem tra co trong hay khong
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên danh mục.");
            return;
        }

        // Show Dialog confirm
        int response = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn thêm không?", "Xác Nhận", JOptionPane.YES_NO_OPTION);
        if (response == 1) {
            return;
        }

        // Them danh muc
        try {
            if (DanhMucDAO.isExits(name)) { // Danh muc da ton tai
                JOptionPane.showMessageDialog(this, "Tên danh mục đã tồn tại");
                return;
            }

            DanhMuc danhMuc = new DanhMuc();
            danhMuc.setName(name);
            DanhMucDAO.insert(danhMuc);
            updateTable();
            clearTextField();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_addButton1ActionPerformed

    private void updateButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButton1ActionPerformed
       String name = nameTextField.getText();
        int id = Integer.valueOf(idTextField.getText());

        // Kiem tra co trong hay khong
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên danh mục.");
            return;
        }

        // Show Dialog confirm
        int response = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn sửa không?", "Xác Nhận", JOptionPane.YES_NO_OPTION);
        if (response == 1) {
            return;
        }

        // Sua danh muc
        try {
            if (DanhMucDAO.isExits(name)) { // Danh muc da ton tai
                JOptionPane.showMessageDialog(this, "Tên danh mục đã tồn tại");
                return;
            }

            DanhMuc danhMuc = new DanhMuc();
            danhMuc.setName(name);
            danhMuc.setID(id);

            DanhMucDAO.update(danhMuc);
            updateTable();
            clearTextField();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_updateButton1ActionPerformed

    private void deleteButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButton1ActionPerformed
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
            int value = Integer.valueOf(id);
            DanhMucDAO.delete(value);
            updateTable();
            clearTextField();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_deleteButton1ActionPerformed

    private void danhMucTableViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_danhMucTableViewMouseClicked
         int rowIndex = danhMucTableView.getSelectedRow();
        TableModel model = danhMucTableView.getModel();

        String id = model.getValueAt(rowIndex, 0).toString();
        String name = model.getValueAt(rowIndex, 1).toString();

        idTextField.setText(id);
        nameTextField.setText(name);
    }//GEN-LAST:event_danhMucTableViewMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.complementos.RSButtonHover addButton1;
    private rojeru_san.complementos.RSTableMetro danhMucTableView;
    private rojeru_san.complementos.RSButtonHover deleteButton1;
    private app.bolivia.swing.JCTextField idTextField;
    private app.bolivia.swing.JCTextField jCTextField1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private java.awt.Label label1;
    private app.bolivia.swing.JCTextField nameTextField;
    private rojeru_san.complementos.RSButtonHover updateButton1;
    // End of variables declaration//GEN-END:variables

    public void updateTable() {
        try {
            ArrayList<DanhMuc> chamCongs = DanhMucDAO.getAll();

            DefaultTableModel defaultTableModel = (DefaultTableModel) danhMucTableView.getModel();

            while (defaultTableModel.getRowCount() > 0) {
               defaultTableModel.removeRow(0);
            }

            for (var chamCong : chamCongs) {
              defaultTableModel.addRow(chamCong.toObjectArrayData());
            }
        } catch (SQLException e) {
           e.printStackTrace();
        }
    }

    private void clearTextField() {
        idTextField.setText("");
        nameTextField.setText("");
    }
}
