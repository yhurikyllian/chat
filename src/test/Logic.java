/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.lang.reflect.Array;

/**
 *
 * @author sora
 */
public class Logic {
    private String[] userArray;
    private static String pattern = "";
    
    private void setArray(String pattern){
        int counter = 0;
        userArray = pattern.split(";");
        
        for(int i=0; i<userArray.length; i++){
            System.out.println("user : "+i+ " "+ userArray[i]);
        }
        
    }
    
    private void setPattern(String pattern){
        
        if(this.pattern.equals("")){
            this.pattern += pattern;
        } else {
            this.pattern += ";" + pattern;
        }
        System.out.println("pattern : " + this.pattern);
    }
    
    public static void main(String[] args){
        Logic a = new Logic();
        a.setPattern("makan");
        a.setArray(pattern);
        a.setPattern("gila");
        a.setArray(pattern);
    }
}
