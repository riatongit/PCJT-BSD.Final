/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.controlPanel;

import javax.swing.JRadioButton;
import model.controlPanel.Validation;
import model.controlPanel.Update;

/**
 *
 * @author Naveen
 */
public class Actions {

    Update update;
    Validation validation;

    String loginId;

    public Actions(String loginId) {

        this.loginId = loginId;

        if (update == null) {
            update = new Update();
        }
        if (validation == null) {
            validation = new Validation();
        }
    }

    public void actionPassword(String currentPass, String newPass, String confirmPass) {

        if (validation.checkCurrPassword(currentPass, loginId)) {
            if (validation.checkNewPass(newPass, confirmPass)) {
                update.changePassword(newPass, loginId);
            } else {
                response.Response.error("Sorry 'New Password and Confirm Password' you entered did not match! :-(");
            }
        } else {
            response.Response.error("Sorry The current password you entered is incorrect! :-(");
        }

    }

    public void actionPicture(String path) {
        update.changePicture(path, loginId);
    }

    public void actionUserName(String newUserName) {
        update.changeUserName(newUserName, loginId);
    }

    public void actionAccType(int roleId, JRadioButton... jradionButtons) {
        if (roleId == 1) {
            for (JRadioButton jRadioButton : jradionButtons) {
                jRadioButton.setEnabled(false);
            }
        } else {
            update.changeType(roleId, loginId);
        }
    }

}
