/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bacon.gui;

import com.bacon.domain.Category;
import com.bacon.Aplication;
import com.bacon.domain.Product;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import org.apache.log4j.Logger;
import org.dz.PanelCapturaMod;

/**
 *
 * @author lrod
 */
public class PanelCategory extends PanelCapturaMod implements PropertyChangeListener {

    private final Aplication app;
    private Category category;
    private ArrayList<Product> products;
    public static final Logger logger = Logger.getLogger(PanelCategory.class.getCanonicalName());

    /**
     * Creates new form PanelCategory
     */
    public PanelCategory(Category category, ArrayList products, Aplication app) {
        this.app = app;
        pcs = new PropertyChangeSupport(this);
        this.category = category;
        this.products = products;
        initComponents();
        createComponents();
    }

    private void createComponents() {
        lbTitle.setText(category.getName());
        lbTitle.setOpaque(true);
        lbTitle.setBorder(BorderFactory.createEtchedBorder());
        lbTitle.setBackground(new Color(84, 36, 0, 130));

        lbTitle.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("click aqio");
            }
        });

        pnItems.setLayout(new GridLayout(0, 2, 10, 10));

        for (int i = 0; i < products.size(); i++) {
            Product prod = products.get(i);
            PanelProduct2 pnProd = new PanelProduct2(app, prod);
            pnProd.addPropertyChangeListener(this);
            pnItems.add(pnProd);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        
        logger.debug("Escuchando evt:"+evt.getPropertyName()+":"+evt.getPropagationId());
        if (PanelProduct2.AC_ADD_QUICK.equals(evt.getPropertyName())) {
            pcs.firePropertyChange(evt.getPropertyName(), null, evt.getNewValue());
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

        lbTitle = new javax.swing.JLabel();
        pnItems = new javax.swing.JPanel();

        pnItems.setLayout(new java.awt.GridLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 811, Short.MAX_VALUE)
                    .addComponent(pnItems, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnItems, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbTitle;
    private javax.swing.JPanel pnItems;
    // End of variables declaration//GEN-END:variables

}
