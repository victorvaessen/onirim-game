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
public class Table {

    List<Card> cards;

    public Table() {
        cards = new ArrayList<Card>();
    }
    
    public void addCard(Card card) {
        cards.add(card);
    }
    
    public Card showLastCard() {
        return cards.get(cards.size() - 1);
    }
    
    public List<Card> showSequence() {
        
        List<Card> sequenceCards = null;
        
        if(cards.size() > 2) {
            sequenceCards = new ArrayList<Card>();
            for (int i = cards.size() - 3; i < cards.size(); i++) {
                sequenceCards.add(cards.get(i));
            }
        }
        
        return sequenceCards;
    }
    
    public List<Card> showAll() {
        return cards;
    }
}
