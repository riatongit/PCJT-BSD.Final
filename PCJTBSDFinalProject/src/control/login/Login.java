/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.login;

import javax.swing.JPasswordField;
import javax.swing.JTextField;
import sun.security.util.Password;

/**
 *
 * @author Naveen
 */
public class Login {

    private static Login login;
    private String username;
    private String password;

    private Login() {
    }

    public static Login getInstance() {
        if (login == null) {
            login = new Login();
        }
        return login;
    }

    public void checkLogin(JTextField username, JPasswordField password) {
        this.username = username.getText();
        this.password = new String(password.getPassword());
        System.out.println(this.password);
    }

}
