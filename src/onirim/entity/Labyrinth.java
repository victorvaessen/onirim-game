/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package onirim.entity;

/**
 *
 * @author Marco António
 */
public class Labyrinth extends Card {
        
    private String color;
    private String symbol;

    public Labyrinth(String symbol, String color) {
        super("LABYRINTH");
        this.symbol = symbol;
    }
    
    public String getColor() {
        return color;
    }

    public String getSymbol() {
        return symbol;
    }
    
    @Override
    public String toString() {
        return "LABYRINTH " + color + " " + symbol;
    }
}