/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

/**
 *
 * @author Naveen
 */
public class view {
    public static void main(String[] args) {
        view a=new view();
        
        if(a.m()){
            System.out.println("right");
        }else{
            System.out.println("null");
        }
    }
    
    public boolean m(){
        return false;
    }
}
