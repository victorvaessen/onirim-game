/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package onirim.state;

import java.util.List;
import onirim.Onirim;
import onirim.entity.Card;
import onirim.entity.Door;
import onirim.entity.Labyrinth;

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
        
        System.out.println();

    }

    @Override
    public void discard() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void draw() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
