/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;

/**
 *
 * @author Naveen
 */
public class User {

    private static User user;
    private int userId;

    private User() {
    }

    public static User getInstance() {
        if (user == null) {
            user = new User();
        }
        return user;
    }

    public int getUser(String userNic) throws Exception {
        ResultSet resultSet = connection.Connection.getInstance().getData("SELECT idgeneral_user_profile FROM general_user_profile WHERE nic='" + userNic + "'");
        if (resultSet.next()) {
            userId = Integer.parseInt(resultSet.getString("idgeneral_user_profile"));
            return userId;
        } else {
            return 0;
        }
    }

    public boolean validateUser(String userName) throws Exception {
        ResultSet resultSet = connection.Connection.getInstance().getData("SELECT * FROM login WHERE username='" + userName + "'");
        return resultSet.next();
    }
}
