/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.controlPanel;

import connection.Connection;
import java.sql.ResultSet;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author Naveen Dinuka
 */
public class Search {

    private static Search search;
    connection.Connection connection = Connection.getInstance();
    Map map;

    private Search() {
        if (map == null) {
            map = new LinkedHashMap();
        }
    }

    public static Search getInstance() {
        if (search == null) {
            search = new Search();
        }
        return search;
    }

    public Map getUser(int id) {
        try {
            ResultSet resultSet = connection.getData("SELECT * FROM login WHERE idlogin='" + id + "'");
            if (resultSet.next()) {
                map.put("username", resultSet.getString("username"));
                map.put("password", resultSet.getString("password"));
                map.put("idrole", Integer.parseInt(resultSet.getString("role_idrole")));
                map.put("idgeneral_user_profile", resultSet.getString("general_user_profile_idgeneral_user_profile"));

                ResultSet resultSetUserDet = connection.getData("SELECT * FROM general_user_profile WHERE idgeneral_user_profile='" + resultSet.getString("general_user_profile_idgeneral_user_profile") + "'");
                while (resultSetUserDet.next()) {
                    map.put("nic", resultSetUserDet.getString("nic"));
                    map.put("fname", resultSetUserDet.getString("fname"));
                    map.put("lname", resultSetUserDet.getString("lname"));
                    map.put("address_no", resultSetUserDet.getString("address_no"));
                    map.put("address_street", resultSetUserDet.getString("address_street"));
                    map.put("city", getCity(Integer.parseInt(resultSetUserDet.getString("city_idcity"))));
                    map.put("mobile", resultSetUserDet.getString("mobile"));
                    map.put("image", resultSetUserDet.getString("image"));
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;

    }

    public String getRole(int roleId) {

        String role = null;

        try {
            ResultSet resultSet = connection.getData("SELECT * FROM role WHERE idrole='" + roleId + "'");
            if (resultSet.next()) {
                role = resultSet.getString("role_name");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return role;

    }

    public String getCity(int cityId) {

        String city = null;

        try {
            ResultSet resultSet = connection.getData("SELECT * FROM city WHERE idcity='" + cityId + "'");
            if (resultSet.next()) {
                city = resultSet.getString("city_name");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return city;

    }
}
