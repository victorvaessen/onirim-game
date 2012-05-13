/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package onirim.state;

import onirim.Onirim;
import onirim.entity.Limbo;

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

        onirim.getDeck().shuffle();
        onirim.getHand().init(onirim.getDeck().buyCards());

        boolean badHand;

        do {
            badHand = false;
            for (int i = 0; i < onirim.getHand().show().size(); i++) {
                if (onirim.getHand().show().get(i).getType().equals("DOOR")
                        || onirim.getHand().show().get(i).getType().equals("NIGHTMARE")) {
                    onirim.getLimbo().addCard(onirim.getHand().discard(i));

                    onirim.getHand().buyCard(onirim.getDeck().drawCard());
                    badHand = true;
                }
            }
        } while (badHand);
        
        onirim.getDeck().addLimboCards(onirim.getLimbo().clear());
        onirim.getDeck().shuffle();
        
        onirim.setState(onirim.getPlayState());
        
    }

    @Override
    public void play() {
    }

    @Override
    public void discard() {
    }

    @Override
    public void draw() {
    }

    @Override
    public void shuffle() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
