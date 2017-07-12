/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asses2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Vinay
 */
public class buttonActions implements ActionListener{
    public int number;              
    public atmInterface UI;
    
    
    public buttonActions(int number, atmInterface UI) {
        this.number = number;
        this.UI = UI;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        UI.rightNum += number;  
        UI.updateGUI();
    }
}
