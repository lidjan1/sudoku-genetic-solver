/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.util.HashMap;

/**
 *
 * @author Jarek
 */
public class DigitMap extends HashMap<Object, Object> {
    public int getRepeatsNumber(){
        int toReturn = 0;
        for( int i=1; i<10;i++){
            try{
                toReturn += Math.abs((int) get(i)-1);
            } catch (NullPointerException e){
                ;
            }
            
        }
        return toReturn;
    }
    
}
