/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Jarek
 */
class OptionsPanel extends JPanel{
    OptionsPanel op = this;
    
    public OptionsPanel(){
        setBackground(Color.red); 
        JButton start = new JButton("Rozwiąż sudoku");
        start.addActionListener((ActionEvent e) -> {
            Component [] components = op.getParent().getComponents();
            GamePanel gp = null;
            for(Component c : components){
                if(c.getName().equals("gamePanel")){
                    gp = (GamePanel) c;
                    gp.solve();
                } 
            }    
        });
        this.add(start);
    }
}
