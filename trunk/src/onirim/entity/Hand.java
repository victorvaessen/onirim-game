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
public class Hand {

    private List<Card> cards;

    public Hand() {
        cards = new ArrayList<Card>();
    }
    
    //initial hand
    public void init(List<Card> cards){
        this.cards.addAll(cards);
    }
    
    //discard card
    public Card discard(int index) {
        return this.cards.remove(index);
    }
    
    //buy new card
    public void buyCard(Card card) {
        cards.add(card);
    }
    
    public List<Card> discardAll() {
        List<Card> cardsDiscarded = new ArrayList<Card>();
        
        for (int i = 0; i < cards.size(); i++) {
            cardsDiscarded.add(cards.remove(0));
        }
        
        return cardsDiscarded;
    }

    public List<Card> show() {
        return cards;
    }

    @Override
    public String toString() {
        String toString = "HAND:\n";
        
        for (int i = 0; i < cards.size(); i++) {
            toString += "\n[" + (i + 1) + "] " + cards.get(i).toString();
        }
        
        return toString;
    }
    
    
}
