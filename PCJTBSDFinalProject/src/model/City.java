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
public class City {

    private static City city;
    private int cityId;

    private City() {
    }

    public static City getInstance() {
        if (city == null) {
            city = new City();
        }
        return city;
    }

    public int getCity(String cityName) throws Exception {
        ResultSet resultSet = connection.Connection.getInstance().getData("SELECT idcity FROM city WHERE city_name='" + cityName + "'");
        if (resultSet.next()) {
            cityId = Integer.parseInt(resultSet.getString("idcity"));
            return cityId;
        } else {
            return 0;
        }
    }

}
