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
    List<Labyrinth> sequenceCards;
    
    public LabyrinthStack() {
        cards = new ArrayList<Card>();
        sequenceCards = new ArrayList<Labyrinth>();
    }
    
    public boolean addCard(Labyrinth card) {
        
        if (sequenceCards.size()>0 && !sequenceCards.get(sequenceCards.size() -1).getColor().equalsIgnoreCase(card.getColor())) {
            sequenceCards.clear();
            sequenceCards.add(card);
        } else
            sequenceCards.add(card);
        
        if (sequenceCards.size() == 3) {
            sequenceCards.clear();
            cards.add(card);
            return true;
        }
        
        cards.add(card);
        return false;
    }
    
    public Card showLastCard() {
        if(cards.size()>0)
            return cards.get(cards.size() - 1);
        else return null;
    }
    
    public List<Card> showSequence() {
        
        List<Card> _sequenceCards = null;
        
        if(cards.size() > 2) {
            _sequenceCards = new ArrayList<Card>();
            for (int i = cards.size() - 3; i < cards.size(); i++) {
                _sequenceCards.add(cards.get(i));
            }
        }
        
        return _sequenceCards;
    }
    
    public List<Card> showAll() {
        return cards;
    }

    @Override
    public String toString() {
        String toString="LABYRINTH STACK:\n";
        
        for (int i = 0; i < cards.size(); i++) {
            toString += "\n" + cards.get(i).toString();
        }
        return toString;
    }
    
}
