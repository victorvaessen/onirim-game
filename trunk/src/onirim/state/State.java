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

    public void play();
    public void discard();
    public void buy();
    public void shuffling();
    
}
