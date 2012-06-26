/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package onirim.state;

import java.util.List;
import java.util.Scanner;
import onirim.OnirimExpansion;
import onirim.entity.Card;
import onirim.entity.Labyrinth;

/**
 *
 * @author Bino
 */
public class NigthmareStateExpansion implements State {

    private OnirimExpansion onirim;
    Scanner sc = new Scanner(System.in);
    private String aux;

    public NigthmareStateExpansion(OnirimExpansion onirim) {
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

        int result = 0;

        System.out.println("NIGHTMARE");

        do {
            System.out.println(" Choose a Nightmare: \n");
            System.out.println("1 - Discard a key card: \n");
            System.out.println("2 - Removing a Door card from the DoorStack and put it on limbo: \n");
            System.out.println("3 - See the 5 top cards of deck, put the nightmares and doors to limbo and discarding the others \n");
            System.out.println("4 - Discard the hand and buy another like on the beginning");

            aux = sc.nextLine();

            if (aux.equalsIgnoreCase("1")) {
                if (this.verifyCard(onirim.getHand().show(), "LABYRINTH")) {
                    //tem carta chave na mão
                    onirim.setState(onirim.getNightmareStateKey());
                    onirim.event();
                    result = 1;
                } else //não tem carta chave na mão
                {
                    System.out.println(" Não tem cartas de chave");
                    result = 0;
                }
            }
            if (aux.equalsIgnoreCase("2")) {
                if (!onirim.getDoorStack().showAll().isEmpty()) {
                    //a pilha de portas não está vazia
                    onirim.setState(onirim.getNightmareStateDoor());
                    onirim.event();
                    result = 1;
                } else // a pilha de portas está vazia
                {
                    System.out.println(" Não tem cartas de porta");
                    result = 0;
                }
            }
            if (aux.equalsIgnoreCase("3")) {
                onirim.setState(onirim.getNightmareStateTop());
                onirim.event();
                result = 1;
            }
            if (aux.equalsIgnoreCase("4")) {
                if (onirim.getDeck().deckSize() >= 5) {
                    onirim.setState(onirim.getNightmareStateDiscard());
                    onirim.event();
                    result = 1;
                } else {
                    result = -1;
                }
            }
            if (!aux.equalsIgnoreCase("1") && !aux.equalsIgnoreCase("2") && !aux.equalsIgnoreCase("3") && !aux.equalsIgnoreCase("4")) {
                    System.out.println("Opcao inválida");
                    result = 0;
            }
            
        }while (result == 0);

            if (!onirim.getTowerStack().isBlock()) {
                onirim.setState(onirim.getNightmareTowerState());
                onirim.event();
            }

            if (result == -1) {
                //deck não tem mais cartas
                onirim.setState(onirim.getFinalState());
            } else {
                onirim.setState(onirim.getBuyState());
            }
        
    }

    

    public boolean verifyCard(List<Card> cards, String type) {

        int index;

        index = -1;
        for (int i = 0; i < cards.size(); i++) {
            if (type.equalsIgnoreCase("LABYRINTH")) {
                if (cards.get(i).getType().equalsIgnoreCase(type)) {
                    if (((Labyrinth) cards.get(i)).getSymbol().equalsIgnoreCase("KEY")) {
                        index = i;
                        break;
                    }
                }
            } else {
                if (cards.get(i).getType().equalsIgnoreCase(type)) {
                    index = i;
                    break;
                }
            }
        }
        if (index == -1) {
            return false;
        }
        return true;

    }
}
