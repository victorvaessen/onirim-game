/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package onirim.state;

import java.util.Scanner;
import onirim.Onirim;

/**
 *
 * @author Bino
 */
public class NigthmareStateDoor implements State {

    private Onirim onirim;
    Scanner sc = new Scanner(System.in);
    private String aux;

    public NigthmareStateDoor(Onirim onirim) {
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
        
        do{
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
            if(index==-1)
            {
                System.out.println("Carta que pediu não se encontra na pilha de portas");
            }
        }while(index==-1);
        
        onirim.getLimbo().addCard(onirim.getDoorStack().getCard(index));
        }
    }
    