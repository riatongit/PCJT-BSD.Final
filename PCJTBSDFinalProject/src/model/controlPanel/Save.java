/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.controlPanel;

import connection.Connection;

/**
 *
 * @author Naveen Dinuka
 */
public class Save {

    connection.Connection connection;

    public Save() {
        if (connection == null) {
            connection = new Connection();
        }
    }
    
    public void newUser(){
    
    }
    
}
