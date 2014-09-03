/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.invoice;

import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
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
    private double tot;
    private String pro_name;
    private String pro_price;
    private double u_price;
    private String searchPro_name;
    private Vector v;

    private Add() {
    }

    public static Add getInstance() {
        if (add == null) {
            add = new Add();
        }
        return add;
    }

    public void setToTable(JTable table, JTextField txt_proID, JTextField txt_qty, JLabel label_total) {

        int qty = Integer.parseInt(txt_qty.getText());
        //~~~~~~~~~~~~~~~~~ GET RESULT FROM product TABLE~~~~~~~~~~~~~~~~~~~~~~~~
        String resultList[] = Search.getInstance().searchInvoiceTable(txt_proID.getText());
        pro_name = resultList[0];
        pro_price = resultList[1];
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        u_price = Double.parseDouble(pro_price);
        //~~~~~~~~~~~~~~~~~GET THE SUB TOTAL ~~~~~~~~~~~~~~~~~~~~~~~~
        tot = qty * u_price;
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        try {
            DefaultTableModel dt = (DefaultTableModel) table.getModel();
            Vector v = new Vector();

            v.add(pro_name);
            v.add(txt_qty.getText());
            v.add(u_price);
            v.add(tot);
            dt.addRow(v);

            label_total.setText(setTotal(dt) + "");
            txt_proID.setText(null);
            txt_qty.setText(null);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private double setTotal(DefaultTableModel dt) {
        double total = 0;

        for (int i = 0; i < dt.getRowCount(); i++) {
            total += Double.parseDouble(dt.getValueAt(i, 3).toString());
        }

        return total;
    }

    public void setProduct(JTextField product_name, JComboBox search_box) {
        searchPro_name = product_name.getText();
        if (searchPro_name.isEmpty()) {
            search_box.hidePopup();
            search_box.removeAllItems();
        } else {
            try {
                ResultSet rs = Search.getInstance().productToTextField(searchPro_name);
                v = new Vector();
                while (rs.next()) {
                    v.add(rs.getString("product_name"));
                }

                search_box.setModel(new DefaultComboBoxModel(v));
                search_box.showPopup();
//            product_name.setText(search_box.getSelectedItem().toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
