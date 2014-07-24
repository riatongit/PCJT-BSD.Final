/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.controlPanel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.JRadioButton;
import model.controlPanel.Delete;
import model.controlPanel.Save;
import model.controlPanel.Search;
import model.controlPanel.Validation;
import model.controlPanel.Update;

/**
 *
 * @author Naveen
 */
public class Actions {

    Date date;
    SimpleDateFormat simpleDateFormat;
    Map map;
    String loginId;

    public Actions(String loginId) {
        if (map == null) {
            map = new LinkedHashMap();
        }

        map = Search.getInstance().getUser(Integer.parseInt(this.loginId));
    }

    public void actionPassword(String currentPass, String newPass, String confirmPass) {

        if (Validation.getInstance().checkCurrPassword(currentPass, loginId)) {
            if (Validation.getInstance().checkNewPass(newPass, confirmPass)) {
                Update.getInstance().changePassword(newPass, loginId);
            } else {
                response.Response.error("Sorry 'New Password and Confirm Password' you entered did not match! :-(");
            }
        } else {
            response.Response.error("Sorry The current password you entered is incorrect! :-(");
        }

    }

    public void actionPicture(String path) {
        Update.getInstance().changePicture(path, loginId);
    }

    public void actionUserName(String newUserName) {
        Update.getInstance().changeUserName(newUserName, loginId);
    }

    public void actionAccType(int roleId, JRadioButton... jradionButtons) {
        if (roleId == 1) {
            for (JRadioButton jRadioButton : jradionButtons) {
                jRadioButton.setEnabled(false);
            }
        } else {
            Update.getInstance().changeType(roleId, loginId);
        }
    }

    public void deleteAccount(String accountName) {
        if (accountName.isEmpty()) {
            response.Response.error("Select the account again");
        } else {
            Save.getInstance().deleteUser(accountName);
            Save.getInstance().workerHistory(accountName, "This user has been deleted on " + getDate() + " by" + map.get("fname") + " " + map.get("lname"));
        }
    }

    public void recoverAccount(String accountName) {
        if (accountName.isEmpty()) {
            response.Response.error("Select the account again");
        } else {
            Delete.getInstance().recoverAccount(accountName);
            Save.getInstance().workerHistory(accountName, "This user account has been recovered on " + getDate() + " by" + map.get("fname") + " " + map.get("lname"));
        }
    }

    String getDate() {
        if (date == null) {
            date = new Date();
        }
        if (simpleDateFormat == null) {
            simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mma");
        }

        String sDate = simpleDateFormat.format(date);
        return sDate;
    }
}
