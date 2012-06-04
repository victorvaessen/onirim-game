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
import onirim.entity.Labyrinth;

/**
 *
 * @author Bino
 */
public class NigthmareState implements State {

     private Onirim onirim;
    Scanner sc = new Scanner(System.in);
    private String aux;
    
    public NigthmareState(Onirim onirim) {
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
        
        int result;
        
        System.out.println("NIGHTMARE");
        
        do{
            System.out.println(" Choose a Nightmare: \n");
            System.out.println("1 - Discard a key card: \n");
            System.out.println("2 - Removing a Door card from the DoorStack and put it on limbo: \n");
            System.out.println("3 - See the 5 top cards of deck, put the nightmares and doors to limbo and discarding the others \n");
            System.out.println("4 - Discard the hand and buy another like on the beginning");

            aux = sc.nextLine();
        
            if(aux.equalsIgnoreCase("1")){
                result=this.NightMare1();
            }   
            if(aux.equalsIgnoreCase("2")){
                result=this.NightMare2();
                
            }   
            if(aux.equalsIgnoreCase("3")){
                result=this.NightMare3();    
            }   
            if(aux.equalsIgnoreCase("4")){
               result=this.NightMare4();
            }
            else{
                System.out.println("Opcao inválida");
                result=0;
            }
        }while(result==0);
        
        if(result==-1){
            //deck não tem mais cartas
            onirim.setState(onirim.getFinalLostState());
        }
        else
            onirim.setState(onirim.getBuyState());
    }
    
    public int NightMare1(){
        
        int index=-1;
        int k = 0;
        boolean valid = false;
        List<Card> cards = new ArrayList<Card>();
        List<Card> cardsToDeck = new ArrayList<Card>();
        
        do{
            System.out.println(onirim.getHand().toString());
            
            System.out.println("Choose the key card to discard: ");

            aux = sc.nextLine();
            index=-1;
            for (int i = 0; i < onirim.getHand().show().size(); i++) {
                if (onirim.getHand().show().get(i).getCommand().equalsIgnoreCase(aux)) {
                    if(((Labyrinth) onirim.getHand().show().get(i)).getSymbol().equalsIgnoreCase("KEY")){
                        index = i;
                    }else
                        index=-2;
                        System.out.println("A Carta que escolheu não é uma carta chave");
                    break;
                }
            }
        }while(index<-1);
        if (index == -1) {
            return 0; // não consegue realizar comando
        }
        else{
            onirim.getDiscardStack().addCard(onirim.getHand().discard(index));

            cards.addAll(onirim.getDeck().showTopCards());
            if (cards != null) {
                do {
                   
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
                return 1; // realizou comando com sucesso
            }
            else
                return -1; // não existem cartas no deck  
            
        }     
    }
    
    public int NightMare2() {
        
        int index;
        
        System.out.println(onirim.getDoorStack().toString() + "\n");
        
        System.out.println("Choose a card Door to discard from the Doorstack");
        
        aux = sc.nextLine();
        
        index = -1;
        for (int i = 0; i < onirim.getDoorStack().showAll().size(); i++) {
            if (onirim.getDoorStack().showAll().get(i).getCommand().equalsIgnoreCase(aux)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return 0;//não tem a carta que pretende
        } else {
            onirim.getLimbo().addCard(onirim.getDoorStack().getCard(index));
            return 1;
        }  
    }
    
    public int NightMare3() {

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

            return 1; // comando sucesso
        }

        return -1; // não existem mais cartas  no deck
    }
    
    public int NightMare4(){
        
        boolean badHand;
        onirim.getDiscardStack().addCards(onirim.getHand().discardAll());
        
        onirim.getHand().init(onirim.getDeck().buyCards());
        
        if(onirim.getHand().show().size()<5)
        {
            return -1;
        }
        do {
            badHand = false;
            for (int i = 0; i < onirim.getHand().show().size(); i++) {
                if (onirim.getHand().show().get(i).getType().equals("DOOR")
                        || onirim.getHand().show().get(i).getType().equals("NIGHTMARE")) {
                    onirim.getLimbo().addCard(onirim.getHand().discard(i));
                    if(onirim.getDeck().deckSize()>0){
                        onirim.getHand().buyCard(onirim.getDeck().drawCard());
                        badHand = true;
                    }
                    else
                        return -1;
                }
            }
        } while (badHand);
        
        onirim.getDeck().addLimboCards(onirim.getLimbo().clear());
        onirim.getDeck().shuffle();
        
        return 1;
    }
    
}
