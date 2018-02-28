/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

/**
 *
 * @author Jarek
 */
class GamePanel extends JPanel {
    NumberTile [] pictures = new NumberTile[81];
    Specimen [] population = new Specimen [100];
    
    public GamePanel () {
        setName("gamePanel");
        setPreferredSize( new Dimension(500,500) );
        SpringLayout springLayout = new SpringLayout();
        setLayout(springLayout);
        setBackground(Color.WHITE);
        
        for( int i=0;i<pictures.length;i++){
                pictures[i] = new NumberTile( new ImageIcon("C:\\Users\\Jarek\\Documents\\NetBeansProjects\\Sudoku\\numbers\\random.png"),0);
                add(pictures[i]);
                springLayout.putConstraint(SpringLayout.WEST, pictures[i], i%9==0? 8 : 4, i%9==0? SpringLayout.WEST : SpringLayout.EAST, i%9==0? this : pictures[(i-1)]);
                springLayout.putConstraint(SpringLayout.NORTH, pictures[i], i<9? 8 : 4, i<9? SpringLayout.NORTH : SpringLayout.SOUTH, i<9? this : pictures[(i-9)]);
        }
    }
    
    public void solve(){
        System.out.println("DZIAŁA!!!");
    }
    
    //Metoda wyświetlająca losowo wygenerowane sudoku ( pierwsze z populacji )
    public void showGrid(){
        for(int i=0;i<81;i++){
            pictures[i].setCount(population[0].gridNumbers[i]);
        }
    }
    
    public void repaint(Graphics g){
        for (NumberTile il : pictures){
            il.repaint();
        }
    }
    
    //inicjacja nowej populacji
    public void initiatePopulation(){
        int [] grid = new int[pictures.length];
        for(int i=0; i<grid.length;i++){
            grid[i] = pictures[i].getCount();
        }
        for(int i=0; i<population.length;i++){
            population[i]= new Specimen(grid);
        }        
    }
}
