/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.invoice;

import java.util.Vector;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.invoice.Search;

/**
 *
 * @author AKASH
 */
public class Add {

    private static Add add;

    private Add() {
    }

    public static Add getInstance() {
        if (add == null) {
            add = new Add();
        }
        return add;
    }

    public void setToTable(JTable table, JTextField txt_proID, JTextField txt_qty) {

        try {
            DefaultTableModel dt = (DefaultTableModel) table.getModel();
            Vector v = new Vector();

            v.add(txt_proID.getText());
            v.add(txt_qty.getText());
            Search.getInstance().searchInvoiceTable(txt_proID.toString());
            dt.addRow(v);
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
