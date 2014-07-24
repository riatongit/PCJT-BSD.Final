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
 * @author Naveen Dinuka
 */
public class Delete {

    private static Delete delete;
    connection.Connection connection = Connection.getInstance();

    private Delete() {
    }

    public static Delete getInstance() {
        if (delete == null) {
            delete = new Delete();
        }
        return delete;
    }

    public void recoverAccount(String accountName) {
        try {
            ResultSet resultSet = connection.getData("SELECT * FROM login WHERE username='" + accountName + "'");
            if (resultSet.next()) {
                int id = Integer.parseInt(resultSet.getString("general_user_profile_idgeneral_user_profile"));
                connection.putData("DELETE FROM deleted_accounts WHERE general_user_profile_idgeneral_user_profile='" + id + "'");
                Response.success("Account recovered successfully! :-)");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
