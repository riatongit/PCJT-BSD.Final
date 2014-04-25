/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Naveen Dinuka
 */
public class dateTest {

    public static void main(String[] args) {

        Date d;
        SimpleDateFormat sdt;
        d=new Date();
        sdt=new SimpleDateFormat("yyyy/MM/dd");
        System.out.println(sdt.format(d));

    }
}
