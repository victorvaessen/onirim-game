/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package onirim.state;

import java.util.Scanner;
import onirim.OnirimExpansion;
import onirim.entity.Tower;

/**
 *
 * @author Bino
 */
public class NightmareTowerState implements State {

    private OnirimExpansion onirim;
    Scanner sc = new Scanner(System.in);
    private String aux;

    public NightmareTowerState(OnirimExpansion onirim) {
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
        int index;
        boolean confirm = false;

        if (!onirim.getTowerStack().ShowAll().isEmpty()) {
            do {
                System.out.println("Escolha o que pretende fazer");
                System.out.println("1 - Colocar Nightmare no Limbo");
                System.out.println("2 - Descartar uma carta torre da pilha");
                aux = sc.nextLine();
            } while (!aux.equalsIgnoreCase("1") && !aux.equalsIgnoreCase("2"));
        } 
        else{
            aux="1";
        }

        if (aux.equalsIgnoreCase("1")) {
            onirim.getLimbo().addCard(onirim.getDiscardStack().getLastNightmareCard());
        }
        if (aux.equalsIgnoreCase("2")) {

            for (int i = 0; i < onirim.getTowerStack().ShowAll().size(); i++) {
                System.out.println(onirim.getTowerStack().ShowAll().get(i).toString());
            }
            do {
                System.out.println("Escolha a Carta Torre que pretende remover");

                aux = sc.nextLine();

                index = -1;
                for (int i = 0; i < onirim.getDoorStack().showAll().size(); i++) {
                    if (onirim.getDoorStack().showAll().get(i).getCommand().equalsIgnoreCase(aux)) {
                        index = i;
                        break;
                    }
                }

                if (index == -1) {
                    System.out.println("Command don't exist or cards aren't there");
                } else {
                    if (((Tower) onirim.getTowerStack().showLeftCard(index)).getSymbolRight().
                            contains(((Tower) onirim.getTowerStack().showRightCard(index)).getSymbolLeft())) {
                        System.out.println("Simbolos das cartas adjacentes não podem ficar juntos");
                    } else {
                        onirim.getDiscardStack().addCard(onirim.getTowerStack().removeCard(index));
                    }
                    confirm = true;
                }
            } while (confirm == false);
        }
    }
}


