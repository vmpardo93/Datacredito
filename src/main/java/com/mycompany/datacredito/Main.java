/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.datacredito;

import Logica.Core;


/**
 *
 * @author Darkgrey93
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
            // TODO code application logic here
            Core logica=new Core();
            try{
                logica.leerArchivo();
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
            logica.menu();
        
                
    }
    
}
