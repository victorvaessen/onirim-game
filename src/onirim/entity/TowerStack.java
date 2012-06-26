/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package onirim.entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bino
 */
public class TowerStack {

    List<Card> cards;
    List<Tower> sequenceCards;
    boolean block;

    public TowerStack() {
        cards = new ArrayList<Card>();
        sequenceCards = new ArrayList<Tower>();
        block = false;
    }

    public boolean isBlock() {
        return block;
    }

    
    public Card showRightCard() {
        if (cards.size() > 0) {
            return cards.get(cards.size() - 1);
        } else {
            return null;
        }
    }

    public Card showLeftCard() {
        if (cards.size() > 0) {
            return cards.get(0);
        } else {
            return null;
        }
    }

    public List<Card> ShowAll() {
        return cards;
    }

    public boolean addCardRight(Card card) {
        cards.add(card);
        return this.verifySequence();
    }

    public boolean addCardLeft(Card card) {
        cards.add(0, card);
        return this.verifySequence();
    }

    public boolean verifySequence() {
        if (cards.size() >= 4) {
            for (int i = 0; i < cards.size() - 3; i++) {
                sequenceCards.clear();
                sequenceCards.add((Tower) cards.get(i));
                for (int j = i + 1; j < i + 4; j++) {
                    if (!((Tower) cards.get(j)).getColor().equalsIgnoreCase(sequenceCards.get(i).getColor())) {
                        sequenceCards.add((Tower) cards.get(j));
                    }
                }
                if (sequenceCards.size() == 4) {
                    block = true;
                    return true;
                }
            }
        }
        return false;
    }

    public Card removeCard(int index) {
        Card auxCard;
        auxCard=cards.remove(index);
        this.verifySequence();
        return auxCard;
    }
    
    public Card showLeftCard(int index){
        if(index<cards.size() && index>0)
            return cards.get(index-1);
        else
            return null;
    }
    
    public Card showRightCard(int index){
        if(index<cards.size()-1)
            return cards.get(index+1);
        else
            return null;
    }

    @Override
    public String toString() {
        String toString="TOWER STACK:\n";
        
        for (int i = 0; i < cards.size(); i++) {
            toString += "\n" + cards.get(i).toString();
        }
        return toString;
    }
    
    
}



