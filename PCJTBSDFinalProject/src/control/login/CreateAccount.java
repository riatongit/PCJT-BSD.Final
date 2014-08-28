/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.login;

import control.City;
import control.Role;
import control.User;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import model.Login.Signup;

/**
 *
 * @author Naveen
 */
public class CreateAccount {

    private static CreateAccount createAccount;
    private String accountName;
    private String userNic;
    private String userFirstName;
    private String userLastName;
    private String userCity;
    private String password;
    private String userRole;

    private CreateAccount() {
    }

    public static CreateAccount getInstance() {
        if (createAccount == null) {
            createAccount = new CreateAccount();
        }
        return createAccount;
    }

    public void createAcc(JTextField accName, JPasswordField pass, JTextField nic, JTextField firstName, JTextField lastName, JComboBox city, JComboBox role) {
        accountName = accName.getText();
        userNic = nic.getText();
        userFirstName = firstName.getText();
        userLastName = lastName.getText();
        userCity = city.getSelectedItem().toString();
        userRole = role.getSelectedItem().toString();
        password = new String(pass.getPassword());

        if (accountName.isEmpty() || password.isEmpty() || userNic.isEmpty() || userFirstName.isEmpty() || userLastName.isEmpty() || userCity.isEmpty() || userRole.isEmpty()) {
            response.Response.error("Complete all fields to continue");
        } else if (!control.User.getInstance().validateUser(accountName)) {
            response.Response.error("The account name you entered is already exist");
        } else {
            try {
                Signup.getInstance().createUserProfile(userNic, userFirstName,
                        userLastName, City.getInstance().getCityID(userCity));
                
                Signup.getInstance().createLoginProfile(accountName, password,
                        User.getInstance().getUserId(userNic), Role.getInstance().getRoleId(userRole));
                
                response.Response.success("User Account created successfully... :)");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
