/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bacon.gui.util;

import com.bacon.Aplication;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.SwingConstants;

/**
 *
 * @author hp
 */
public class PanelBasic extends javax.swing.JPanel {

    private Aplication app;

    /**
     * Creates new form PanelBasic
     */
    public PanelBasic(Aplication app, String title, Icon icon, JComponent panel) {
        this.app = app;
        initComponents();
        createComponents(title, icon, panel);
        
    }

    private void createComponents(String title, Icon icon, JComponent panel) {
        btBack.setAction(app.getAction(Aplication.ACTION_RETURN_TO_MENU));
        btBack.setIcon(new ImageIcon(app.getImgManager().getImagen(app.getFolderIcons()+"go-home.png", 20, 20)));
        btBack.setText("Inicio");
        lbTitle.setText(title);
        lbTitle.setIcon(icon);
        lbTitle.setBorder(BorderFactory.createEtchedBorder());
        lbTitle.setHorizontalTextPosition(SwingConstants.RIGHT);
        lbTitle.setVerticalTextPosition(SwingConstants.CENTER);
        jPanel1.setLayout(new BorderLayout());
        jPanel1.add(panel, BorderLayout.CENTER);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        Rectangle bounds = getBounds();
        Graphics2D g2 = (Graphics2D) g;
        int WC = Aplication.WC;
        int cx = (bounds.width / WC) + 1;
        int cy = (bounds.height / WC) + 1;
        for (int i = 0; i < cx; i++) {
            for (int j = 0; j < cy; j++) {
                if (i % 2 == 0) {
                    if (j % 2 != 0) {
                        g2.drawImage(app.getImageBC(), i * WC - 10, j * WC - 10, null);
                    }
                } else {
                    if (j % 2 == 0) {
                        g2.drawImage(app.getImageBC(), i * WC - 10, j * WC - 10, null);
                    }
                }
            }
        }
//        super.paintComponent(g);
    } 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbTitle = new javax.swing.JLabel();
        btBack = new javax.swing.JButton();

        jPanel1.setLayout(new java.awt.BorderLayout());

        lbTitle.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        btBack.setText("Volver");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btBack)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBack;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbTitle;
    // End of variables declaration//GEN-END:variables
}
