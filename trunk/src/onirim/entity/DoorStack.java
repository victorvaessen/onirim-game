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
public class DoorStack {
    List<Card> cards;

    public DoorStack() {
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

    @Override
    public String toString() {
            String toString = "DOORSTACK:\n";
        
        for (int i = 0; i < cards.size(); i++) {
            toString += "\n[" + i + 1 +"]" + cards.get(i).toString();
        }
        
        return toString;
       
    }
}
