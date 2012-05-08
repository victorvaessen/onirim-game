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
            cards.add(new Door("RED"));
            cards.add(new Door("BLUE"));
            cards.add(new Door("GREEN"));
            cards.add(new Door("BROWN"));
        }
        
        //adding 9 labyrints red sun
        for (int i = 0; i < 9; i++) {
            cards.add(new Labyrinth("SUN", "RED"));
        }
        
        //adding 8 labyrints blue sun
        for (int i = 0; i < 8; i++) {
            cards.add(new Labyrinth("SUN", "BLUE"));
        }
        
        //adding 7 labyrints green sun
        for (int i = 0; i < 7; i++) {
            cards.add(new Labyrinth("SUN", "GREEN"));
        }
        
        //adding 6 labyrints brown sun
        for (int i = 0; i < 6; i++) {
            cards.add(new Labyrinth("SUN", "BROWN"));
        }
        
        //adding 12 labyrints keys
        for (int i = 0; i < 3; i++) {
            cards.add(new Labyrinth("KEY", "RED"));
            cards.add(new Labyrinth("KEY", "BLUE"));
            cards.add(new Labyrinth("KEY", "GREEN"));
            cards.add(new Labyrinth("KEY", "BROWN"));
        }
        
        //adding 4 labyrints moon
        for (int i = 0; i < 4; i++) {
            cards.add(new Labyrinth("MOON", "RED"));
            cards.add(new Labyrinth("MOON", "BLUE"));
            cards.add(new Labyrinth("MOON", "GREEN"));
            cards.add(new Labyrinth("MOON", "BROWN"));
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
        return cards.remove(0);
    }
    
    //show top 5 cards
    public List<Card> showTopCards() {
        List<Card> topCards = new ArrayList<Card>();
        
        for (int i = 0; i < 5; i++) {
            topCards.add(cards.remove(0));
        }
        
        return topCards;
    }
    
    //buy 5 cards
    public List<Card> buyCards() {
        List<Card> cardsPurchased = new ArrayList<Card>();
        
        for (int i = 0; i < 5; i++) {
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
}

