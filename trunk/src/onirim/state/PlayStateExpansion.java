/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package onirim.state;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import onirim.OnirimExpansion;
import onirim.entity.Card;
import onirim.entity.Door;
import onirim.entity.Labyrinth;
import onirim.entity.Tower;


/**
 *
 * @author Marco António
 */
public class PlayStateExpansion implements State {

    private OnirimExpansion onirim;
    Scanner sc = new Scanner(System.in);
    private String aux;

    public PlayStateExpansion(OnirimExpansion onirim) {
        this.onirim = onirim;
    }

    @Override
    public void buyHand() {
    }

    @Override
    public void play() {

        boolean valid = false;
        int count = 0, index;
        Card cardFound;

        do {

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
            } else {//Card in the hand
                if(onirim.getHand().show().get(index).getType().equalsIgnoreCase("LABYRINTH")){
                    //Card type is Labyrinth
                    if (onirim.getLabyrinthStack().showLastCard() == null) {
                        // the Labyrinth stack is empty
                        if (onirim.getLabyrinthStack().addCard((Labyrinth) onirim.getHand().discard(index))) {
                            cardFound = onirim.getDeck().searchCard(new Door(DoorCommand(((Labyrinth) (onirim.getLabyrinthStack().showLastCard())).getColor()), ((Labyrinth) (onirim.getLabyrinthStack().showLastCard())).getColor()));
                            if (cardFound != null) {
                                onirim.getDoorStack().addCard(cardFound);
                                onirim.getDeck().shuffle();
                            }
                        }
                        onirim.setState(onirim.getBuyState());
                        valid = true;
                    } else {   //the Labyrinth stack isn't empty
                        if (((Labyrinth) onirim.getLabyrinthStack().showLastCard()).getSymbol().equals(((Labyrinth) onirim.getHand().show().get(index)).getSymbol())) {
                            //The Last card played have the same symbol that card you wanna play
                            System.out.println("You Can´t Play that card because of the symbol.");
                            valid = true;
                        } else {
                            if (onirim.getLabyrinthStack().addCard((Labyrinth) onirim.getHand().discard(index))) {
                                cardFound = onirim.getDeck().searchCard(new Door(DoorCommand(((Labyrinth) (onirim.getLabyrinthStack().showLastCard())).getColor()), ((Labyrinth) (onirim.getLabyrinthStack().showLastCard())).getColor()));
                                if (cardFound != null) {
                                    onirim.getDoorStack().addCard(cardFound);
                                    onirim.getDeck().shuffle();
                                }
                            }
                            onirim.setState(onirim.getBuyState());
                            valid = true;
                        }
                    }
                } else {
                    //Card Type is Tower
                    if(onirim.getTowerStack().showRightCard() == null){
                       onirim.getTowerStack().addCardRight(onirim.getHand().discard(index));
                       onirim.setState(onirim.getBuyState());
                       valid=true;
                    }else{
                        do{
                            System.out.println("Choose side to play the Tower card. (RIGHT or LEFT)");
                            aux = sc.nextLine();
                        }while(!aux.equalsIgnoreCase("RIGHT") && !aux.equalsIgnoreCase("LEFT"));
                    
                        if(aux.equalsIgnoreCase("RIGHT")){
                            if(((Tower)onirim.getTowerStack().showRightCard()).getSymbolRight().contentEquals
                                    (((Tower)onirim.getHand().show().get(index)).getSymbolLeft()))
                                    System.out.println("Não pode Jogar essa carta");
                            else{
                                onirim.getTowerStack().addCardRight(onirim.getHand().discard(index));
                                onirim.setState(onirim.getBuyState());
                                valid=true;
                            }
                        }
                        if(aux.equalsIgnoreCase("LEFT")){
                            if(((Tower)onirim.getTowerStack().showLeftCard()).getSymbolLeft().contentEquals
                                    (((Tower)onirim.getHand().show().get(index)).getSymbolRight()))
                                    System.out.println("Não pode Jogar essa carta");
                            else{
                                onirim.getTowerStack().addCardLeft(onirim.getHand().discard(index));
                                onirim.setState(onirim.getBuyState());
                                valid=true;
                            }
                        }
                    }
                }
            }
            if (onirim.getDoorStack().VerifyAllDoorsCollected() && onirim.getTowerStack().isBlock()) {
                onirim.setState(onirim.getFinalState());
            }
        } while (valid == false);
    }

    @Override
    public void discard() {

        int index;
        boolean valid = false;

        do {
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

            } else {
                if(onirim.getHand().show().get(index).getType().equalsIgnoreCase("LABYRINTH")){
                    if (((Labyrinth) onirim.getHand().show().get(index)).getSymbol().equals("KEY")) {
                        //Make Prophecy
                        onirim.getDiscardStack().addCard(onirim.getHand().discard(index));
                        //Buy Fase
                        onirim.setState(onirim.getProphecyState());
                        onirim.event();
                        valid = true;
                    } else {
                        onirim.getDiscardStack().addCard(onirim.getHand().discard(index));
                        onirim.setState(onirim.getBuyState());
                        valid = true;
                    }
                }else{
                    //discard Tower
                    onirim.getDiscardStack().addCard(onirim.getHand().discard(index));
                    onirim.setState(onirim.getProphecyState());
                    onirim.event();
                    valid = true;
                    
                }
            }
        } while (valid == false);
    }

    @Override
    public void draw() {
    }

    @Override
    public void shuffle() {
    }

//    public void Prophecy() {
//
//        int index, k = 0;
//        boolean valid = false;
//        List<Card> cards = new ArrayList<Card>();
//        List<Card> cardsToDeck = new ArrayList<Card>();
//
//        cards.addAll(onirim.getDeck().showTopCards());
//        if (cards != null) {
//            do {
//                System.out.println("PROPHECY");
//
//                for (int j = 0; j < cards.size(); j++) {
//                    System.out.println(cards.get(j));
//                }
//
//
//                System.out.println("Choose a card to discard from the top of the deck: ");
//
//                aux = sc.nextLine();
//
//                // Card its in sequence?
//                index = -1;
//                for (int i = 0; i < cards.size(); i++) {
//                    if (cards.get(i).getCommand().equalsIgnoreCase(aux)) {
//                        index = i;
//                        break;
//                    }
//                }
//                if (index == -1) {
//                    System.out.println("Command don't exist or the card you want, isn't on sequence");
//                } else {
//                    // Card is in the sequence
//                    //discard the card
//                    onirim.getDiscardStack().addCard(cards.remove(index));
//
//                    // reorganize the other 4 cards
//                    while (cards.size() > 0) {
//
//                        k++;
//
//                        for (int j = 0; j < cards.size(); j++) {
//                            System.out.println(cards.get(j));
//                        }
//
//                        System.out.println("Choose a card to put in " + k + " position on deck");
//
//                        aux = sc.nextLine();
//
//                        index = -1;
//                        for (int i = 0; i < cards.size(); i++) {
//                            if (cards.get(i).getCommand().equalsIgnoreCase(aux)) {
//                                index = i;
//                                break;
//                            }
//                        }
//
//                        if (index == -1) {
//                            System.out.println("Command don't exist or the card you want, isn't on the sequence");
//                            k--;
//                        } else {
//                            //Put the card on aux stack
//                            cardsToDeck.add(cards.remove(index));
//                        }
//
//                    }
//                    //put the cards on the top of the deck
//                    onirim.getDeck().addBegin(cardsToDeck);
//                    valid = true;
//                }
//            } while (valid == false);
//        }
//    }

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

    @Override
    public void event() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
