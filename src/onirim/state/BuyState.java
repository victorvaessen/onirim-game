/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package onirim.state;

import onirim.Onirim;
import onirim.entity.Card;

/**
 *
 * @author Bino
 */
public class BuyState implements State {

    private Onirim onirim;

    public BuyState(Onirim onirim) {
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

        Card drawCard;
        boolean confirm = false;
        if (onirim.getDeck().deckSize() > 0) {
            do {
                drawCard = onirim.getDeck().drawCard();
                System.out.println("\nCard Draw: " + drawCard.toString() + "\n");

                if (drawCard.getType().equals("DOOR")) {
                    onirim.getLimbo().addCard(drawCard);
                }
                if (drawCard.getType().equals("NIGHTMARE")) {
                    this.nightmarebase();
                }
                if(drawCard.getType().equals("LABYRINTH"))
                {
                    onirim.getHand().buyCard(drawCard);
                }
            } while (onirim.getHand().show().size() < 5 && onirim.getDeck().deckSize() > 0);
        }
        if (onirim.getDeck().deckSize() == 0) {
            onirim.setState(onirim.getFinalLostState());
        } else {
            onirim.setState(onirim.getShuffleState());
        }


    }

    @Override
    public void shuffle() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void nightmarebase() {
        onirim.getDiscardStack().addCards(onirim.getHand().discardAll());

        if (onirim.getDeck().deckSize() > 4) {
            onirim.getHand().init(onirim.getDeck().buyCards());

            boolean badHand;

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
                    }
                }
            } while (badHand);
        }
    }
}
