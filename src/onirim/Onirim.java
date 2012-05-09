/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package onirim;

import onirim.entity.*;
import onirim.state.State;

/**
 *
 * @author Marco António
 */
public class Onirim {

    private State startState;
    private State playState;
    private State state = startState;
    private Deck deck;
    private Hand hand;
    private Limbo limbo;
    private DiscardStack discardStack;
    private LabyrinthStack labyrinthStack;
    private DoorStack doorStack;

    public Onirim() {
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public DiscardStack getDiscardStack() {
        return discardStack;
    }

    public void setDiscardStack(DiscardStack discardStack) {
        this.discardStack = discardStack;
    }

    public DoorStack getDoorStack() {
        return doorStack;
    }

    public void setDoorStack(DoorStack doorStack) {
        this.doorStack = doorStack;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public LabyrinthStack getLabyrinthStack() {
        return labyrinthStack;
    }

    public void setLabyrinthStack(LabyrinthStack labyrinthStack) {
        this.labyrinthStack = labyrinthStack;
    }

    public Limbo getLimbo() {
        return limbo;
    }

    public void setLimbo(Limbo limbo) {
        this.limbo = limbo;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getPlayState() {
        return playState;
    }

    public State getStartState() {
        return startState;
    }
}
