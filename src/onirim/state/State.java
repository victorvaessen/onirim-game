/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package onirim.state;

/**
 *
 * @author Marco António
 */
public interface State {

    public void buyHand();//comprar mão
    public void play();//jogar uma carta
    public void discard();//descartar uma carta
    public void draw();//biscar uma carta
    public void shuffle();//baralhar
    public void event();// Profecia ou Pesadelos
    
}
