/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bacon.gui;

import com.bacon.Aplication;
import com.bacon.Configuration;
import com.bacon.domain.Product;
import static com.bacon.gui.PanelProduct2.AC_ADD_CUSTOM;
import static com.bacon.gui.PanelProduct2.AC_ADD_QUICK;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import org.dz.PanelCapturaMod;

/**
 *
 * @author lrod
 */
public class PanelProduct extends PanelCapturaMod implements ActionListener {

    private Product product;
    private final Aplication app;

    /**
     * Creates new form PanelProduct
     */
    public PanelProduct(Aplication app, Product product) {
        this.app = app;
        this.product = product;
        initComponents();
        createComponents();
    }

    private void createComponents() {

        String image = product.getImage();

        String path = app.getConfiguration().getProperty(Configuration.PATH_IMG, "img");

        path = Aplication.getDirPics();

        ImageIcon icon = null;
        try {
            icon = new ImageIcon(app.getImgManager().getBufImagen(path + "/" + image, 70, 70));
        } catch (Exception e) {
            icon = new ImageIcon(app.getImgManager().getImagen(app.getFolderIcons() + "no-photo.png", 70, 70));
        }

        Font font1 = new Font("Sans", 1, 13);
        Font font2 = new Font("Serif", 2, 10);
        Font font3 = new Font("Tahoma", 1, 13);

        NumberFormat NF = DecimalFormat.getCurrencyInstance();
        NF.setMaximumFractionDigits(0);

        Color color = new Color(125, 11, 7);

        lbName.setFont(font1);
        lbName.setForeground(Color.blue.darker().darker());
        lbName.setText(product.getName().toUpperCase());
        lbName.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 1, 0, color),
                BorderFactory.createEmptyBorder(2, 2, 2, 2)
        ));

        lbCategory.setBorder(BorderFactory.createLineBorder(color, 1, true));
        lbCategory.setForeground(color.darker().darker());
        lbCategory.setFont(font2);
        lbCategory.setText(product.getCategory().toUpperCase());

        lbPrice.setFont(font3);
        lbPrice.setForeground(Color.red.darker());
        lbPrice.setText(NF.format(product.getPrice()));

        lbImage.setIcon(icon);
        btAddQuick.setActionCommand(PanelProduct2.AC_ADD_QUICK);
        btAddQuick.setMargin(new Insets(1, 1, 1, 1));
        btAddQuick.setFocusPainted(false);
        btAddQuick.setIcon(new ImageIcon(app.getImgManager().getImagen(app.getFolderIcons() + "add1.png", 15, 15)));
        btAddQuick.addActionListener(this);

        btAddCustom.setActionCommand(PanelProduct2.AC_ADD_CUSTOM);
        btAddCustom.setMargin(new Insets(1, 1, 1, 1));
        btAddCustom.setFocusPainted(false);
        btAddCustom.setIcon(new ImageIcon(app.getImgManager().getImagen(app.getFolderIcons() + "process-accept.png", 15, 15)));
        btAddCustom.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (AC_ADD_QUICK.equals(e.getActionCommand())) {
            
            pcs.firePropertyChange(AC_ADD_QUICK, null, product);
        } else if (AC_ADD_CUSTOM.equals(e.getActionCommand())) {
            app.getGuiManager().showCustomPedido(product, app);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbImage = new javax.swing.JLabel();
        lbName = new javax.swing.JLabel();
        lbCategory = new javax.swing.JLabel();
        lbPrice = new javax.swing.JLabel();
        btAddCustom = new javax.swing.JButton();
        btAddQuick = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 128, 0), new java.awt.Color(164, 62, 1)));
        setMaximumSize(new java.awt.Dimension(32767, 85));
        setPreferredSize(new java.awt.Dimension(140, 80));

        lbImage.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbCategory.setText("jLabel1");

        lbPrice.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbImage, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btAddCustom, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btAddQuick, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lbCategory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btAddCustom, btAddQuick});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbImage, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbCategory)
                .addGap(1, 1, 1)
                .addComponent(lbName, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbPrice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(btAddQuick, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btAddCustom, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btAddCustom, btAddQuick, lbPrice});

    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAddCustom;
    private javax.swing.JButton btAddQuick;
    private javax.swing.JLabel lbCategory;
    private javax.swing.JLabel lbImage;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbPrice;
    // End of variables declaration//GEN-END:variables

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
