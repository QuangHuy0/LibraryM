/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import view.BookFrame;
import view.LoginFrame;
import view.MainFrame;

/**
 *
 * @author Uygi
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LoginFrame lg = new LoginFrame();
        lg.setLocationRelativeTo(null);
        lg.setVisible(true);
        lg.setResizable(false);
        
    }
    
}
