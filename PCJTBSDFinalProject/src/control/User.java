/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

/**
 *
 * @author Naveen
 */
public class User {

    private static User user;
    private int userId;
    private boolean isValidUsername = false;

    private User() {
    }

    public static User getInstance() {
        if (user == null) {
            user = new User();
        }
        return user;
    }

    public int getUserId(String userNic) {
        if (!userNic.isEmpty()) {
            try {
                userId = model.User.getInstance().getUser(userNic);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            response.Response.error("Declare a NIC to continue");
        }

        return userId;
    }

    public boolean validateUser(String userName) {
        if (!userName.isEmpty()) {
            try {
                if (model.User.getInstance().validateUser(userName)) {
                    isValidUsername = true;
                } else {
                    isValidUsername = false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            response.Response.error("Declare a Username to continue");
        }

        return isValidUsername;
    }

}
