/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author Naveen Dinuka
 */
public class collectionTest {

    static Map m;

    public static void main(String[] args) {
        if (m == null) {
            m = new LinkedHashMap();
        }
        m.put("aaa", "aaA");
        m.put("7", "A");
        System.out.println(m.get("aaa"));
        System.out.println(m);

    }
}
