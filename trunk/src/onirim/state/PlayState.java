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
import onirim.entity.Door;
import onirim.entity.Labyrinth;

/**
 *
 * @author Marco António
 */
public class PlayState implements State {

    private Onirim onirim;
    Scanner sc = new Scanner(System.in);
    private String aux;

    public PlayState(Onirim onirim) {
        this.onirim = onirim;
    }

    @Override
    public void buyHand() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void play() {

        boolean valid = false;
        int i, count = 0, index;
        Card cardFound;

        do {

            System.out.println(onirim.getHand().toString());

            System.out.println("Choose a card to play: ");

            aux = sc.nextLine();

            //Correct Command
            for (i = 0; i < onirim.getCardCorresponding().getListCard().size(); i++) {
                if (aux.compareTo(onirim.getCardCorresponding().getListCard().get(i).getCommand()) == 0) {
                    break;
                }
            }
            if (i < onirim.getCardCorresponding().getListCard().size() && onirim.getCardCorresponding().getListCard().get(i).getType().equals("LABYRINTH")) {
                //Card its in the Hand?
                index = -1;
                for (int j = 0; j < onirim.getHand().show().size(); j++) {
                    if (((Labyrinth) onirim.getHand().show().get(j)).getSymbol().equals(onirim.getCardCorresponding().getListCard().get(i).getSymbol())
                            && ((Labyrinth) onirim.getHand().show().get(j)).getColor().equals(onirim.getCardCorresponding().getListCard().get(i).getColor())) {
                        index = j;
                    }
                }


                if (index > -1) {
                    if (onirim.getLabyrinthStack().showLastCard() == null) {
                        onirim.getLabyrinthStack().addCard(onirim.getHand().discard(index));
                        valid = true;
                    } else {
                        //Symbol is equal to the last of the labyrinth stack
                        if (((Labyrinth) onirim.getLabyrinthStack().showLastCard()).getSymbol().equals(((Labyrinth) onirim.getHand().show().get(index)).getSymbol())) {
                            System.out.println("Não pode jogar tem o mesmo simbolo do anterior");
                        } else {
                            onirim.getLabyrinthStack().addCard(onirim.getHand().discard(index));
                            valid = true;
                        }

                        if (onirim.getLabyrinthStack().showSequence() != null) {
                            // verify sequence of last 3 cards
                            for (int j = 1; j < onirim.getLabyrinthStack().showSequence().size(); j++) {
                                if (((Labyrinth) onirim.getLabyrinthStack().showSequence().get(j)).getColor().
                                        equals(((Labyrinth) onirim.getLabyrinthStack().showSequence().get(0)).getColor())) {
                                    count++;
                                }
                            }
                            //Case 3 card same color get the door corresponding
                            if (count == 2) {
                                cardFound = onirim.getDeck().searchCard(new Door(((Labyrinth) onirim.getLabyrinthStack().showSequence().get(0)).getColor()));
                                if (cardFound != null) {
                                    onirim.getDoorStack().addCard(cardFound);
                                    onirim.getDeck().shuffle();
                                }
                            }
                        }
                    }


                    //Case 8 door end of the game
                    //if(onirim.getDoorStack().VerifyAllDoorsCollected())
                    //end of the game   
                }
            }
        } while (valid == false);

        //Buy Fase
        onirim.setState(onirim.getBuyState());

    }

    @Override
    public void discard() {

        int i, index;
        boolean valid = false;

        do {
            System.out.println(onirim.getHand().toString());

            System.out.println("Choose a card to discard: ");

            aux = sc.nextLine();

            //Correct Command
            for (i = 0; i < onirim.getCardCorresponding().getListCard().size(); i++) {
                if (aux.compareTo(onirim.getCardCorresponding().getListCard().get(i).getCommand()) == 0) {
                    break;
                }
            }

            if (i < onirim.getCardCorresponding().getListCard().size() && onirim.getCardCorresponding().getListCard().get(i).getType().equals("LABYRINTH")) {
                //Card its in the Hand?
                index = -1;
                for (int j = 0; j < onirim.getHand().show().size(); j++) {
                    if (((Labyrinth) onirim.getHand().show().get(j)).getSymbol().equals(onirim.getCardCorresponding().getListCard().get(i).getSymbol())
                            && ((Labyrinth) onirim.getHand().show().get(j)).getColor().equals(onirim.getCardCorresponding().getListCard().get(i).getColor())) {
                        index = j;
                    }
                }

                if (((Labyrinth) onirim.getHand().show().get(index)).getSymbol().equals("KEY")) {
                    //Make Prophecy
                    onirim.getDiscardStack().addCard(onirim.getHand().discard(index));
                   // this.Prophecy();
                    valid = true;

                } else {
                    valid = true;
                }
            }
        } while (valid == false);

        //Buy Fase
        onirim.setState(onirim.getBuyState());


    }

