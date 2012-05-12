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
        int count = 0, index;
        Card cardFound;

        do {

            System.out.println(onirim.getHand().toString());

            System.out.println("Choose a card to play: ");

            aux = sc.nextLine();

            // Card its in hand?
            index = -1;
            for (int i = 0; i < onirim.getHand().show().size(); i++) {
                if (onirim.getHand().show().get(i).getCommand().equalsIgnoreCase(aux)) {
                    index = i;
                    break;
                }
            }
            if (index == -1) {
                System.out.println("Command don't exist or the card you want, isn't on hand");
            } else {
                //Card in the hand
                if (onirim.getLabyrinthStack().showLastCard() == null) {
                    // the Labyrinth stack is empty
                    onirim.getLabyrinthStack().addCard(onirim.getHand().discard(index));
                    valid = true;
                } else {   //the Labyrinth stack isn't empty
                    if (((Labyrinth) onirim.getLabyrinthStack().showLastCard()).getSymbol().equals(((Labyrinth) onirim.getHand().show().get(index)).getSymbol())) {
                        //The Last card played have the same symbol that card you wanna play
                        System.out.println("You Can´t Play that card because of the symbol");
                    } else {
                        onirim.getLabyrinthStack().addCard(onirim.getHand().discard(index));
                        valid = true;
                    }
                }
            }

            // verify sequence of last 3 cards
            if (onirim.getLabyrinthStack().showSequence() != null) {
                //there are more than 2 card in the labyrinth stack
                for (int j = 1; j < onirim.getLabyrinthStack().showSequence().size(); j++) {
                    if (((Labyrinth) onirim.getLabyrinthStack().showSequence().get(j)).getColor().
                            equals(((Labyrinth) onirim.getLabyrinthStack().showSequence().get(0)).getColor())) {
                        //the card color is equal than the first of the sequence
                        count++;
                    }
                }
                //Case 3 card same color get the door corresponding
                if (count == 2) {
                    cardFound = onirim.getDeck().searchCard(new Door(this.DoorCommand(((Labyrinth) onirim.getLabyrinthStack().showSequence().get(0)).getColor()), ((Labyrinth) onirim.getLabyrinthStack().showSequence().get(0)).getColor()));
                    if (cardFound != null) {
                        onirim.getDoorStack().addCard(cardFound);
                        onirim.getDeck().shuffle();
                    }

                }

            }
            //Case 8 door end of the game
                //if(onirim.getDoorStack().VerifyAllDoorsCollected())
                //end of the game   

        } while (valid == false);

        //Buy Fase
        onirim.setState(onirim.getBuyState());

    }

    @Override
    public void discard() {

        int index;
        boolean valid = false;

        do {
            System.out.println(onirim.getHand().toString());

            System.out.println("Choose a card to discard: ");

            aux = sc.nextLine();

             // Card its in hand?
            index = -1;
            for (int i = 0; i < onirim.getHand().show().size(); i++) {
                if (onirim.getHand().show().get(i).getCommand().equalsIgnoreCase(aux)) {
                    index = i;
                    break;
                }
            }
            
            if (index == -1) {
                System.out.println("Command don't exist or the card you want, isn't on hand");
           
            }else{
                if (((Labyrinth) onirim.getHand().show().get(index)).getSymbol().equals("KEY")) {
                    //Make Prophecy
                    onirim.getDiscardStack().addCard(onirim.getHand().discard(index));
                    this.Prophecy();
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

        int index, k = 0;
        boolean valid = false;
        List<Card> cards = new ArrayList<Card>();
        List<Card> cardsToDeck = new ArrayList<Card>();
        cards.addAll(onirim.getDeck().showTopCards());

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

                // reorganize the other 4
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
    }

    public String DoorCommand(String color) {

        if (color.equalsIgnoreCase("RED")) {
            return "DR";
        }
        if (color.equalsIgnoreCase("BLUE")) {
            return "DB";
        }
        if (color.equalsIgnoreCase("GREEN")) {
            return "DG";
        } else {
            return "DC";
        }

    }
}
