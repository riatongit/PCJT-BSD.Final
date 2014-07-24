/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.controlPanel;

import javax.swing.JPanel;

/**
 *
 * @author Naveen
 */
public class BackKey {

    private static BackKey backKey;

    private BackKey() {
    }

    public static BackKey getInstance() {
        if (backKey == null) {
            backKey = new BackKey();
        }
        return backKey;
    }

    public void goBack(JPanel panel) {
        PanelVisibility.currenDesktopPane.setVisible(false);
        panel.setVisible(false);
    }
}
