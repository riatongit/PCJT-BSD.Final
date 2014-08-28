/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.invoice;

import java.sql.ResultSet;

/**
 *
 * @author AKASH
 */
public class Search {

    private static Search search;

    private Search() {
    }

    public static Search getInstance() {
        if (search == null) {
            search = new Search();
        }
        return search;

    }

    public void searchInvoiceTable(String txt_prodID) {
        try {
            ResultSet rs =  connection.Connection.getInstance().getData("SELECT * FROM product WHERE idproduct'"+txt_prodID+"'");
        } catch (Exception e) {
            
        }
        
    }
}
