package com.bacon.gui;

import com.bacon.Aplication;
import com.bacon.domain.OtherProduct;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import org.bx.TextFormatter;
import org.dz.PanelCapturaMod;

/**
 *
 * @author lrod
 */
public class PanelOtherProduct extends PanelCapturaMod implements ActionListener {

    private final Aplication app;

    /**
     * Creates new form PanelOtherProduct
     */
    public PanelOtherProduct(Aplication app, PropertyChangeListener listener) {
        this.app = app;
        pcs.addPropertyChangeListener(listener);
        initComponents();
        createComponents();
    }

    public void createComponents() {

        Font font = new Font("Arial", 1, 18);

        lbTitle.setText("Otro producto");
        lbTitle.setBackground(Color.lightGray);
        lbTitle.setOpaque(true);
        lbTitle.setBorder(BorderFactory.createLineBorder(Color.blue));

        regName.setCampoFont(font);
        regPrice.setCampoFont(font);
        regQuantity.setCampoFont(font);

        regPrice.setDocument(TextFormatter.getDoubleLimiter());
        regQuantity.setDocument(TextFormatter.getIntegerLimiter());

        btSave.setText("Agregar");
        btSave.setActionCommand(AC_SAVE);
        btSave.addActionListener(this);
    }

    public static final String AC_SAVE = "AC_SAVE";

    public OtherProduct checkData() {

        boolean validate = true;
        if (regName.getText().isEmpty()) {
            regName.setBorderToError();
            validate = false;
        }
        if (regPrice.getText().isEmpty()) {
            regPrice.setBorderToError();
            validate = false;
        }
        if (regQuantity.getText().isEmpty()) {
            regQuantity.setBorderToError();
            validate = false;
        }

        if (!validate) {
            return null;
        }

        double price = Double.parseDouble(regPrice.getText());

        app.getControl().addOtherProduct(regName.getText(), "", price);

        int id = app.getControl().getMaxIDTabla("other_products");

        return new OtherProduct(id, regName.getText(), price);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        regName = new com.bacon.gui.util.Registro(BoxLayout.X_AXIS, "Producto:","", 70);
        regPrice = new com.bacon.gui.util.Registro(BoxLayout.X_AXIS, "Precio:", "", 70);
        btSave = new javax.swing.JButton();
        regQuantity = new com.bacon.gui.util.Registro(BoxLayout.X_AXIS, "Cantidad","", 70);
        lbTitle = new javax.swing.JLabel();

        btSave.setText("jButton1");

        lbTitle.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(regName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(regPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(regQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btSave))
                    .addComponent(lbTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lbTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(regName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(regPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSave)
                    .addComponent(regQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btSave, regName, regPrice, regQuantity});

    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSave;
    private javax.swing.JLabel lbTitle;
    private com.bacon.gui.util.Registro regName;
    private com.bacon.gui.util.Registro regPrice;
    private com.bacon.gui.util.Registro regQuantity;
    // End of variables declaration//GEN-END:variables

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(AC_OTHER_PRODUCT)) {

        }

    }
    public static final String AC_OTHER_PRODUCT = "AC_ADD_OTHER_PRODUCT";

    @Override
    public void actionPerformed(ActionEvent e) {
        if (AC_SAVE.equals(e.getActionCommand())) {
            OtherProduct oProd = checkData();
            int cant = 0;
            try {
                cant = Integer.parseInt(regQuantity.getText());
                pcs.firePropertyChange(AC_OTHER_PRODUCT, oProd, cant);
            } catch (Exception ex) {
            }

        }
    }

}