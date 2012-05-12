/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package onirim.state;


import onirim.Onirim;
import onirim.entity.Card;

/**
 *
 * @author Bino
 */
public class BuyState implements State {
    
    private Onirim onirim;

    public BuyState(Onirim onirim) {
        this.onirim = onirim;
    }
    
    @Override
    public void buyHand() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void play() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void discard() {
        throw new UnsupportedOperationException("Not supported yet.");
   
    }

    @Override
    public void draw() {
        
        Card drawCard;
        
        do{
        drawCard=onirim.getDeck().drawCard();
        
        if(drawCard.getType().equals("LABYRINTH"))
            ;
        
        }while(onirim.getHand().show().size()<5);
        
        
    }
}
