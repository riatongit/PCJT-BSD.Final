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
public class City {

    private static City city;
    private int cityId = 0;

    private City() {
    }

    public static City getInstance() {
        if (city == null) {
            city = new City();
        }
        return city;
    }

    public int getCityID(String cityName) {
        if (!cityName.isEmpty()) {
            try {
                cityId = model.City.getInstance().getCity(cityName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            response.Response.error("Declare a city name to continue");
        }

        return cityId;
    }
}
