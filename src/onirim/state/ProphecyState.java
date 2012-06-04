/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package onirim.state;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import onirim.Onirim;
import onirim.entity.Card;

/**
 *
 * @author Bino
 */
public class ProphecyState implements State {

    private Onirim onirim;
    Scanner sc = new Scanner(System.in);
    private String aux;

    public ProphecyState(Onirim onirim) {
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

        int index, k = 0;
        boolean valid = false;
        List<Card> cards = new ArrayList<Card>();
        List<Card> cardsToDeck = new ArrayList<Card>();

        cards.addAll(onirim.getDeck().showTopCards());
        if (cards != null) {
            do {
                System.out.println("PROPHECY");

                for (int j = 0; j < cards.size(); j++) {
                    System.out.println(cards.get(j));
                }


                System.out.println("Choose a card to discard from the top of the deck: ");

                aux = sc.nextLine();

                // Card its in sequence?
                index = -1;
                for (int i = 0; i < cards.size(); i++) {
                    if (cards.get(i).getCommand().equalsIgnoreCase(aux)) {
                        index = i;
                        break;
                    }
                }
                if (index == -1) {
                    System.out.println("Command don't exist or the card you want, isn't on sequence");
                } else {
                    // Card is in the sequence
                    //discard the card
                    onirim.getDiscardStack().addCard(cards.remove(index));

                    // reorganize the other 4 cards
                    while (cards.size() > 0) {

                        k++;

                        for (int j = 0; j < cards.size(); j++) {
                            System.out.println(cards.get(j));
                        }

                        System.out.println("Choose a card to put in " + k + " position on deck");

                        aux = sc.nextLine();

                        index = -1;
                        for (int i = 0; i < cards.size(); i++) {
                            if (cards.get(i).getCommand().equalsIgnoreCase(aux)) {
                                index = i;
                                break;
                            }
                        }

                        if (index == -1) {
                            System.out.println("Command don't exist or the card you want, isn't on the sequence");
                            k--;
                        } else {
                            //Put the card on aux stack
                            cardsToDeck.add(cards.remove(index));
                        }

                    }
                    //put the cards on the top of the deck
                    onirim.getDeck().addBegin(cardsToDeck);
                    valid = true;
                }
            } while (valid == false);
              onirim.setState(onirim.getBuyState());
        }
        else
            onirim.setState(onirim.getFinalLostState());
    }
}
    
   
