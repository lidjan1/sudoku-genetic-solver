/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author Jarek
 */
class Specimen {
    int [] gridNumbers = new int[81];
    
    public Specimen( int [] grid ){
        Random r = new Random();
        for( int i=0; i<gridNumbers.length;i++){
            if( grid[i] == 0)
                gridNumbers[i] = r.nextInt(9)+1;
            else
                gridNumbers[i]=grid[i];
        }
    }
    
    public int goalFunction(){
        int value = 0;
        DigitMap [] rows = new DigitMap[9];
        DigitMap [] cols = new DigitMap[9];
        DigitMap [] miniSquares = new DigitMap[9];
        
        for(int i=0; i<9;i++){
            rows[i] = new DigitMap();
            cols[i] = new DigitMap();
            miniSquares[i] = new DigitMap();
        }
        
        for(int i=0; i<9;i++){
            int cellNumber;
            for(int j=0;j<9;j++){
                //rows
                cellNumber = i*9+j;
                if(!rows[i].containsKey(gridNumbers[cellNumber])){
                    rows[i].put(gridNumbers[cellNumber], 1);
                } else {
                    rows[i].put(gridNumbers[cellNumber], (int)rows[i].get(gridNumbers[cellNumber])+1);
                }
                //cols
                cellNumber = j*9+i;
                if(!cols[i].containsKey(gridNumbers[cellNumber])){
                    cols[i].put(gridNumbers[cellNumber], 1);
                } else {
                    cols[i].put(gridNumbers[cellNumber], (int)cols[i].get(gridNumbers[cellNumber])+1);
                }                
            }
            //miniSquares
            cellNumber = (i/3)*27+ 3*(i%3);
            for(int j=0;j<3;j++){
                for(int k=0;k<3;k++){
                    if(!miniSquares[i].containsKey(gridNumbers[cellNumber])){
                        miniSquares[i].put(gridNumbers[cellNumber], 1);
                    } else {
                        miniSquares[i].put(gridNumbers[cellNumber], (int)miniSquares[i].get(gridNumbers[cellNumber])+1);
                    } 
                    cellNumber++;                   
                }
                cellNumber+=6;
            }
        }
        /*
                //Wypisz liczby znalezione w rzędach
                for (int k = 0; k < 9; k++) {
                    System.out.println("rząd "+(k+1));
                    for(int j=1;j<10;j++)
                        System.out.print(j+":   "+rows[k].get(j)+"   ");
                    System.out.println();
                }
                //Wypisz liczby znalezione w kolumnach
                for (int k = 0; k < 9; k++) {
                    System.out.println("kolumna "+(k+1));
                    for(int j=1;j<10;j++)
                        System.out.print(j+":   "+cols[k].get(j)+"   ");
                    System.out.println();
                }
                //Wypisz liczby znalezione w kwadratach 3x3
                for (int k = 0; k < 9; k++) {
                    System.out.println("mini kwadrat "+(k+1));
                    for(int j=1;j<10;j++)
                        System.out.print(j+":   "+miniSquares[k].get(j)+"   ");
                    System.out.println();
                }    
        */        
        for( DigitMap dm : rows){value += dm.getRepeatsNumber();}
        for( DigitMap dm : cols){value += dm.getRepeatsNumber();}
        for( DigitMap dm : miniSquares){value += dm.getRepeatsNumber();}
        return value;
    }
}
