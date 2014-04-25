/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.controlPanel;

import connection.Connection;
import java.sql.ResultSet;
import response.Response;

/**
 *
 * @author Naveen
 */
public class Update {

    connection.Connection connection;

    public Update() {
        if (connection == null) {
            connection = new Connection();
        }
    }

    public void changePassword(String getNewPassword, String getid) {
        try {
            connection.putData("UPDATE login SET password='" + getNewPassword + "' WHERE idlogin='" + getid + "'");
            Response.success("Password changed successfully! :-)");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void changePicture(String getPath, String getId) {

        String getGenUserId = null;

        try {
            ResultSet rs = connection.getData("SELECT general_user_profile_idgeneral_user_profile FROM login WHERE idlogin='" + getId + "'");
            while (rs.next()) {
                getGenUserId = rs.getString("general_user_profile_idgeneral_user_profile");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            connection.putData("UPDATE general_user_profile set image='" + getPath + "' WHERE idgeneral_user_profile='" + getGenUserId + "'");
            Response.success("Account picture changed successfully! :-)");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void changeUserName(String newUserName, String getId) {
        try {
            connection.putData("UPDATE login set username='" + newUserName + "' WHERE idlogin='" + getId + "'");
            Response.success("Username updated successfully! :-)");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void changeType(int getRoleValue, String getId) {
        try {
            connection.putData("UPDATE login set role_idrole='" + getRoleValue + "' WHERE idlogin='" + getId + "'");
            Response.success("Account type changed successfully! :-)");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
