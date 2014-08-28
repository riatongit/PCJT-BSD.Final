/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Login;

import java.sql.ResultSet;

/**
 *
 * @author Naveen
 */
public class Login {

    private static Login login;

    private Login() {
    }

    public static Login getInstance() {
        if (login == null) {
            login = new Login();
        }
        return login;
    }

    public ResultSet loginSys(String username, String password) throws Exception {
        return connection.Connection.getInstance().getData("SELECT * FROM login WHERE username='" + username + "' AND password = '" + password + "'");
    }

}
