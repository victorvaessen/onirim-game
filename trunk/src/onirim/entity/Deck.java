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

    private List<Entity> cards;
    
    public Deck() {
        cards = new ArrayList<Entity>();
        
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
     

    public void shuffle() {
        Collections.shuffle(cards);
    }
    
    public Entity drawCard() {
        return cards.remove(0);
    }
    
    
}

