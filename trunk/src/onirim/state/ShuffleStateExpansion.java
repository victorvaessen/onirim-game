/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package onirim.state;

import onirim.OnirimExpansion;



/**
 *
 * @author Bino
 */
public class ShuffleStateExpansion implements State {

    private OnirimExpansion onirim;

    public ShuffleStateExpansion(OnirimExpansion onirim) {
        this.onirim = onirim;
    }

    @Override
    public void buyHand() {
        throw new UnsupportedOperationException("Not supported yet.");
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

    @Override
    public void shuffle() {
        onirim.getDeck().addLimboCards(onirim.getLimbo().clear());

        onirim.getDeck().shuffle();
        onirim.setState(onirim.getPlayState());
    }

    @Override
    public void event() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
