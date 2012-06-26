/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package onirim.state;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import onirim.Onirim;
import onirim.OnirimExpansion;

import onirim.entity.Card;
import onirim.entity.Labyrinth;
import onirim.entity.Tower;

/**
 *
 * @author Bino
 */
public class NigthmareStateTop implements State {

    private Onirim onirim;
    Scanner sc = new Scanner(System.in);
    private String aux;

    public NigthmareStateTop(Onirim onirim) {
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

         List<Card> cards = new ArrayList<Card>();

        cards.addAll(onirim.getDeck().showTopCards());

        if (cards != null) {
            for (int i = 0; i < cards.size(); i++) {
                System.out.println(cards.get(i));
            }

            while (cards.size() > 0) {
                if (cards.get(0).getType().equalsIgnoreCase("DOOR") || cards.get(0).getType().equalsIgnoreCase("NIGHTMARE")) {
                    onirim.getLimbo().addCard(cards.remove(0));
                } else {
                    onirim.getDiscardStack().addCard(cards.remove(0));
                }
            }
        }
    }
}
   