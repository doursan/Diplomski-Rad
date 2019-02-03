/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Dusan
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        LocalDate datum = LocalDate.now();
        
        String parsed = datum.toString();
        
        LocalDate parsiran = LocalDate.parse(parsed);
        
        System.out.println(datum.toString());
    }
}
