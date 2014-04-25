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
public class Save {

    connection.Connection connection;

    public Save() {
        if (connection == null) {
            connection = new Connection();
        }
    }

    public void newUser() {

    }

    public void deleteUser(String accountName) {
        try {
            ResultSet resultSet = connection.getData("SELECT * FROM login WHERE username='" + accountName + "'");
            if (resultSet.next()) {
                int id = Integer.parseInt(resultSet.getString("general_user_profile_idgeneral_user_profile"));
                connection.putData("INSERT INTO deleted_accounts VALUES('" + id + "')");
                Response.success("Account deleted successfully! :-)");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void workerHistory(String accountName, String description) {
        try {
            ResultSet resultSet = connection.getData("SELECT * FROM login WHERE username='" + accountName + "'");
            if (resultSet.next()) {
                int id = Integer.parseInt(resultSet.getString("general_user_profile_idgeneral_user_profile"));
                connection.putData("INSERT INTO worker_history VALUES('" + id + "','" + description + "')");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
