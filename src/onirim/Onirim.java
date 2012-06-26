/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package onirim;

import onirim.entity.*;
import onirim.state.*;

/**
 *
 * @author Marco António
 */
public class Onirim {

    private State startState;
    private State playState;
    private State buyState;
    private State shuffleState;
    private State finalState;
    private State state;
    private State nightmareState;
    private State nightmareStateKey;
    private State nightmareStateDoor;
    private State nightmareStateDiscard;
    private State nightmareStateTop;
    private State prophecyState;
    
    private Deck deck;
    private Hand hand;
    private Limbo limbo;
    private DiscardStack discardStack;
    private LabyrinthStack labyrinthStack;
    private DoorStack doorStack;

    public Onirim() {
        startState = new StartState(this);
        playState = new PlayState(this);
        buyState = new BuyState(this);
        shuffleState= new ShuffleState(this);
        finalState= new FinalState(this);
        nightmareState= new NigthmareState(this);
        nightmareStateKey = new NigthmareStateKey(this);
        nightmareStateDoor = new NigthmareStateDoor(this);
        nightmareStateDiscard = new NigthmareStateDiscardHand(this);
        nightmareStateTop = new NigthmareStateTop(this);
        prophecyState = new ProphecyState(this);
        
        
        deck = new Deck();
        hand = new Hand();
        limbo = new Limbo();
        discardStack = new DiscardStack();
        labyrinthStack = new LabyrinthStack();
        doorStack = new DoorStack();
        
        state = startState;
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

    public State getBuyState() {
        return buyState;
    }

    public State getShuffleState() {
        return shuffleState;
    }

    public State getFinalState() {
        return finalState;
    }
    
    public State getNightmareState() {
        return nightmareState;
    }

    public State getNightmareStateDiscard() {
        return nightmareStateDiscard;
    }

    public State getNightmareStateDoor() {
        return nightmareStateDoor;
    }

    public State getNightmareStateKey() {
        return nightmareStateKey;
    }

    public State getNightmareStateTop() {
        return nightmareStateTop;
    }

    public State getProphecyState() {
        return prophecyState;
    }
    
    
    

    public void buyHand() {
        state.buyHand();
    }

    public void play() {
        state.play();
    }

    public void discard() {
        state.discard();
    }

    public void draw() {
        state.draw();
    }
    
    public void shuffle(){
        state.shuffle();
    }
    
    public void event(){
        state.event();
    }
    
}
