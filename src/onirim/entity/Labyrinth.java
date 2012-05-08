/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package onirim.entity;

/**
 *
 * @author Marco António
 */
public class Labyrinth extends Entity {
    
    private String symbol;

    public Labyrinth(String symbol, String color, String type) {
        super(color, type);
        this.symbol = symbol;
    }
    
}
