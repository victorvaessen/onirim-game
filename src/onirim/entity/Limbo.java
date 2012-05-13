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
public class Limbo {

    private List<Card> cards;

    public Limbo() {
        cards = new ArrayList<Card>();
    }
    
    public void addCard(Card card) {
        cards.add(card);
    }
    
    public List<Card> clear() {
        List<Card> limboCards = new ArrayList<Card>();
        int size=cards.size();
        for (int i = 0; i < size; i++) {
            limboCards.add(cards.remove(0));
        }
        
        return limboCards;
    }
}
