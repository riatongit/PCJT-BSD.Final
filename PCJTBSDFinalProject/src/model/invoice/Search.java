/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.invoice;

import java.sql.ResultSet;
import javax.swing.JTextField;

/**
 *
 * @author AKASH
 */
public class Search {

    private String resultQty;
    private String resultPro_name;
    String qty;
    private static Search search;

    private Search() {
    }

    public static Search getInstance() {
        if (search == null) {
            search = new Search();
        }
        return search;

    }

    public String[] searchInvoiceTable(String txt_prodID) {

        String returnString[] = new String[2];

        try {
            ResultSet rs = connection.Connection.getInstance().getData("SELECT * FROM product WHERE product_name='" + txt_prodID + "'");

            while (rs.next()) {
                resultPro_name = rs.getString("product_name");
                resultQty = rs.getString("unit_price");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        returnString[0] = resultPro_name;
        returnString[1] = resultQty;
        return returnString;
    }

    public ResultSet productToTextField(String productName) {

        try {
            ResultSet rs = connection.Connection.getInstance().getData("SELECT * FROM product WHERE product_name LIKE '" + productName + "%'");

            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
