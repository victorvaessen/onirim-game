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
public class StartState implements State {

    private Onirim onirim;
    
    public StartState(Onirim onirim) {
        this.onirim = onirim;
    }

    @Override
    public void buyHand() {
        
    }

    @Override
    public void play() {
        throw new UnsupportedOperationException("Not supported yet.");
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
