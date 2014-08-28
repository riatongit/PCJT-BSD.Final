/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Login;

/**
 *
 * @author Naveen
 */
public class Signup {

    private static Signup signup;

    private Signup() {
    }

    public static Signup getInstance() {
        if (signup == null) {
            signup = new Signup();
        }
        return signup;
    }

    public void createUserProfile(String nic, String firstName, String lastName, int cityId) throws Exception {
        connection.Connection.getInstance().putData("INSERT INTO general_user_profile(nic,fname,lname,city_idcity)"
                + " VALUES('" + nic + "','" + firstName + "','" + lastName + "','" + cityId + "')");
    }

    public void createLoginProfile(String accountName, String password, int userId, int roleId) throws Exception {
        connection.Connection.getInstance().putData("INSERT INTO login "
                + "VALUES('" + accountName + "','" + password + "','" + roleId + "','" + userId + "')");
    }
}
