/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package onirim.state;

import onirim.Onirim;

/**
 *
 * @author Marco António
 */
public class PlayState implements State{

    private Onirim onirim;

    public PlayState(Onirim onirim) {
        this.onirim = onirim;
    }
    
    @Override
    public void buyHand() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void play() {
        
        System.out.println(onirim.getHand().toString());
        
        System.out.println("Choose a card to play: ");

    }

    @Override
    public void discard() {
        
        System.out.println(onirim.getHand().toString());
    }

    @Override
    public void draw() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
