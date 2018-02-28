/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Jarek
 */
class NumberTile extends JLabel implements MouseListener {
    private ImageIcon icon;
    private int count;
    
    NumberTile(ImageIcon imageIcon, int valueOfNumber) {   // 0 stands for random
        super(imageIcon);
        icon = imageIcon;
        count = valueOfNumber;
        addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        ;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(SwingUtilities.isLeftMouseButton(e)){
            increment();
        } else if(SwingUtilities.isRightMouseButton(e)){
            decrement();
        } 
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        ;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        ;
    }

    @Override
    public void mouseExited(MouseEvent e) {
        ;
    }
    
    public void increment(){
        setCount((getCount() + 1) % 10);
        setIcon();
        repaint();
    }
    
    public void decrement(){
        setCount((getCount() + 9) % 10);
        setIcon();
        repaint();
    }
    
        public void setIcon(){
        switch( getCount()){
            case(0):
                icon = new ImageIcon("C:\\Users\\Jarek\\Documents\\NetBeansProjects\\Sudoku\\numbers\\random.png");
                break;
            case(1):
                icon = new ImageIcon("C:\\Users\\Jarek\\Documents\\NetBeansProjects\\Sudoku\\numbers\\one.png");
                break;
            case(2):
                icon = new ImageIcon("C:\\Users\\Jarek\\Documents\\NetBeansProjects\\Sudoku\\numbers\\two.png");
                break;
            case(3):
                icon = new ImageIcon("C:\\Users\\Jarek\\Documents\\NetBeansProjects\\Sudoku\\numbers\\three.png");
                break;
            case(4):
                icon = new ImageIcon("C:\\Users\\Jarek\\Documents\\NetBeansProjects\\Sudoku\\numbers\\four.png");
                break;
            case(5):
                icon = new ImageIcon("C:\\Users\\Jarek\\Documents\\NetBeansProjects\\Sudoku\\numbers\\five.png");
                break;
            case(6):
                icon = new ImageIcon("C:\\Users\\Jarek\\Documents\\NetBeansProjects\\Sudoku\\numbers\\six.png");
                break;
            case(7):
                icon = new ImageIcon("C:\\Users\\Jarek\\Documents\\NetBeansProjects\\Sudoku\\numbers\\seven.png");
                break;
            case(8):
                icon = new ImageIcon("C:\\Users\\Jarek\\Documents\\NetBeansProjects\\Sudoku\\numbers\\eight.png");
                break;
            case(9):
                icon = new ImageIcon("C:\\Users\\Jarek\\Documents\\NetBeansProjects\\Sudoku\\numbers\\nine.png");
                break;
        }
        setIcon(icon);
    }

    /**
     * @return the count
     */
    public int getCount() {
        return count;
    }

    /**
     * @param count the count to set
     */
    public void setCount(int count) {
        this.count = count;
        setIcon();
        repaint();
    }
}
