/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package onirim.state;

import java.util.Scanner;
import onirim.Onirim;
import onirim.OnirimExpansion;


/**
 *
 * @author Bino
 */
public class NigthmareStateDiscardHand implements State {

    private Onirim onirim;
    Scanner sc = new Scanner(System.in);
    private String aux;

    public NigthmareStateDiscardHand(Onirim onirim) {
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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void event() {
        boolean badHand;
        onirim.getDiscardStack().addCards(onirim.getHand().discardAll());

        onirim.getHand().init(onirim.getDeck().buyCards());

        do {
            badHand = false;
            for (int i = 0; i < onirim.getHand().show().size(); i++) {
                if (onirim.getHand().show().get(i).getType().equals("DOOR")
                        || onirim.getHand().show().get(i).getType().equals("NIGHTMARE")) {
                    onirim.getLimbo().addCard(onirim.getHand().discard(i));
                    if (onirim.getDeck().deckSize() > 0) {
                        onirim.getHand().buyCard(onirim.getDeck().drawCard());
                        badHand = true;
                    }
                    else{
                        //não há mais cartas no deck
                        onirim.setState(onirim.getFinalState());
                        break;
                    }
                }
            }
        } while (badHand);

        onirim.getDeck().addLimboCards(onirim.getLimbo().clear());
        onirim.getDeck().shuffle();
    }
}
      