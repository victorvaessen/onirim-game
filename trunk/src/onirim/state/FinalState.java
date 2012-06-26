/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package onirim.state;

import onirim.Onirim;

/**
 *
 * @author Bino
 */
public class FinalState implements State {

    private Onirim onirim;
    

    public FinalState(Onirim onirim) {
        this.onirim = onirim;
    }

    @Override
    public void buyHand() {
        if(onirim.getDeck().deckSize()<1){
            System.out.println("Chegou ao Final do Jogo");
            System.out.println("Perdeu o Jogo");
        }
        System.out.println("Chegou ao Final do Jogo");
        System.out.println("Parabéns Ganhou o Jogo");
    }

    @Override
    public void play() {
       if(onirim.getDeck().deckSize()<1){
            System.out.println("Chegou ao Final do Jogo");
            System.out.println("Perdeu o Jogo");
        }
        System.out.println("Chegou ao Final do Jogo");
        System.out.println("Parabéns Ganhou o Jogo");
    }

    @Override
    public void discard() {
        if(onirim.getDeck().deckSize()<1){
            System.out.println("Chegou ao Final do Jogo");
            System.out.println("Perdeu o Jogo");
        }
        System.out.println("Chegou ao Final do Jogo");
        System.out.println("Parabéns Ganhou o Jogo");
    }

    @Override
    public void draw() {
       if(onirim.getDeck().deckSize()<1){
            System.out.println("Chegou ao Final do Jogo");
            System.out.println("Perdeu o Jogo");
        }
        System.out.println("Chegou ao Final do Jogo");
        System.out.println("Parabéns Ganhou o Jogo");
    }

    @Override
    public void shuffle() {
       if(onirim.getDeck().deckSize()<1){
            System.out.println("Chegou ao Final do Jogo");
            System.out.println("Perdeu o Jogo");
        }
        System.out.println("Chegou ao Final do Jogo");
        System.out.println("Parabéns Ganhou o Jogo");
    }

    @Override
    public void event() {
       if(onirim.getDeck().deckSize()<1){
            System.out.println("Chegou ao Final do Jogo");
            System.out.println("Perdeu o Jogo");
        }
        System.out.println("Chegou ao Final do Jogo");
        System.out.println("Parabéns Ganhou o Jogo");
    }
}