    @Override
    public void draw() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void Prophecy() {

        int i, index = -1, k = 0;
        boolean valid = false;
        List<Card> cards = new ArrayList<Card>();
        List<Card> cardsToDeck = new ArrayList<Card>();
        cards.addAll(onirim.getDeck().showTopCards());

        do {
            System.out.println("PROPHECY");
            System.out.println(onirim.getDeck().showTopCards());

            System.out.println("Choose a card to discard: ");

            aux = sc.nextLine();

            for (i = 0; i < onirim.getCardCorresponding().getListCard().size(); i++) {
                if (aux.compareTo(onirim.getCardCorresponding().getListCard().get(i).getCommand()) == 0) {
                    break;
                }
            }

            if (i < onirim.getCardCorresponding().getListCard().size()) {
                //Card its in the the list?
                index = -1;
                for (int j = 0; j < cards.size(); j++) {
                    if (cards.get(j).getType().equals("LABYRINTH")) {
                        if (((Labyrinth)cards.get(j)).getSymbol().equals(onirim.getCardCorresponding().getListCard().get(i).getSymbol())
                        && ((Labyrinth)cards.get(j)).getColor().equals(onirim.getCardCorresponding().getListCard().get(i).getColor())) {
                            //discards a card 
                            onirim.getDiscardStack().addCard(cards.remove(j));
                            valid = true;
                            break;
                        }
                    }
                    if(cards.get(j).getType().equals("DOOR")) {
                        if (((Door)cards.get(j)).getColor().equals(onirim.getCardCorresponding().getListCard().get(i).getColor())) {
                            //discards a card 
                            onirim.getDiscardStack().addCard(cards.remove(j));
                            valid = true;
                            break;
                        }
                    }
                    if (cards.get(j).getType().equals("NIGTHMARE")) {
                        //discards a card 
                        onirim.getDiscardStack().addCard(cards.remove(j));
                        valid = true;
                        break;
                    }
                }
            }
        } while (valid == false);
        
        while(cards.size() > 0) {

            k++;
            System.out.println(cards.toString());

            System.out.println("Choose a card to put in " + k + " position on deck");

            aux = sc.nextLine();

            for (i = 0; i < onirim.getCardCorresponding().getListCard().size(); i++) {
                if (aux.compareTo(onirim.getCardCorresponding().getListCard().get(i).getCommand()) == 0) {
                    break;
                }
            }

            if (i < onirim.getCardCorresponding().getListCard().size()) {

                index = -1;
                for (int j = 0; j < cards.size(); j++) {
                    if (cards.get(j).getType().equals("LABYRINTH")) {
                        if (((Labyrinth) cards.get(j)).getSymbol().equals(onirim.getCardCorresponding().getListCard().get(i).getSymbol())
                        && ((Labyrinth) cards.get(j)).getColor().equals(onirim.getCardCorresponding().getListCard().get(i).getColor())) {
                            cardsToDeck.add(cards.remove(j));
                            break;

                        }
                    }
                    if (cards.get(j).getType().equals("DOOR")) {
                        if (((Door) cards.get(j)).getColor().equals(onirim.getCardCorresponding().getListCard().get(i).getColor())) {
                            cardsToDeck.add(cards.remove(j));
                            break;
                        }
                    }
                    if (cards.get(j).getType().equals("NIGTHMARE")) {
                        cardsToDeck.add(cards.remove(j));
                        break;
                    }
                }
            }
        }

        onirim.getDeck().addBegin(cardsToDeck);
    }
}

