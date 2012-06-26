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
public class OnirimExpansion extends Onirim{

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
    private State nightmareTowerState;
    private State prophecyState;
    
    private Deck deck;
    private Hand hand;
    private Limbo limbo;
    private DiscardStack discardStack;
    private LabyrinthStack labyrinthStack;
    private DoorStack doorStack;
    private TowerStack towerStack;

    public OnirimExpansion() {
        startState = new StartStateExpansion(this);
        playState = new PlayStateExpansion(this);
        buyState = new BuyStateExpansion(this);
        shuffleState= new ShuffleStateExpansion(this);
        finalState= new FinalState(this);
        nightmareState= new NigthmareStateExpansion(this);
        prophecyState = new ProphecyStateExpansion(this);
        nightmareStateKey = new NigthmareStateKeyE(this);
        nightmareStateDoor = new NigthmareStateDoorE(this);
        nightmareStateDiscard = new NigthmareStateDiscardHandE(this);
        nightmareStateTop = new NigthmareStateTopE(this);
        nightmareTowerState = new NightmareTowerState(this);
        
        
        deck = new Deck();
        deck.addExpansionCards();
        hand = new Hand();
        limbo = new Limbo();
        discardStack = new DiscardStack();
        labyrinthStack = new LabyrinthStack();
        doorStack = new DoorStack();
        towerStack = new TowerStack();
        
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

    public TowerStack getTowerStack() {
        return towerStack;
    }

    public void setTowerStack(TowerStack towerStack) {
        this.towerStack = towerStack;
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

    public State getProphecyState() {
        return prophecyState;
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

    public State getNightmareTowerState() {
        return nightmareTowerState;
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
