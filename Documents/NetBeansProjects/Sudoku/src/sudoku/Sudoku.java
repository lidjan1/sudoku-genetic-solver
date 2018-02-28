/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.SpringLayout;

/**
 *
 * @author Jarek
 */
public class Sudoku extends JFrame {
    private final GamePanel gamePanel;
    private final OptionsPanel optionsPanel;
    
    public Sudoku () {
        Dimension ScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setPreferredSize( new Dimension(1000,550) );
        
        GamePanel gamePanel = new GamePanel();
        this.gamePanel = gamePanel;
        
        OptionsPanel optionsPanel = new OptionsPanel();
        this.optionsPanel = optionsPanel;
        
        OptionsBar optionsBar = new OptionsBar();
        
        SpringLayout springLayout = new SpringLayout();
        setLayout(springLayout);
        add(gamePanel);
        add(optionsPanel);
        setJMenuBar(optionsBar);
        
        
        springLayout.putConstraint(SpringLayout.WEST, gamePanel, 10, SpringLayout.WEST, this.getContentPane());
        springLayout.putConstraint(SpringLayout.NORTH, gamePanel, 10, SpringLayout.NORTH, this.getContentPane());
        
        springLayout.putConstraint(SpringLayout.WEST, optionsPanel, 10, SpringLayout.EAST, gamePanel);
        springLayout.putConstraint(SpringLayout.NORTH, optionsPanel, 10, SpringLayout.NORTH, this.getContentPane());
        
        pack();
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater( new Runnable (){
            @Override
            public void run() {
                Sudoku sudoku = new Sudoku();
                sudoku.setVisible(true);
            }        
        });
    }
    
}
