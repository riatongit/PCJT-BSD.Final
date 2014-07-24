/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.invoice;

import java.util.Vector;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AKASH
 */
public class AddToTable {

    private static AddToTable addToTable;

    private AddToTable() {
    }

    public static AddToTable getInstance() {
        if (addToTable == null) {
            addToTable = new AddToTable();
        }
        return addToTable;
    }

    public void setToTable(JTable table, JTextField txt_proID, JTextField txt_qty) {

        try {
            DefaultTableModel dt = (DefaultTableModel) table.getModel();
            Vector v = new Vector();

            v.add(txt_proID.getText());
            v.add(txt_qty.getText());
            dt.addRow(v);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
