/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica19.mainwindow;

import practica19.library.Library;

/**
 *
 * @author AlbertoMarun
 */
public class FindAuthorWindow extends javax.swing.JDialog {
    private MainWindow parent;
    /**
     * Creates new form FindAuthorWindow
     */
    public FindAuthorWindow(MainWindow parent) {
        initComponents();
        this.parent = parent;
        input_author_filter.setText(Library.getAuthorFilter());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        input_author_filter = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Filtro de Autor");
        setPreferredSize(new java.awt.Dimension(400, 90));
        setResizable(false);

        input_author_filter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                input_author_filterKeyTyped(evt);
            }
        });
        getContentPane().add(input_author_filter, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void input_author_filterKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_input_author_filterKeyTyped
        Library.setAuthorFilter(input_author_filter.getText());
        this.parent.updateTable();
    }//GEN-LAST:event_input_author_filterKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField input_author_filter;
    // End of variables declaration//GEN-END:variables
}
