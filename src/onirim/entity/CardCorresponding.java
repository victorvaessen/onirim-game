/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package onirim.entity;

import java.util.ArrayList;

/**
 *
 * @author Bino
 */
public class CardCorresponding {

    private ArrayList<CardCommand> listCard = new ArrayList<CardCommand>();
    
    public CardCorresponding() {
        
        //Labyrinth card red
        listCard.add(new CardCommand("LRS","LABYRINTH","RED","SUN"));
        listCard.add(new CardCommand("LRM","LABYRINTH","RED","MOON"));
        listCard.add(new CardCommand("LRK","LABYRINTH","RED","KEY"));
        
        //Labyrinth card blue
        listCard.add(new CardCommand("LBS","LABYRINTH","BLUE","SUN"));
        listCard.add(new CardCommand("LBM","LABYRINTH","BLUE","MOON"));
        listCard.add(new CardCommand("LBK","LABYRINTH","BLUE","KEY"));
        
        //Labyrinth card green
        listCard.add(new CardCommand("LGS","LABYRINTH","GREEN","SUN"));
        listCard.add(new CardCommand("LGM","LABYRINTH","GREEN","MOON"));
        listCard.add(new CardCommand("LGK","LABYRINTH","GREEN","KEY"));
        
        //Labyrinth card brown
        listCard.add(new CardCommand("LCS","LABYRINTH","BROWN","SUN"));
        listCard.add(new CardCommand("LCM","LABYRINTH","BROWN","MOON"));
        listCard.add(new CardCommand("LCK","LABYRINTH","BROWN","KEY"));
        
        // DOORS COLORS
        listCard.add(new CardCommand("DR","DOOR","RED",null));
        listCard.add(new CardCommand("DB","DOOR","BLUE",null));
        listCard.add(new CardCommand("DG","DOOR","GREEN",null));
        listCard.add(new CardCommand("DC","DOOR","BROWN",null));
        
        // NIGHTMARE 
        listCard.add(new CardCommand("N","NIGHTMARE",null,null)); 
    }

    public ArrayList<CardCommand> getListCard() {
        return listCard;
    }
    
    
    
    
}
