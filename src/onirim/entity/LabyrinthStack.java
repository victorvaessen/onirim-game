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
public class LabyrinthStack {

    List<Card> cards;

    public LabyrinthStack() {
        cards = new ArrayList<Card>();
    }
    
    public void addCard(Card card) {
        cards.add(card);
    }
    
    public Card showLastCard() {
        if(cards.size()>0)
            return cards.get(cards.size() - 1);
        else return null;
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

    @Override
    public String toString() {
        String toString="\n LABYRINTH STACK \n";
        
        for (int i = 0; i < cards.size(); i++) {
            toString += "\n[" + (i + 1) + "] " + cards.get(i).toString();
        }
        return toString;
    }
    
    
}
