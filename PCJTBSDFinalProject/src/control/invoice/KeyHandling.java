/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.invoice;

import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author Akash Perera
 */
public class KeyHandling {

    private static KeyHandling keyHandling;

    private KeyHandling() {
    }

    public static KeyHandling getInstance() {
        if (keyHandling == null) {
            keyHandling = new KeyHandling();
        }
        return keyHandling;

    }

    public void setFocusTextField(JTextField textField) {
        textField.grabFocus();
    }

    public void setFocusComboBox(JComboBox comboBox) {
        comboBox.requestFocus();
    }
}
