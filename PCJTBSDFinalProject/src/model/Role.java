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
public class Role {

    private static Role role;
    private int roleId;

    private Role() {
    }

    public static Role getInstance() {
        if (role == null) {
            role = new Role();
        }
        return role;
    }

    public int getRole(String roleName) throws Exception {
        ResultSet resultSet = connection.Connection.getInstance().getData("SELECT idrole FROM role WHERE role_name='" + roleName + "'");
        if (resultSet.next()) {
            roleId = Integer.parseInt(resultSet.getString("idcity"));
            return roleId;
        } else {
            return 0;
        }
    }
}
