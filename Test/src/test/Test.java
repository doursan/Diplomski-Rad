/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Dusan
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        A a = new A();
        B b = new B();
        C c = new C();
        
        writeClass(c);
    }
    
    public static void writeClass(A a) {
        if(a instanceof B) {
            System.out.println("Ovo je B klasa");
        }
        else if(a instanceof C) {
            System.out.println("Ovo je C klasa");
        }
        else {
            System.out.println("Nije ni B ni C");
        }
    }
    
}
