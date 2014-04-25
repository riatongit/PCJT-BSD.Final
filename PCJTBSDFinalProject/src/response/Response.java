/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package response;

import javax.swing.JOptionPane;

/**
 *
 * @author Naveen
 */
public class Response {

    public static void success(String response) {
        JOptionPane.showMessageDialog(null, response, "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void error(String response) {
        JOptionPane.showMessageDialog(null, response, "ERROR", JOptionPane.ERROR_MESSAGE);
    }
}
