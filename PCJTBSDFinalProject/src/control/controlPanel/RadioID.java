/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.controlPanel;

import javax.swing.JRadioButton;

/**
 *
 * @author Naveen Dinuka
 */
public class RadioID {

    static JRadioButton jRadioButton;
    static int id;

    public static int getRadioId(JRadioButton... jRadioButtons) {
        for (int i = 0; i < jRadioButtons.length; i++) {
            jRadioButton = jRadioButtons[i];
            if (jRadioButton.isSelected()) {
                id = ++i;
                break;
            }
        }
        return id;
    }

}
