/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.invoice;

import java.awt.Event;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Akash Perera
 */
public class Control {

    private static Control control;

    private Control() {
    }

    public static Control getInstance() {
        if (control == null) {
            control = new Control();
        }
        return control;
    }

    public void keyFocus(JTextField textField, JComboBox comboBox, KeyEvent evt) {
        if (evt.getKeyCode() == 40) {
            KeyHandling.getInstance().setFocusComboBox(comboBox);
        }
        if (evt.getKeyCode() == KeyEvent.VK_RIGHT || evt.getKeyCode() == KeyEvent.VK_LEFT) {
            KeyHandling.getInstance().setFocusTextField(textField);
        }
    }

    public void searchProduct(JTextField text, JComboBox comboBox, KeyEvent evt) {
        if (!(evt.getKeyCode() == KeyEvent.VK_RIGHT || evt.getKeyCode() == KeyEvent.VK_LEFT)) {
            Add.getInstance().setProduct(text, comboBox);
        }
    }

    public void searchToTable(JTextField txt_proID, JTextField txt_qty, JTextField txt_waiterID, JTable jTable1, JLabel lab_total) {
        if (!(txt_proID.getText().isEmpty() || txt_qty.getText().isEmpty() || txt_waiterID.getText().isEmpty())) {
            Add.getInstance().setToTable(jTable1, txt_proID, txt_qty, lab_total);
        } else {
            response.Response.error("Please Insert Data");
        }
    }
}
