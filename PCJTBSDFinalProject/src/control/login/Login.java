/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.login;

import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import model.controlPanel.Validation;
import view.home.Home;

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

    public void checkLogin(JTextField username, JPasswordField password, JFrame loginFrame) {
        this.username = username.getText();
        this.password = new String(password.getPassword());

        if (Validation.getInstance().validateUnPw(username, password)) {
            try {
                ResultSet resultSet = model.Login.Login.getInstance().loginSys(this.username, this.password);
                System.out.println(resultSet.wasNull());
                if (resultSet.next()) {
                    loginFrame.dispose();
                    new Home().setVisible(true);
                } else {
                    response.Response.error("Username and Password you entered is incorrect :(");
                }
            } catch (MySQLSyntaxErrorException e) {
                response.Response.error("Check your database and try again");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            response.Response.error("Enter username and Password to Continue :P");
        }
    }

}
