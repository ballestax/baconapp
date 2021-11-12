package com.bacon.gui;

import com.bacon.Aplication;
import com.bacon.domain.CashMov;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.ImageIcon;
import org.dz.PanelCapturaMod;
import org.dz.TextFormatter;

/**
 *
 * @author lrod
 */
public class PanelAddExtra extends PanelCapturaMod implements ActionListener {

    private final Aplication app;
    private String lb1, lb2, lb3, lb4, lb5;
    private int width = 100;

    /**
     * Creates new form PanelAddExtra
     *
     * @param app
     * @param pcl
     */
    public PanelAddExtra(Aplication app, PropertyChangeListener pcl) {
        this.app = app;

        initComponents();
        createComponents();

        addPropertyChangeListener(pcl);
    }

    private void createComponents() {
        lb1 = "Tipo";
        lb2 = "Categoria";
        lb3 = "Valor";
        lb4 = "Nota";
        lb5 = "Descripción";

        regTipo.setLabelText(lb1);
        regCategory.setLabelText(lb2);
        regDesc.setLabelText(lb5);
        regValor.setLabelText(lb3);
        regValor.setDocument(TextFormatter.getDoubleLimiter());
        regNote.setLabelText(lb4);

        String[] tipo = {"Salida", "Entrada"};
        regTipo.setText(tipo);

        ImageIcon icon = new ImageIcon(app.getImgManager().getImagen(app.getFolderIcons() + "add1.png", 20, 20));
        btAddCategory.setIcon(icon);
        btAddCategory.setActionCommand(AC_ADD_CATEGORY_EXTRA);
        btAddCategory.addActionListener(this);

        btSave.setText("Agregar");
        btSave.setActionCommand(AC_ADD_EXTRA);
        btSave.addActionListener(this);
        
        updateCategoriesList();

    }
    public static final String AC_ADD_CATEGORY_EXTRA = "AC_ADD_CATEGORY_EXTRA";

    private void checkExtra() {
        boolean valido = true;
        CashMov mov =null;
        if(regDesc.getText().trim().isEmpty()){
            regDesc.setBorder(bordeError);
            valido = false;
        }
        if(regValor.getText().trim().isEmpty()){
            regValor.setBorder(bordeError);
            valido = false;
        }
        if (regCategory.getSelected() < 1) {
            regCategory.setBorder(bordeError);
            valido = false;
        }if (regTipo.getSelected() < 0) {
            regTipo.setBorder(bordeError);
            valido = false;
        }
        if(valido){
            mov = new CashMov();
            long id = ((CashMov.Category)regCategory.getSelectedItem()).getId();
            mov.setIdCategory(id);
            
        }
        

    }

    public ArrayList<CashMov.Category> getCategoriesList() {
        ArrayList<CashMov.Category> categoriesList = app.getControl().getExpensesCategoriesList("", "category");
        return categoriesList;
    }

    private void updateCategoriesList() {
        List<CashMov.Category> list = getCategoriesList();
        list.add(0, new CashMov.Category(""));
        regCategory.setText(list.toArray());
    }

    private static final String AC_ADD_EXTRA = "AC_ADD_EXTRA";

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        regTipo = new com.bacon.gui.util.Registro(0,lb1, new String[0],width);
        regCategory = new com.bacon.gui.util.Registro(0, lb2, new String[0], width);
        regValor = new com.bacon.gui.util.Registro(0, lb3, "", width);
        regNote = new com.bacon.gui.util.Registro(0, lb4, "", width);
        regDesc = new com.bacon.gui.util.Registro(0, lb5, "", width);
        btSave = new javax.swing.JButton();
        btAddCategory = new javax.swing.JButton();

        jLabel1.setBackground(new java.awt.Color(147, 112, 112));
        jLabel1.setOpaque(true);

        btSave.setText("jButton1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(regNote, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(regTipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(regDesc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(regValor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btSave))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(regCategory, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                        .addGap(2, 2, 2)
                        .addComponent(btAddCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(regTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(regCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAddCategory))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(regDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(regValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(regNote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btSave)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btAddCategory, regCategory, regDesc, regNote, regTipo, regValor});

    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAddCategory;
    private javax.swing.JButton btSave;
    private javax.swing.JLabel jLabel1;
    private com.bacon.gui.util.Registro regCategory;
    private com.bacon.gui.util.Registro regDesc;
    private com.bacon.gui.util.Registro regNote;
    private com.bacon.gui.util.Registro regTipo;
    private com.bacon.gui.util.Registro regValor;
    // End of variables declaration//GEN-END:variables

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (PanelList.AC_ADD.equals(evt.getPropertyName())) {
            app.getControl().addExpenseCategory(evt.getNewValue().toString());
            updateCategoriesList();
        } else if (PanelList.AC_EDIT.equals(evt.getPropertyName())) {
            app.getControl().updateExpenseCategory(evt.getNewValue().toString(), evt.getOldValue().toString());
            updateCategoriesList();
        } else if (PanelList.AC_SELECTED.equals(evt.getPropertyName())) {
            regCategory.setText(evt.getNewValue().toString().toUpperCase());
        } else if (PanelList.AC_DELETE.equals(evt.getPropertyName())) {
            app.getControl().deleteUnit(evt.getNewValue().toString());
            updateCategoriesList();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (AC_ADD_EXTRA.equals(e.getActionCommand())) {
            checkExtra();
        } else if (AC_ADD_CATEGORY_EXTRA.equals(e.getActionCommand())) {
            List<CashMov.Category> list = app.getControl().getExpensesCategoriesList("", "category");
            app.getGuiManager().showPanelNewCategory("Categoria", this, list);
        }
    }
}
