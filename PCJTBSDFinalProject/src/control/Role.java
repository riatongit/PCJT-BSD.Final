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

    public int getRoleId(String roleName) {
        if (!roleName.isEmpty()) {
            try {
                roleId = model.Role.getInstance().getRole(roleName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            response.Response.error("Declare a role to continue");
        }

        return roleId;
    }
}
