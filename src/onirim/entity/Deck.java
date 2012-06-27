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
        CardsFactory factory = new CardsFactory();
        
        //adding 8 doors
        for (int i = 0; i < 2; i++) {
            cards.add(factory.criaCard("DOOR","DR", "RED"));
            cards.add(factory.criaCard("DOOR","DB", "BLUE"));
            cards.add(factory.criaCard("DOOR","DG", "GREEN"));
            cards.add(factory.criaCard("DOOR","DC", "BROWN"));
        }
        
        //adding 9 labyrints red sun
        for (int i = 0; i < 9; i++) {
            cards.add(factory.criaCard("LABYRINTH","LSR", "RED","SUN"));
        }
        
        //adding 8 labyrints blue sun
        for (int i = 0; i < 8; i++) {
            cards.add(factory.criaCard("LABYRINTH","LSB", "BLUE","SUN"));
        }
        
        //adding 7 labyrints green sun
        for (int i = 0; i < 7; i++) {
            cards.add(factory.criaCard("LABYRINTH","LSG", "GREEN","SUN"));
        }
        
        //adding 6 labyrints brown sun
        for (int i = 0; i < 6; i++) {
           cards.add(factory.criaCard("LABYRINTH","LSC", "BROWN","SUN"));
        }
        
        //adding 12 labyrints keys
        for (int i = 0; i < 3; i++) {
            cards.add(factory.criaCard("LABYRINTH","LKR", "RED","KEY"));
            cards.add(factory.criaCard("LABYRINTH","LKB", "BLUE","KEY"));
            cards.add(factory.criaCard("LABYRINTH","LKG", "GREEN","KEY"));
            cards.add(factory.criaCard("LABYRINTH","LKC", "BROWN","KEY"));
        }
        
        //adding 16 labyrints moon
        for (int i = 0; i < 4; i++) {
            cards.add(factory.criaCard("LABYRINTH","LMR", "RED","MOON"));
            cards.add(factory.criaCard("LABYRINTH","LMB", "BLUE","MOON"));
            cards.add(factory.criaCard("LABYRINTH","LMG", "GREEN","MOON"));
            cards.add(factory.criaCard("LABYRINTH","LMC", "BROWN","MOON"));
        }
        
        //adding 10 nightmares
        for (int i = 0; i < 10; i++) {
            cards.add(factory.criaCard("NIGHTMARE", "N"));
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
         int size=cards.size();
        for (int i = 0; i < 5 && i < size; i++) {
            topCards.add(cards.remove(0));
        }
        
        return topCards;
    }
    
    public List<Card> showTopCards(int number) {
        List<Card> topCards = new ArrayList<Card>();
         int size=cards.size();
        for (int i = 0; i < number && i < size; i++) {
            topCards.add(cards.remove(0));
        }
        
        return topCards;
    }
    
    
    //buy 5 cards
    public List<Card> buyCards() {
        List<Card> cardsPurchased = new ArrayList<Card>();
        
        int size=cards.size();
        for (int i = 0; i < 5 && i < size; i++) {
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
            if (cards.get(i).getCommand().equalsIgnoreCase(card.getCommand())) {
                cardFound = cards.remove(i);
                break;
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
        int size=cards.size();
        for(int i=0;i<size;i++){
            aux.add(cards.remove(0));
        }
        
        cards.addAll(topCards);
        cards.addAll(aux);
    }
    
    public int deckSize(){
        return cards.size();
    }

    //Mostrar as 7 cartas do baralho
    public List<Card> ShowExtraCards()
    {
        List<Card> aux = new ArrayList<Card>();
        
        for (int i = 0; i < 7 && i<cards.size(); i++) {
            aux.add(cards.get(i));
        }
        
        return  aux;
    }
    
    //adicionar uma carta ao topo do baralho
    public void AddBeginCard(Card card)
    {
        List<Card> aux = new ArrayList<Card>();
        int size=cards.size();
        for(int i=0;i<size;i++){
            aux.add(cards.remove(0));
        }
        
        cards.add(card);
        cards.addAll(aux);
    }
    
    @Override
    public String toString() {
            String toString = "DECK:\n";
        
        for (int i = 0; i < cards.size(); i++) {
            toString += "\n" + cards.get(i).toString();
        }
        
        return toString;
       
    }
    
    public void addExpansionCards(){
        
        CardsFactory factory = new CardsFactory();
        
        // add 3 red towers
        cards.add(factory.criaCard("TOWER","TTMR","RED","MOON","SUNMOON",3));
        cards.add(factory.criaCard("TOWER","TSMR","RED","MOON","SUN",4));
        cards.add(factory.criaCard("TOWER","TNMR","RED","MOON","NONE",5));
        
        
        //add 3 blue towers
        cards.add(factory.criaCard("TOWER","TMTB","BLUE","SUNMOON","MOON",3));
        cards.add(factory.criaCard("TOWER","TMMB","BLUE","MOON","MOON",4));
        cards.add(factory.criaCard("TOWER","TMNB","BLUE","NONE","MOON",5)); 
        
        //add 3 green towers
        cards.add(factory.criaCard("TOWER","TSTG","GREEN","SUNMOON","SUN",3));
        cards.add(factory.criaCard("TOWER","TSSG","GREEN","SUN","SUN",4));
        cards.add(factory.criaCard("TOWER","TSNG","GREEN","NONE","SUN",5));
        
        //add 3 brown towers
        cards.add(factory.criaCard("TOWER","TTSC","BROWN","SUN","SUNMOON",3));
        cards.add(factory.criaCard("TOWER","TMSC","BROWN","SUN","MOON",4));
        cards.add(factory.criaCard("TOWER","TNSC","BROWN","SUN","NONE",5));            
    }
}

