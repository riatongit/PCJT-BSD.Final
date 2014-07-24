/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.controlPanel;

import javax.swing.JComponent;
import javax.swing.JDesktopPane;

/**
 *
 * @author Naveen
 */
public class PanelVisibility {

    private static PanelVisibility panelVisibility;
    static JDesktopPane currenDesktopPane;

    private PanelVisibility() {
    }

    public static PanelVisibility getInstance() {
        if (panelVisibility == null) {
            panelVisibility = new PanelVisibility();
        }
        return panelVisibility;
    }

    public final void visibilityFalse(JComponent... components) {
        for (JComponent component : components) {
            component.setVisible(false);
        }
    }

    public final void visibilityTrue(JDesktopPane currentDesktopPane, JComponent... components) {
        for (JComponent component : components) {
            component.setVisible(true);
        }
        PanelVisibility.currenDesktopPane = currentDesktopPane;
    }
}
