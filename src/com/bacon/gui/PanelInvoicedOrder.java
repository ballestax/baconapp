package com.bacon.gui;

import com.bacon.Aplication;
import com.bacon.Utiles;
import com.bacon.domain.Order;
import com.bacon.domain.ProductoPed;
import com.bacon.gui.util.TableSelectCellRenderer;
import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.SwingUtilities;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import org.dz.ListSelection;
import org.dz.MyDefaultTableModel;
import org.dz.PanelCapturaMod;

/**
 *
 * @author lrod
 */
public class PanelInvoicedOrder extends PanelCapturaMod implements TableModelListener {

    private final Aplication app;
    private MyDefaultTableModel model;
    private ListSelection listaSeleccion;
    private Order order;

    /**
     * Creates new form PanelInvoicedOrder
     */
    public PanelInvoicedOrder(Aplication app) {
        this.app = app;
        initComponents();
        createComponents();
    }

    public void setOrder(Order order) {
        this.order = order;
        loadData();
    }

    private void createComponents() {

        String[] colNames = {"Sel", "Producto", "Cantidad", "V. Unit.", "V. Total"};
        ArrayList<String> asList = new ArrayList<>(Arrays.asList(colNames));

        ProductRenderer prodRenderer = new ProductRenderer(BoxLayout.Y_AXIS);
        prodRenderer.setIconPainted(false);
        prodRenderer.setSelectionBackgroundColor(TableSelectCellRenderer.getCOLOR_CHECK());
        prodRenderer.setMarked(true);
        

        model = new MyDefaultTableModel(asList.toArray(), 0);
        tableProducts.setModel(model);
        tableProducts.getTableHeader().setReorderingAllowed(false);
        listaSeleccion = new ListSelection(tableProducts);

        tableProducts.setRowHeight(24);
        tableProducts.getTableHeader().addMouseListener(listaSeleccion);
        model.addTableModelListener(this);

        int[] colW = {5, 220, 20, 30, 40};

        for (int i = 0; i < tableProducts.getColumnCount(); i++) {
            tableProducts.getColumnModel().getColumn(i).setCellRenderer(new TableSelectCellRenderer(true));
            tableProducts.getColumnModel().getColumn(i).setMinWidth(colW[i]);
            tableProducts.getColumnModel().getColumn(i).setPreferredWidth(colW[i]);
        }

        tableProducts.getColumnModel().getColumn(0).setHeaderRenderer(listaSeleccion);        
        tableProducts.getColumnModel().getColumn(0).setCellEditor(tableProducts.getDefaultEditor(Boolean.class));
        tableProducts.getColumnModel().getColumn(1).setCellRenderer(prodRenderer);
    }

    public void loadData() {
        if (order != null) {
            List<ProductoPed> products = order.getProducts();
            for (ProductoPed product : products) {
                model.addRow(new Object[]{
                    false,
                    product,
                    app.DCFORM_P.format(product.getCantidad()),
                    app.DCFORM_P.format(product.getPrecio()),
                    app.DCFORM_P.format(product.getPrecio() * product.getCantidad())
                });
            }
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tableProducts = new javax.swing.JTable();

        tableProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tableProducts);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableProducts;
    // End of variables declaration//GEN-END:variables

    @Override
    public void tableChanged(TableModelEvent e) {
        if (e.getColumn() == 0) {
                System.out.println("here:"+e.getColumn());
            int row = e.getLastRow();
            if (Boolean.valueOf(model.getValueAt(row, 0).toString())) {
                ((ProductRenderer) tableProducts.getCellRenderer(row, 1)).setBackground(Color.red);
            }else{
                ((ProductRenderer) tableProducts.getCellRenderer(row, 1)).setBackground(Color.yellow);
            }
            updateTabla();
        }
        
    }

    private void updateTabla() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                tableProducts.updateUI();
            }
        });
    }

    public int[] getSelectedsRows() {
        int[] sel = new int[model.getRowCount()];
        Arrays.fill(sel, -1);
        for (int i = 0; i < model.getRowCount(); i++) {
            if ((Boolean) model.getValueAt(i, 0) == true) {
                sel[i] = i;
            }
        }
        sel = Utiles.truncar(sel, 0, Integer.MAX_VALUE);
        Arrays.sort(sel);
        return sel;
    }
}