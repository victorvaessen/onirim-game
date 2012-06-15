/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package onirim.entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marco António
 */
public class DiscardStack {
     
     List<Card> cards;

    public DiscardStack() {
        cards = new ArrayList<Card>();
    }
    
    public void addCard(Card card) {
        cards.add(card);
    }
    
    public void addCards(List<Card> discardCards)
    {
        cards.addAll(discardCards);
    }
     
    public List<Card> showAll() {
        return cards;
    }

    public Card ShowLastCard(){
        if(cards.size()>0)
            return cards.get(cards.size()-1);
        else
            return null;
    }
    
    public Card getLastCard(){
         if(cards.size()>0)
            return cards.remove(cards.size()-1);
        else
            return null;
    }
    
    @Override
    public String toString() {
            String toString = "DISCARDSTACK:\n";
        
        for (int i = 0; i < cards.size(); i++) {
            toString += "\n" + cards.get(i).toString();
        }
        
        return toString;
       
    }
    
}
