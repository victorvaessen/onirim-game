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
public class FinalWinState implements State {

    private Onirim onirim;

    public FinalWinState(Onirim onirim) {
        this.onirim = onirim;
    }

    @Override
    public void buyHand() {
        System.out.println("Chegou ao Final do Jogo");
        System.out.println("Parabéns Ganhou o Jogo");
    }

    @Override
    public void play() {
        System.out.println("Chegou ao Final do Jogo");
        System.out.println("Parabéns Ganhou o Jogo");
    }

    @Override
    public void discard() {
        System.out.println("Chegou ao Final do Jogo");
        System.out.println("Parabéns Ganhou o Jogo");
    }

    @Override
    public void draw() {
        System.out.println("Chegou ao Final do Jogo");
        System.out.println("Parabéns Ganhou o Jogo");
    }

    @Override
    public void shuffle() {
        System.out.println("Chegou ao Final do Jogo");
        System.out.println("Parabéns Ganhou o Jogo");
    }

    @Override
    public void event() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
