/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package onirim.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Marco António
 */
public class Deck {

    private List<Card> cards;
    
    public Deck() {
        cards = new ArrayList<Card>();
        
        //adding 8 doors
        for (int i = 0; i < 2; i++) {
            cards.add(new Door("DR", "RED"));
            cards.add(new Door("DB", "BLUE"));
            cards.add(new Door("DG", "GREEN"));
            cards.add(new Door("DC", "BROWN"));
        }
        
        //adding 9 labyrints red sun
        for (int i = 0; i < 9; i++) {
            cards.add(new Labyrinth("SUN", "LSR", "RED"));
        }
        
        //adding 8 labyrints blue sun
        for (int i = 0; i < 8; i++) {
            cards.add(new Labyrinth("SUN", "LSB", "BLUE"));
        }
        
        //adding 7 labyrints green sun
        for (int i = 0; i < 7; i++) {
            cards.add(new Labyrinth("SUN", "LSG", "GREEN"));
        }
        
        //adding 6 labyrints brown sun
        for (int i = 0; i < 6; i++) {
            cards.add(new Labyrinth("SUN", "LSC", "BROWN"));
        }
        
        //adding 12 labyrints keys
        for (int i = 0; i < 3; i++) {
            cards.add(new Labyrinth("KEY", "LKR", "RED"));
            cards.add(new Labyrinth("KEY", "LKB", "BLUE"));
            cards.add(new Labyrinth("KEY", "LKG", "GREEN"));
            cards.add(new Labyrinth("KEY", "LKC", "BROWN"));
        }
        
        //adding 4 labyrints moon
        for (int i = 0; i < 4; i++) {
            cards.add(new Labyrinth("MOON", "LMR", "RED"));
            cards.add(new Labyrinth("MOON", "LMB", "BLUE"));
            cards.add(new Labyrinth("MOON", "LMG", "GREEN"));
            cards.add(new Labyrinth("MOON", "LMC", "BROWN"));
        }
        
        //adding 10 nightmares
        for (int i = 0; i < 10; i++) {
            cards.add(new NightMare());
        } 
    }
     
    //shuffling
    public void shuffle() {
        Collections.shuffle(cards);
    }
    
    //draw top card
    public Card drawCard() {
        if(cards.size()>0)
            return cards.remove(0);
        else
            return null;
    }
    
    //show top 5 cards
    public List<Card> showTopCards() {
        List<Card> topCards = new ArrayList<Card>();
        
        for (int i = 0; i < 5 && i < cards.size(); i++) {
            topCards.add(cards.remove(0));
        }
        
        return topCards;
    }
    
    //buy 5 cards
    public List<Card> buyCards() {
        List<Card> cardsPurchased = new ArrayList<Card>();
        
        for (int i = 0; i < 5 && i < cards.size(); i++) {
            cardsPurchased.add(cards.remove(0));
        }
        
        return cardsPurchased;
    }

    //add limbo cards to deck
    public void addLimboCards(List<Card> limboCards) {
        cards.addAll(limboCards);
        this.shuffle();
    }
    
    //search card on deck
    public Card searchCard(Card card) {
        Card cardFound = null;
        
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).equals(card)) {
                cardFound = cards.remove(i);
            }
        }
        
        if (cardFound == null) {
            return null;
        }
        
        this.shuffle();
        
        return cardFound;
    }
  
    public void addBegin(List<Card> topCards)
    {
        List<Card> aux = new ArrayList<Card>();
        
        for(int i=0;i<cards.size();i++){
            aux.add(cards.remove(0));
        }
        
        cards.addAll(topCards);
        cards.addAll(aux);
    }
}

